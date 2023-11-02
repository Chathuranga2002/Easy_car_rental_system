package lk.ijse.Easy_car_rental.service;

import lk.ijse.Easy_car_rental.dto.CustomerDTO;
import lk.ijse.Easy_car_rental.dto.PaymentDTO;
import lk.ijse.Easy_car_rental.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentService  {
    public void savePayment(PaymentDTO dto);
}
