package lk.ijse.Easy_car_rental.controller;

import lk.ijse.Easy_car_rental.dto.CarRentDTO;
import lk.ijse.Easy_car_rental.dto.CustomerDTO;
import lk.ijse.Easy_car_rental.entity.CarRent;
import lk.ijse.Easy_car_rental.service.CarRentService;
import lk.ijse.Easy_car_rental.service.CarService;
import lk.ijse.Easy_car_rental.service.CustomerService;
import lk.ijse.Easy_car_rental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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

    @PostMapping
    public ResponseUtil saveCarRent(@RequestBody CarRent dto ){
        try {
            System.out.println(dto.getRentId());
            System.out.println(dto.getCar().getRegistrationNO());
            System.out.println(dto.getDriver().getNic());
            System.out.println(dto.getCustomer().getNicNo());
            service.saveCarRent(dto);
            return new ResponseUtil("Ok", "Successfully added...!", dto.getRentId());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtil("Error", "Failed to save customer", null);
        }

    }

    @GetMapping(path = "/getCarRents/{status}/{licenceNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCarRentsByDrivingLicence(@PathVariable String status, @PathVariable String licenceNo) {
        System.out.println(status+""+licenceNo);
        return new ResponseUtil("200", "Ok", service.getCarRentsByDrivingLicenceNo(status, licenceNo));
    }

    @GetMapping(path = "/getMyCarRents/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getMyCarRents(@PathVariable String customerId) {
        return new ResponseUtil("200", "Ok", service.getCarRentsByCustomerId(customerId));
    }

    @GetMapping(path = "/{rentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCarRent(@PathVariable String rentId) {
        return new ResponseUtil("200", "Ok", service.searchCarRent(rentId));
    }

    @DeleteMapping(path = {"/{rentId}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCarRent(@PathVariable String rentId) {
        service.deleteCarRent(rentId);
        return new ResponseUtil("200", "Deleted", null);
    }

    @PutMapping(path = "/{rentId}/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCarRentStatus(@PathVariable String rentId, @PathVariable String status) {
        service.updateCarRentStatus(rentId, status);
        return new ResponseUtil("200", "Ok", null);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCarRents() {
        return new ResponseUtil("200", "Ok", service.getAllCarRents());
    }
}
