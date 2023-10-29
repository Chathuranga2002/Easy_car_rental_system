package lk.ijse.Easy_car_rental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Customer {
    @Id
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
