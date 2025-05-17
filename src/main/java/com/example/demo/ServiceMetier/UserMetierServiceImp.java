package com.example.demo.ServiceMetier;


import java.util.List;
import java.util.Optional;

import java.lang.RuntimeException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.poc.domain.User;
import com.example.poc.domain.UserRole;
import com.example.poc.repository.UserRepository;
import com.example.poc.model.UserDTO;
import com.example.poc.mapper.UserMapper;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class UserMetierServiceImpl  implements UserMetierService{


private final UserRepository userRepository ;
private final PasswordEncoder passwordEncoder;
private final UserDTO userDTO;
private final UserMapper userMapper;
private final User user;

public UserMetierServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, UserDTO userDTO, UserMapper userMapper,User user) {

    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
    this.userDTO = userDTO;
    this.userMapper = userMapper;
    this.user=user;

}

public User saveUser(User user){
    user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
    return userRepository.save(user);
    
}

public User getUserById(Long id) {
    return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("user avec ID " + id + " non trouvé"));

}

public List<User> getAllUserByRole(){
    return userRepository.findByRoleNot(UserRole.SUPER_ADMIN);
   }

public void desactiveUser(Long id){

    Optional <User> userOpt = userRepository.findById(id);
    if (userOpt.isPresent()){
        User user =  userOpt.get();
        user.setActive(false); 
        userRepository.save(user);
    } else {
        throw new RuntimeException("user not found");
    }


}
public void activateUser(Long id) {

    User user = getUserById(id);
    user.setActive(true); // Réactivation
    userRepository.save(user);
}

 public User putUser(Long id, User user){

     User userExisting = getUserById(id);
     userExisting.setUsername(user.getUsername());
     userExisting.setFirstName(user.getFirstName());
     userExisting.setLastName(user.getLastName());
     userExisting.setNumTel(user.getNumTel());
     userExisting.setAddress(user.getAddress());
     userExisting.setCin(user.getCin());
     userExisting.setEmail(user.getEmail());
     userExisting.setRole(user.getRole());
    
    if (user.getPassword() != null && !user.getPassword().isEmpty()){
        userExisting.setPassword(user.getPassword());
    }

      return  saveUser(userExisting);  // Sauvegarde de l'utilisateur mis à jour

    }
 



/**
 * @return the userRepository
 */
public UserRepository getUserRepository() {
    return userRepository;
}

/**
 * @return the passwordEncoder
 */
public PasswordEncoder getPasswordEncoder() {
    return passwordEncoder;
}

/**
 * @return the userDTO
 */
public UserDTO getUserDTO() {
    return userDTO;
}

/**
 * @return the userMapper
 */
public UserMapper getUserMapper() {
    return userMapper;
}

/**
 * @return the user
 */
public User getUser() {
    return user;
}
 





}