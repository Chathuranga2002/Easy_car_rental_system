package lk.ijse.Easy_car_rental.service;

import lk.ijse.Easy_car_rental.dto.AdminDTO;
import lk.ijse.Easy_car_rental.dto.CarDTO;
import lk.ijse.Easy_car_rental.dto.CustomerDTO;
import lk.ijse.Easy_car_rental.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerService {
    void getAdmin(CustomerDTO dto);
    public void saveCustomer(CustomerDTO dto);
}
