package lk.ijse.Easy_car_rental.service;

import lk.ijse.Easy_car_rental.dto.CarDTO;
import lk.ijse.Easy_car_rental.dto.DriverDTO;
import lk.ijse.Easy_car_rental.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface CarService  {
    public void saveCar(CarDTO dto);

    ArrayList<CarDTO> getAllDrivers();
}
