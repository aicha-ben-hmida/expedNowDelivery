package com.example.demo.ModelDTO;

import com.example.demo.ModelDomain.User;
import com.example.demo.ModelDomain.UserRole;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class UserDTO{
 private String firstName;
 private String lastName;
private String email;
private String numTel;
private String password;
private String cin;
private String address;
private UserRole role;
private boolean active;


 
 public UserDTO( String firstName,String lastName,String password,String email,String numTel, String cin,String address, UserRole role, boolean active)
 {
    this.firstName = firstName;
    this.lastName = lastName;
    this.password = password;
    this.email = email;
    this.active = active;
    this.numTel = numTel;
    this.cin = cin;
    this.address = address;
    this.role = role;
 }



 /**
 * @return the firstName
 */
 public String getFirstName() {
   return firstName;
 }



 /**
 * @param firstName the firstName to set
 */
 public void setFirstName(String firstName) {
   this.firstName = firstName;
 }



 /**
 * @return the lastName
 */
 public String getLastName() {
   return lastName;
 }



 /**
 * @param lastName the lastName to set
 */
 public void setLastName(String lastName) {
   this.lastName = lastName;
 }



 /**
 * @return the email
 */
 public String getEmail() {
   return email;
 }



 /**
 * @param email the email to set
 */
 public void setEmail(String email) {
   this.email = email;
 }



 /**
 * @return the numTel
 */
 public String getNumTel() {
   return numTel;
 }



 /**
 * @param numTel the numTel to set
 */
 public void setNumTel(String numTel) {
   this.numTel = numTel;
 }



 /**
 * @return the password
 */
 public String getPassword() {
   return password;
 }



 /**
 * @param password the password to set
 */
 public void setPassword(String password) {
   this.password = password;
 }



 /**
 * @return the cin
 */
 public String getCin() {
   return cin;
 }



 /**
 * @param cin the cin to set
 */
 public void setCin(String cin) {
   this.cin = cin;
 }



 /**
 * @return the address
 */
 public String getAddress() {
   return address;
 }



 /**
 * @param address the address to set
 */
 public void setAddress(String address) {
   this.address = address;
 }



 /**
 * @return the role
 */
 public UserRole getRole() {
   return role;
 }



 /**
 * @param role the role to set
 */
 public void setRole(UserRole role) {
   this.role = role;
 }



 /**
 * @return the active
 */
 public boolean isActive() {
   return active;
 }



 /**
 * @param active the active to set
 */
 public void setActive(boolean active) {
   this.active = active;
 }
  
 

}