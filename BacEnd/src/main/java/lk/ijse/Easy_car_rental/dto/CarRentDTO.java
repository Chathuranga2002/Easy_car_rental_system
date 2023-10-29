package lk.ijse.Easy_car_rental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CarRentDTO {
    private String rentId;
    private String rentType;
    private String pickUpDate;
    private String returnDate;
    private CustomerDTO customer;
    private CarDTO car;
    private DriverDTO driver;



}
