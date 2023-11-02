package lk.ijse.Easy_car_rental.controller;

import lk.ijse.Easy_car_rental.dto.CustomerDTO;
import lk.ijse.Easy_car_rental.dto.PaymentDTO;
import lk.ijse.Easy_car_rental.service.DriverService;
import lk.ijse.Easy_car_rental.service.PaymentService;
import lk.ijse.Easy_car_rental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Payment")
@CrossOrigin
public class PaymentController {
    @Autowired
    PaymentService service;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil savePayment(@ModelAttribute PaymentDTO dto ){
        service.savePayment(dto);
        return new ResponseUtil("OK","Successfully Registered..!",null);
    }
}
