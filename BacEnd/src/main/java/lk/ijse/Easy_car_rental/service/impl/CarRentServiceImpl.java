package lk.ijse.Easy_car_rental.service.impl;

import lk.ijse.Easy_car_rental.dto.CarDTO;
import lk.ijse.Easy_car_rental.dto.CarRentDTO;
import lk.ijse.Easy_car_rental.entity.Car;
import lk.ijse.Easy_car_rental.entity.CarRent;
import lk.ijse.Easy_car_rental.repo.CarRentRepo;
import lk.ijse.Easy_car_rental.repo.CarRepo;
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
    public void saveCarRent(CarRentDTO dto) {
        if (repo.existsById(dto.getRentId())){
            throw new RuntimeException("Car already Exists.. Please enter another ID..");
        }
        repo.save(mapper.map(dto, CarRent.class));


    }




}
