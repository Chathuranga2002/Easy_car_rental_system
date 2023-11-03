package lk.ijse.Easy_car_rental.service.impl;

import lk.ijse.Easy_car_rental.dto.CarDTO;
import lk.ijse.Easy_car_rental.dto.DriverDTO;
import lk.ijse.Easy_car_rental.entity.Car;
import lk.ijse.Easy_car_rental.entity.Driver;
import lk.ijse.Easy_car_rental.repo.CarRepo;
import lk.ijse.Easy_car_rental.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

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
    public void saveCar(CarDTO dto) {
        if (repo.existsById(dto.getRegistrationNO())){
            throw new RuntimeException("Car already Exists.. Please enter another ID..");
        }
        repo.save(mapper.map(dto, Car.class));
    }

    @Override
    public ArrayList<CarDTO> getAllDrivers() {
        return mapper.map(repo.findAll(), new TypeToken<ArrayList<CarDTO>>() {
        }.getType());
    }





}
