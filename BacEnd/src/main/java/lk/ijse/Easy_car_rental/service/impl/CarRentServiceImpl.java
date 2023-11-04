package lk.ijse.Easy_car_rental.service.impl;

import lk.ijse.Easy_car_rental.dto.CarDTO;
import lk.ijse.Easy_car_rental.dto.CarRentDTO;
import lk.ijse.Easy_car_rental.entity.Car;
import lk.ijse.Easy_car_rental.entity.CarRent;
import lk.ijse.Easy_car_rental.repo.CarRentRepo;
import lk.ijse.Easy_car_rental.repo.CarRepo;
import lk.ijse.Easy_car_rental.repo.DriverRepo;
import lk.ijse.Easy_car_rental.service.CarRentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CarRentServiceImpl implements CarRentService {
    @Autowired
    ModelMapper mapper;

    @Autowired
    private CarRentRepo repo;
    @Autowired
    private DriverRepo drRepo;
    @Autowired
    private CarRepo carRepo;

    @Override
    public String generateRentId() {
        String lastId = repo.generateRentId();
        String id = "";

        if (lastId != null) {
            int tempId = Integer.parseInt(lastId.split("-")[1]);
            tempId = tempId + 1;
            if (tempId <= 9) {
                id = "RT0-000" + tempId;
            } else if (tempId <= 99) {
                id = "RT0-00" + tempId;
            } else if (tempId <= 999) {
                id = "RT0-0" + tempId;
            } else if (tempId <= 9999) {
                id = "RT0-" + tempId;
            }
        } else {
            id = "RT0-0001";
        }
        return id;
    }

    @Override
    public void saveCarRent(CarRent dto) {
        // carrent save
        if (repo.existsById(dto.getRentId())){
            throw new RuntimeException("Car already Exists.. Please enter another ID..");
        }
        repo.save(dto);
        System.out.println("err 1");
        //  set car status rent

        carRepo.updateCarStatus("rent",dto.getCar().getRegistrationNO());
        System.out.println("err 2");
//          set driver status false
        drRepo.updateDriverNonAvailable(dto.getDriver().getNic());
        System.out.println("err 3");

    }




}
