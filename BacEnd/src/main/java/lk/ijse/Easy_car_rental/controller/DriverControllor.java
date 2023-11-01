package lk.ijse.Easy_car_rental.controller;

import lk.ijse.Easy_car_rental.dto.AdminDTO;
import lk.ijse.Easy_car_rental.dto.DriverDTO;
import lk.ijse.Easy_car_rental.service.AdminService;
import lk.ijse.Easy_car_rental.service.DriverService;
import lk.ijse.Easy_car_rental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
