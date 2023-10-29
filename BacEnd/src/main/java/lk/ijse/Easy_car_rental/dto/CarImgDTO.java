package lk.ijse.Easy_car_rental.dto;

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
public class CarImgDTO {

    private String registrationNO;
    private String frontViewImg;
    private String backViewImg;
    private String sideViewImg;
    private String internalViewImg;


}
