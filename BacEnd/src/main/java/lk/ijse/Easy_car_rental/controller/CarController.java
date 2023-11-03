package lk.ijse.Easy_car_rental.controller;

import lk.ijse.Easy_car_rental.dto.CarDTO;
import lk.ijse.Easy_car_rental.entity.Car;
import lk.ijse.Easy_car_rental.service.CarService;
import lk.ijse.Easy_car_rental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Car")
@CrossOrigin // will support to cors requests
public class CarController {

    @Autowired
    CarService service;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveCar(@ModelAttribute CarDTO dto ){
        service.saveCar(dto);
        return new ResponseUtil("OK","Successfully Registered..!",null);
    }

    @GetMapping
    public ResponseUtil getAllCar() {
        return new ResponseUtil("OK", "Successfully Loaded. : ", service.getAllDrivers());

    }




}
