package lk.ijse.Easy_car_rental.service.impl;

import lk.ijse.Easy_car_rental.dto.DriverDTO;
import lk.ijse.Easy_car_rental.entity.Admin;
import lk.ijse.Easy_car_rental.entity.Customer;
import lk.ijse.Easy_car_rental.entity.Driver;
import lk.ijse.Easy_car_rental.repo.AdminRepo;
import lk.ijse.Easy_car_rental.repo.DriverRepo;
import lk.ijse.Easy_car_rental.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DriverServiceImpl  implements DriverService {


    @Autowired
    ModelMapper mapper;

    @Autowired
    private DriverRepo repo;
    @Override
    public void getAdmin(DriverDTO dto) {
        Driver map = mapper.map(dto, Driver.class);
        Driver driver = repo.searchDriverWithUserName(map.getUsername());
        if (driver.getUsername().equals(map.getUsername())&& driver.getPassword().equals(map.getPassword())){

        }else {
            throw new RuntimeException( " wrong username or password");
        }

    }

    @Override
    public void saveDriver(DriverDTO dto) {
        if (repo.existsById(dto.getNic())){
            throw new RuntimeException("Car already Exists.. Please enter another ID..");
        }
        repo.save(mapper.map(dto, Driver.class));
    }

    public void deleteDriver(String driver) {
        if (!repo.existsById(driver)) {
            throw new RuntimeException("Wrong ID. Please enter valid ID..");
        }
        repo.deleteById(driver);
    }


    public void updateDriver(DriverDTO dto) {
        if (!repo.existsById(dto.getLicenceNo())) {
            throw new RuntimeException("Customer Not Exists.. Please enter Valid ID..!");
        }
        repo.save(mapper.map(dto, Driver.class));
    }

    public ArrayList<DriverDTO> getAllDrivers() {
        return mapper.map(repo.findAll(), new TypeToken<ArrayList<DriverDTO>>() {
        }.getType());
    }

    public void getDriver(DriverDTO dto) {
        Driver map = mapper.map(dto, Driver.class);
        Driver driver = repo.searchDriverWithUserName(map.getUsername());
        if (driver.getUsername().equals(map.getUsername()) && driver.getPassword().equals(map.getPassword())) {

        } else {
            throw new RuntimeException(" wrong username or password");
        }
    }

    @Override
    public List<DriverDTO> getRandomDriver() {
        return mapper.map(repo.getRandomDriver(), new TypeToken<List<DriverDTO>>() {
        }.getType());
    }


}
