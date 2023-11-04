package lk.ijse.Easy_car_rental.service;

import lk.ijse.Easy_car_rental.dto.CarDTO;
import lk.ijse.Easy_car_rental.dto.DriverDTO;
import lk.ijse.Easy_car_rental.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface CarService  {
    public void saveCar(CarDTO dto) throws IOException;

    ArrayList<Car> getAllDrivers();

    void updateCarStatus(String registrationNO, String status);
    Car searchCar(String registrationNO);

}
