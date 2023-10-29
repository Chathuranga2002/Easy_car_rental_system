package lk.ijse.Easy_car_rental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Price {
    @Id
    private String registrationNO;
    private double dailyRate;
    private double freeKmForDay;
    private double monthlyRate;
    private double freeKmForMonth;
    private double pricePerExtraKm;


    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;

}
