package lk.ijse.Easy_car_rental.controller;

import lk.ijse.Easy_car_rental.entity.Car;
import lk.ijse.Easy_car_rental.service.CarService;
import lk.ijse.Easy_car_rental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Car")
@CrossOrigin // will support to cors requests
public class CarController {

    @Autowired
    CarService service;

    @PostMapping
    public ResponseUtil addCustomer(Car dto){
        service.saveCar(dto);
        return new ResponseUtil("Ok","Successfully Added",dto);
    }

}
