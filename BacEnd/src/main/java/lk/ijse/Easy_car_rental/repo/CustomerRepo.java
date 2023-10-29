package lk.ijse.Easy_car_rental.repo;

import lk.ijse.Easy_car_rental.entity.Admin;
import lk.ijse.Easy_car_rental.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,String> {
}
