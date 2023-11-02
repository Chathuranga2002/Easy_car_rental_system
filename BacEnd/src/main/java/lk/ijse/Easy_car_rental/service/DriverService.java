package lk.ijse.Easy_car_rental.service;

import lk.ijse.Easy_car_rental.dto.AdminDTO;
import lk.ijse.Easy_car_rental.dto.CustomerDTO;
import lk.ijse.Easy_car_rental.dto.DriverDTO;
import lk.ijse.Easy_car_rental.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface DriverService {
    void getAdmin(DriverDTO dto);

     void saveDriver(DriverDTO dto);

    void deleteDriver(String id);

    void updateDriver(DriverDTO dto);

    ArrayList<DriverDTO> getAllDrivers();

}
