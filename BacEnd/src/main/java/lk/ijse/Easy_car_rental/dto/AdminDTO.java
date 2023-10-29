package lk.ijse.Easy_car_rental.dto;

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
public class AdminDTO {
    private String adminId;
    private String name;
    private String username;
    private String password;
}
