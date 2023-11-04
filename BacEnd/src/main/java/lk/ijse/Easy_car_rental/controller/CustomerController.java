package lk.ijse.Easy_car_rental.controller;



import lk.ijse.Easy_car_rental.dto.CarDTO;
import lk.ijse.Easy_car_rental.dto.CustomerDTO;
import lk.ijse.Easy_car_rental.service.CustomerService;
import lk.ijse.Easy_car_rental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/Customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    CustomerService service;

    @PostMapping(path ="/{check}")
    public ResponseUtil chekPassword(CustomerDTO dto){
        try {
        service.getAdmin(dto);
        return new ResponseUtil("Ok","true",dto);
        }catch (Exception e){
            return new ResponseUtil("Ok","False",dto);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveCustomer( CustomerDTO dto ){
        try {
            service.saveCustomer(dto);
            return new ResponseUtil("Ok", "Successfully added...!", dto.getNicNo());
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseUtil("Error", "Failed to save customer", null);
            }
    }


    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCustomer(@PathVariable String id) {
        return new ResponseUtil("200", "Ok", service.searchCustomer(id));
    }

    @GetMapping
    public ResponseUtil getAllCustomer() {
        return new ResponseUtil("OK", "Successfully Loaded. : ", service.getAllCustomer());

    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO dto) {
        service.updateCustomer(dto);
        return new ResponseUtil("200", "Updated", null);
    }

}
