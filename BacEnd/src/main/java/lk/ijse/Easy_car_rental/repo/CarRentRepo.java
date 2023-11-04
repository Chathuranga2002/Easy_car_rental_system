package lk.ijse.Easy_car_rental.repo;

import lk.ijse.Easy_car_rental.entity.Admin;
import lk.ijse.Easy_car_rental.entity.CarRent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CarRentRepo extends JpaRepository<CarRent,String> {

    @Query(value = "SELECT rentId FROM CarRent ORDER BY rentId DESC LIMIT 1",nativeQuery = true)
    String generateRentId();

    @Query(value = "SELECT * from CarRent where status=:status AND driverId=:driverId", nativeQuery = true)
    List<CarRent> getAllByDrivingLicenceNo(@Param("status") String status, @Param("driverId") String driverId);

    @Query(value = "SELECT * FROM CarRent WHERE nicNo=:nicNo",nativeQuery = true)
    List<CarRent> getAllByCustomerId(@Param("nicNo") String nicNo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE CarRent SET status=:status WHERE rentId=:rentId", nativeQuery = true)
    void updateCarRentStatus(@Param("rentId") String rentId, @Param("status") String status);

}
