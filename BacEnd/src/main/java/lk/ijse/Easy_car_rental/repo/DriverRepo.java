package lk.ijse.Easy_car_rental.repo;

import lk.ijse.Easy_car_rental.entity.Admin;
import lk.ijse.Easy_car_rental.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DriverRepo extends JpaRepository<Driver,String> {
    @Query(value = "select * from Driver where username=:nm",nativeQuery = true)
    Driver searchDriverWithUserName(@Param("nm") String UserName);

    @Query(value = "SELECT * FROM Driver WHERE availability=true ORDER BY RAND() LIMIT 1",nativeQuery = true)
    List<Driver> getRandomDriver();
}
