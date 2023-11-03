package lk.ijse.Easy_car_rental.repo;

import lk.ijse.Easy_car_rental.entity.Admin;
import lk.ijse.Easy_car_rental.entity.CarRent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarRentRepo extends JpaRepository<CarRent,String> {

    @Query(value = "SELECT rentId FROM CarRent ORDER BY rentId DESC LIMIT 1",nativeQuery = true)
    String generateRentId();
}
