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



    // Define a one-to-one relationship with the Price entity
    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private Price price;

    // Define a one-to-one relationship with the Price img
    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private CarImg images;

}
