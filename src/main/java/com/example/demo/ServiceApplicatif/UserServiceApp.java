package com.example.demo.ServiceApplicatif;


import com.example.demo.Model.UserDTO;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.Domain.User;
import com.example.demo.Domain.UserRole;
import com.example.demo.Servicemetier.UserMetierService;
import com.example.demo.servicemetier.UserMetierServiceImpl;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceApp {

    final private UserMapper userMapper;
    final private UserMetierService userMetierService;
   final private PasswordEncoder passwordEncoder;


    public UserServiceApp(UserMapper userMapper, UserMetierService userMetierService, PasswordEncoder passwordEncoder){
        this.userMapper= userMapper;
        this.userMetierService= userMetierService;
        this.passwordEncoder= passwordEncoder;
    }

    
    //Méthode pour enregistrer un user avec un mot de passe encodé
     public UserDTO saveUser(UserDTO userDTO){
        //convertir en entity 

        User  user= userMapper.toEntity(userDTO);
      //sauvgarde dans la base 
        User usersaved = userMetierService.saveUser(user);
       
        return userMapper.toDto(usersaved);

    }

 
    public UserDTO getUserById(Long id) {
        User user = userMetierService.getUserById(id);
       return  userMapper.toDto(user);
           
    }

    public List<UserDTO> getAllUsersByRole(){
        List<User> users = userMetierService.getAllUserByRole();
        return userMapper.toDtoList(users);
       }
    
  
       public void desactiveUser(Long id){
        
            userMetierService.desactiveUser(id);

       }


public void activateUser(Long id) {
     
    userMetierService.activateUser(id);

}


public User putUser(Long id, UserDTO userDTO){
    
      User user = userMapper.toEntity(userDTO);
      User userupdated = userMetierService.putUser(id, user);
      return userupdated;
}
}
    /* 
    public AdminDTO creerSuperAdminSiAbsent(){
        if(!adminMetierService.superAdminExiste()){
            Admin superAdmin = new Admin(
                "SuperAdmin",
                "admin123",
                "superadmin@example.com",
                AdminRole.SUPER_ADMIN,
                true
            );
            superAdmin.setPassword(passwordEncoder.encode(superAdmin.getPassword()));
            Admin saved = adminMetierService.saveAdmin(superAdmin);
            return adminMapper.toDTO(saved);
                }
        return null;
    }

*/