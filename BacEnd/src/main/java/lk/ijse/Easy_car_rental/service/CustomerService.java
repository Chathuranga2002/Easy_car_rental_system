package lk.ijse.Easy_car_rental.service;

import lk.ijse.Easy_car_rental.dto.CustomerDTO;

import java.io.IOException;
import java.util.ArrayList;

public interface CustomerService {
    void getAdmin(CustomerDTO dto);
    public void saveCustomer(CustomerDTO dto) throws IOException;
    CustomerDTO searchCustomer(String customerId);
    ArrayList<CustomerDTO> getAllCustomer();
}
