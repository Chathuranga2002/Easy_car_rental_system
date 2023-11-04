package lk.ijse.Easy_car_rental.controller;

import lk.ijse.Easy_car_rental.dto.CarDTO;
import lk.ijse.Easy_car_rental.entity.Car;
import lk.ijse.Easy_car_rental.service.CarService;
import lk.ijse.Easy_car_rental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/Car")
@CrossOrigin // will support to cors requests
public class CarController {

    @Autowired
    CarService service;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveCar(@ModelAttribute CarDTO dto ){
        try {
            service.saveCar(dto);
            return new ResponseUtil("Ok", "Successfully added...!", dto.getRegistrationNO());
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseUtil("Error", "Failed to save Car", null);
        }
    }

    @GetMapping
    public ResponseUtil getAllCar() {
        return new ResponseUtil("OK", "Successfully Loaded. : ", service.getAllDrivers());

    }

    @PutMapping(path = "/updateCarStatus/{registrationNO}/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCarStatus(@PathVariable String registrationNO, @PathVariable String status) {
        service.updateCarStatus(registrationNO, status);
        return new ResponseUtil("200", "Ok", null);
    }

    @GetMapping(path = "/{registrationNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCar(@PathVariable String registrationNo) {
        return new ResponseUtil("200", "Ok", service.searchCar(registrationNo));
    }
}
