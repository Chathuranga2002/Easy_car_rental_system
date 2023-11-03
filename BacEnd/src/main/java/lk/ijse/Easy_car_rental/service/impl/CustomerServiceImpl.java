package lk.ijse.Easy_car_rental.service.impl;

import lk.ijse.Easy_car_rental.dto.CustomerDTO;
import lk.ijse.Easy_car_rental.entity.Customer;
import lk.ijse.Easy_car_rental.repo.CustomerRepo;
import lk.ijse.Easy_car_rental.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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

    @Override
    public void saveCustomer(CustomerDTO dto) throws IOException {
        if (repo.existsById(dto.getNicNo())) {
            throw new RuntimeException(dto.getNicNo() + " already exists");
        }
        String uploadDir = "D:\\WorkingZone\\Easy_car_rental_system\\BacEnd\\src\\main\\resources\\file\\";
        MultipartFile nicFrontImg = dto.getNicFrontImg();

        nicFrontImg.transferTo(new File(uploadDir, nicFrontImg.getOriginalFilename()));

        repo.save(new Customer(
                dto.getNicNo(),
                dto.getName(),
                dto.getAddress(),
                dto.getEmail(),
                dto.getContactNo(),
                dto.getUsername(),
                dto.getPassword(),
                nicFrontImg.getOriginalFilename(),
                dto.getStatus()

        ));
    }

    @Override
    public CustomerDTO searchCustomer(String customerId) {
        return mapper.map(repo.searchCustomerWithUserName(customerId), CustomerDTO.class);
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() {
        return mapper.map(repo.findAll(), new TypeToken<ArrayList<CustomerDTO>>() {

        }.getType());
    }
}
