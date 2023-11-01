package lk.ijse.Easy_car_rental.service;

import lk.ijse.Easy_car_rental.dto.AdminDTO;
import lk.ijse.Easy_car_rental.dto.DriverDTO;
import lk.ijse.Easy_car_rental.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverService {
    void getAdmin(DriverDTO dto);
}
