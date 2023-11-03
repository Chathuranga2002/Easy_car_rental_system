package lk.ijse.Easy_car_rental.service;

import lk.ijse.Easy_car_rental.dto.CustomerDTO;
import lk.ijse.Easy_car_rental.entity.Customer;

import java.io.IOException;
import java.util.ArrayList;

public interface CustomerService {
    void getAdmin(CustomerDTO dto);
    public void saveCustomer(CustomerDTO dto) throws IOException;
    Customer searchCustomer(String customerId);
    ArrayList<Customer> getAllCustomer();
    void updateCustomer(CustomerDTO dto);
}
