package lk.ijse.Easy_car_rental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CarDTO {

    private String registrationNO;
    private String brand;
    private String type;
    private int passengersCount;
    private String transmissionType;
    private String fuelType;
    private String color;
    private double completeKm;
    private String status;

    private MultipartFile frontViewImg;
    private MultipartFile backViewImg;
    private MultipartFile sideViewImg;
    private MultipartFile internalViewImg;

    private double dailyRate;
    private double freeKmForDay;
    private double monthlyRate;
    private double freeKmForMonth;
    private double pricePerExtraKm;

}
