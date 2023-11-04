package lk.ijse.Easy_car_rental.repo;

import lk.ijse.Easy_car_rental.entity.Admin;
import lk.ijse.Easy_car_rental.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CarRepo extends JpaRepository<Car,String> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE Car SET status=:status WHERE registrationNO=:registrationNO", nativeQuery = true)
    void updateCarStatus(@Param("status") String status, @Param("registrationNO") String registrationNO);

}
