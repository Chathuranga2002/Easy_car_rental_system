package lk.ijse.Easy_car_rental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Payment {
    @Id
    private String rentId;
    private String nicNo;;
    private double advance;
    private double timeCost;
    private double extraKm;
    private double damage;
    private double total;


}
