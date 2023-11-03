package lk.ijse.Easy_car_rental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Car {
    @Id
    private String registrationNO;
    private String brand;
    private String type;
    private int passengersCount;
    private String transmissionType;
    private String fuelType;
    private String color;
    private double completeKm;

    private String status;

    private String frontViewImg;
    private String backViewImg;
    private String sideViewImg;
    private String internalViewImg;

    private double dailyRate;
    private double freeKmForDay;
    private double monthlyRate;
    private double freeKmForMonth;
    private double pricePerExtraKm;


}
