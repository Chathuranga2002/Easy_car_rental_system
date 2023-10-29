package lk.ijse.Easy_car_rental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PriceDTO {

    private String registrationNO;
    private double dailyRate;
    private double freeKmForDay;
    private double monthlyRate;
    private double freeKmForMonth;
    private double pricePerExtraKm;

}
