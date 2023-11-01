package lk.ijse.Easy_car_rental.repo;

import lk.ijse.Easy_car_rental.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminRepo extends JpaRepository<Admin,String> {
    @Query(value = "select * from Admin where username=:nm",nativeQuery = true)
    Admin searchAdminWithUserName(@Param("nm") String UserName);


}
