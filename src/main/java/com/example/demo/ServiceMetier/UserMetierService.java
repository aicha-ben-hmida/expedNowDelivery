package com.example.demo.ServiceMetier;


import com.example.demo.Domain.User;
import com.example.demo.Model.UserDTO;

import java.util.List;

public interface UserMetierService {


    User saveUser(User user);
    User getUserById(Long id);
    List<User> getAllUserByRole();
    void desactiveUser(Long id);
    void activateUser(Long id) ;
    User putUser(Long id, User user);
}