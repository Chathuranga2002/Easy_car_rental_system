package lk.ijse.Easy_car_rental.controller;

import lk.ijse.Easy_car_rental.dto.CarRentDTO;
import lk.ijse.Easy_car_rental.dto.CustomerDTO;
import lk.ijse.Easy_car_rental.service.CarRentService;
import lk.ijse.Easy_car_rental.service.CarService;
import lk.ijse.Easy_car_rental.service.CustomerService;
import lk.ijse.Easy_car_rental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/CarRent")
@CrossOrigin // will support to cors requests
public class CarRentController {

    @Autowired
    CarRentService service;

    @GetMapping(path = "/generateRentId", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil generateRentId() {
        return new ResponseUtil("ok", "Ok", service.generateRentId());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveCustomer(@ModelAttribute CarRentDTO dto ){
        service.saveCarRent(dto);
        return new ResponseUtil("OK","Successfully Registered..!",null);
    }
}
