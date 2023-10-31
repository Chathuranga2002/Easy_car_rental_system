package lk.ijse.Easy_car_rental.service.impl;

import lk.ijse.Easy_car_rental.entity.Car;
import lk.ijse.Easy_car_rental.repo.CarRepo;
import lk.ijse.Easy_car_rental.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
    public void saveCar(Car dto) {
        if (repo.existsById(dto.getRegistrationNO())){
            throw new RuntimeException(dto.getRegistrationNO()+ " : Item already registered.!");
        }
        repo.save(dto);
    }
}
