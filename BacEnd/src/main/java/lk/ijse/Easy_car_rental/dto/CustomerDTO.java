package lk.ijse.Easy_car_rental.dto;

import lk.ijse.Easy_car_rental.entity.CarRent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CustomerDTO {
    private String cusId;
    private String name;
    private String address;
    private int contactNo;
    private String email;
    private String nicNo;
    private String nicFrontImg;
    private String licenceNo;
    private String licenceImg;
    private String username;
    private String password;


}
