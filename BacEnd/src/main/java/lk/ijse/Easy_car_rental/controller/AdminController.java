package lk.ijse.Easy_car_rental.controller;

import lk.ijse.Easy_car_rental.dto.AdminDTO;
import lk.ijse.Easy_car_rental.service.AdminService;

import lk.ijse.Easy_car_rental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Admin")
@CrossOrigin
public class AdminController {
    @Autowired
    AdminService service;


    @PostMapping(path = "/{check}")
    public ResponseUtil chekPassword( AdminDTO dto){

        try{
            service.getAdmin(dto);
            return new ResponseUtil("Ok","true",dto);
        }catch (Exception e){
            return new ResponseUtil("Ok","False",dto);
        }

    }
}
