package lk.ijse.Easy_car_rental.controller;

import lk.ijse.Easy_car_rental.dto.AdminDTO;
import lk.ijse.Easy_car_rental.dto.CustomerDTO;
import lk.ijse.Easy_car_rental.dto.DriverDTO;
import lk.ijse.Easy_car_rental.service.AdminService;
import lk.ijse.Easy_car_rental.service.DriverService;
import lk.ijse.Easy_car_rental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Driver")
@CrossOrigin
public class DriverControllor {
    @Autowired
    DriverService service;

    @PostMapping(path ="/{check}")
    public ResponseUtil chekPassword(DriverDTO dto){
        service.getAdmin(dto);
        return new ResponseUtil("Ok","true",dto);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveDriver(@ModelAttribute DriverDTO dto ){
        service.saveDriver(dto);
        return new ResponseUtil("OK","Successfully Registered..!",null);
    }

    @GetMapping
    public ResponseUtil getAllCustomers() {
        return new ResponseUtil("OK", "Successfully Loaded. : ", service.getAllDrivers());

    }
    @GetMapping(path = "/getRandomDriver",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getRandomDriver(){
        return new ResponseUtil("200","Ok",service.getRandomDriver());
    }


}
