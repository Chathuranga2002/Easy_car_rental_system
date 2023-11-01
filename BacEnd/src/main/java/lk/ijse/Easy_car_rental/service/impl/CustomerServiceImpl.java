package lk.ijse.Easy_car_rental.service.impl;

import lk.ijse.Easy_car_rental.dto.CustomerDTO;
import lk.ijse.Easy_car_rental.entity.Admin;
import lk.ijse.Easy_car_rental.entity.Customer;
import lk.ijse.Easy_car_rental.repo.AdminRepo;
import lk.ijse.Easy_car_rental.repo.CustomerRepo;
import lk.ijse.Easy_car_rental.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepo adminRepo;

    @Autowired
    ModelMapper mapper;

    @Autowired
    private CustomerRepo repo;
    @Override
    public void getAdmin(CustomerDTO dto) {
        Customer map = mapper.map(dto, Customer.class);
        Customer customer = repo.searchCustomerWithUserName(map.getUsername());
        if (customer.getUsername().equals(map.getUsername())&& customer.getPassword().equals(map.getPassword())){

        }else {
            throw new RuntimeException( " wrong username or password");
        }

    }
}
