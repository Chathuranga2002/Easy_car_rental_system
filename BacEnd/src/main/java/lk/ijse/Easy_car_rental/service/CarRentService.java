package lk.ijse.Easy_car_rental.service;

import lk.ijse.Easy_car_rental.entity.CarRent;

import java.util.ArrayList;

public interface CarRentService  {
    String generateRentId();
    void saveCarRent(CarRent dto);
    ArrayList<CarRent> getCarRentsByDrivingLicenceNo(String status, String licenceNo);
    ArrayList<CarRent> getCarRentsByCustomerId(String customerId);
    CarRent searchCarRent(String rentId);
    void deleteCarRent(String rentId);
    void updateCarRentStatus(String rentId, String status);
}
