package lk.ijse.Easy_car_rental.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CustomerDTO {
    private String cus_id;
    private String name;
    private String email;
    private String contact;
    private String nic;
    private String nic_img;
    private String password;

}
