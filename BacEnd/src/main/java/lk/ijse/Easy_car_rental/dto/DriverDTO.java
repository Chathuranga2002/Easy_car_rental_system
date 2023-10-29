package lk.ijse.Easy_car_rental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class DriverDTO {
    private String nic;
    private String licenceNo;
    private String name;
    private String address;
    private String contactNo;
    private String username;
    private String password;
    private boolean availability;

}
