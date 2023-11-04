package lk.ijse.Easy_car_rental.repo;

import lk.ijse.Easy_car_rental.entity.Admin;
import lk.ijse.Easy_car_rental.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer,String> {
    @Query(value = "select * from Customer where username=:nm",nativeQuery = true)
    Customer searchCustomerWithUserName(@Param("nm") String UserName);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Customer SET name=:name,address=:address,email=:email,contactNo=:contactNo,password=:password WHERE nicNo=:nicNo", nativeQuery = true)
    void updateCustomer(@Param("nicNo") String nicNo, @Param("name") String name, @Param("address") String address, @Param("email") String email, @Param("contactNo") String contactNo, @Param("password") String password);


    @Modifying
    @Transactional
    @Query(value = "UPDATE Customer SET status=:status WHERE nicNo=:nicNo", nativeQuery = true)
    void updateCarRentStatus(@Param("nicNo") String rentId, @Param("status") String status);

}
