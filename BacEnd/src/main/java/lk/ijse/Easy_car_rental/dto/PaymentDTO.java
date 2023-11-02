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
public class PaymentDTO {
    private String rentId;
    private String nicNo;;
    private double advance;
    private double timeCost;
    private double extraKm;
    private double damage;
    private double total;

}
