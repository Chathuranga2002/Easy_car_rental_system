package lk.ijse.Easy_car_rental.service.impl;

import lk.ijse.Easy_car_rental.dto.PaymentDTO;
import lk.ijse.Easy_car_rental.entity.Customer;
import lk.ijse.Easy_car_rental.entity.Payment;
import lk.ijse.Easy_car_rental.repo.DriverRepo;
import lk.ijse.Easy_car_rental.repo.PaymentRepo;
import lk.ijse.Easy_car_rental.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    ModelMapper mapper;

    @Autowired
    private PaymentRepo repo;

    @Override
    public void savePayment(PaymentDTO dto) {
        if (repo.existsById(dto.getRentId())){
            throw new RuntimeException(".. Please enter another ID..");
        }
        repo.save(mapper.map(dto, Payment.class));
    }
}
