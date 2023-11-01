package lk.ijse.Easy_car_rental.repo;

import lk.ijse.Easy_car_rental.entity.Admin;
import lk.ijse.Easy_car_rental.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DriverRepo extends JpaRepository<Driver,String> {
    @Query(value = "select * from Driver where username=:nm",nativeQuery = true)
    Driver searchDriverWithUserName(@Param("nm") String UserName);
}
