package lk.ijse.Easy_car_rental.dto;

import lk.ijse.Easy_car_rental.entity.CarRent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CustomerDTO {
    private String nicNo;
    private String name;
    private String address;
    private String email;
    private String contactNo;
    private String username;
    private String password;
    private MultipartFile nicFrontImg;
    private String status;

}
