package lk.ijse.Easy_car_rental.service.impl;

import lk.ijse.Easy_car_rental.dto.CarDTO;
import lk.ijse.Easy_car_rental.dto.DriverDTO;
import lk.ijse.Easy_car_rental.entity.Car;
import lk.ijse.Easy_car_rental.entity.Customer;
import lk.ijse.Easy_car_rental.entity.Driver;
import lk.ijse.Easy_car_rental.repo.CarRepo;
import lk.ijse.Easy_car_rental.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService {
    @Autowired
    CarRepo itemRepo;

    @Autowired
    ModelMapper mapper;

    @Autowired
    private CarRepo repo;

    @Override
    public void saveCar(CarDTO dto) throws IOException {
        if (repo.existsById(dto.getRegistrationNO())) {
            throw new RuntimeException(dto.getRegistrationNO() + " already exists");
        }
        String uploadDir = "D:\\WorkingZone\\Easy_car_rental_system\\BacEnd\\src\\main\\resources\\Car\\";
        MultipartFile frontViewImg = dto.getFrontViewImg();
        MultipartFile backViewImg = dto.getBackViewImg();
        MultipartFile sideViewImg = dto.getSideViewImg();
        MultipartFile internalViewImg = dto.getInternalViewImg();

        frontViewImg.transferTo(new File(uploadDir, frontViewImg.getOriginalFilename()));
        backViewImg.transferTo(new File(uploadDir, backViewImg.getOriginalFilename()));
        sideViewImg.transferTo(new File(uploadDir, sideViewImg.getOriginalFilename()));
        internalViewImg.transferTo(new File(uploadDir, internalViewImg.getOriginalFilename()));

        repo.save(new Car(
                dto.getRegistrationNO(),
                dto.getBrand(),
                dto.getType(),
                dto.getPassengersCount(),
                dto.getTransmissionType(),
                dto.getFuelType(),
                dto.getColor(),
                dto.getCompleteKm(),
                dto.getStatus(),
                frontViewImg.getOriginalFilename(),
                backViewImg.getOriginalFilename(),
                sideViewImg.getOriginalFilename(),
                internalViewImg.getOriginalFilename(),
                dto.getDailyRate(),
                dto.getFreeKmForDay(),
                dto.getMonthlyRate(),
                dto.getFreeKmForMonth(),
                dto.getPricePerExtraKm()

        ));
    }

    @Override
    public ArrayList<Car> getAllDrivers() {
        List<Car> all = repo.findAll();
          return  new ArrayList<>(all);
//        return mapper.map(repo.findAll(), new TypeToken<ArrayList<Car>>() {
//        }.getType());
    }


    @Override
    public void updateCarStatus(String registrationNO, String status) {
        if (repo.existsById(registrationNO)) {
            repo.updateCarStatus(status, registrationNO);
        } else {
            throw new RuntimeException("No Such Car To Update");
        }
    }

    @Override
    public Car searchCar(String registrationNO) {
        return mapper.map(repo.findById(registrationNO).get(), Car.class);
    }


}
