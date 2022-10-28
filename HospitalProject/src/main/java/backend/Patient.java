/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;


/**
 *
 * @author nbabu
 */
import java.time.LocalDate;
public class Patient extends Person{
    private boolean isInsured;
    private LocalDate dateOfBirth;
    public Patient(int id, String name, String gender, long mobileNumber, String email, House house, String role, String password, boolean isInsured, LocalDate dateOfBirth){
      super(id, name, gender, mobileNumber, email, house, role, password);
      this.isInsured = isInsured;
      this.dateOfBirth = dateOfBirth;
    }
    public boolean getIsInsured()
    {
      return isInsured;
    }
    public LocalDate getDateOfBirth()
    {
      return dateOfBirth;
    }    
}
