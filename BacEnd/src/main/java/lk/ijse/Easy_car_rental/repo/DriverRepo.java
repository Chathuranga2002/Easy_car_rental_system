package lk.ijse.Easy_car_rental.repo;

import lk.ijse.Easy_car_rental.entity.Admin;
import lk.ijse.Easy_car_rental.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepo extends JpaRepository<Driver,String> {
}
