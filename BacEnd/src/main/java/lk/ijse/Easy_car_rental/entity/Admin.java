package lk.ijse.Easy_car_rental.entity;

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
@Entity
public class Admin {
    @Id
    private String adminId;
    private String name;
    private String username;
    private String password;
}
