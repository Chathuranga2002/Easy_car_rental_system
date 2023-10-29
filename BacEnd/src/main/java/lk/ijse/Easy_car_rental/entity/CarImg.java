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
public class CarImg {
    @Id
    private String registrationNO;
    private String frontViewImg;
    private String backViewImg;
    private String sideViewImg;
    private String internalViewImg;

    @OneToOne
    @JoinColumn(name = "car_Img")
    private Car car;

}
