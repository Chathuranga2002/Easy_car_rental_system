package lk.ijse.Easy_car_rental.service;


import lk.ijse.Easy_car_rental.dto.AdminDTO;
import lk.ijse.Easy_car_rental.service.impl.AdminServiceImpl;

import java.util.List;

public interface AdminService {
    void saveAdmin(AdminDTO dto);

    void updateAdmin(AdminDTO dto);

    void deleteAdmin(String id);

}
