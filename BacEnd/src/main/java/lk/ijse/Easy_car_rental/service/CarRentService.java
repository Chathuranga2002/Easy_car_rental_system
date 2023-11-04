package lk.ijse.Easy_car_rental.service;

import lk.ijse.Easy_car_rental.dto.CarDTO;
import lk.ijse.Easy_car_rental.dto.CarRentDTO;
import lk.ijse.Easy_car_rental.entity.CarRent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRentService  {
    String generateRentId();
    void saveCarRent(CarRent dto);

}
