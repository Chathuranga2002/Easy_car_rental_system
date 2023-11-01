package lk.ijse.Easy_car_rental.controller;



import lk.ijse.Easy_car_rental.dto.CustomerDTO;
import lk.ijse.Easy_car_rental.service.CustomerService;
import lk.ijse.Easy_car_rental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    CustomerService service;

    @PostMapping(path ="/{check}")
    public ResponseUtil chekPassword(CustomerDTO dto){
        service.getAdmin(dto);
        return new ResponseUtil("Ok","true",dto);
    }
}
