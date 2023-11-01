package lk.ijse.Easy_car_rental.service.impl;

import lk.ijse.Easy_car_rental.dto.AdminDTO;
import lk.ijse.Easy_car_rental.entity.Admin;
import lk.ijse.Easy_car_rental.repo.AdminRepo;
import lk.ijse.Easy_car_rental.repo.CarRepo;
import lk.ijse.Easy_car_rental.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepo adminRepo;

    @Autowired
    ModelMapper mapper;

    @Autowired
    private AdminRepo repo;

    @Override
    public void getAdmin(AdminDTO dto) {
        Admin map = mapper.map(dto, Admin.class);
        System.out.println(map.getUsername());
        System.out.println(map.getPassword());
        Admin admin = repo.searchAdminWithUserName(map.getUsername());

        if (admin.getUsername().equals(map.getUsername())&& admin.getPassword().equals(map.getPassword())){

        }else {
            throw new RuntimeException( " wrong username or password");
        }

    }
}
