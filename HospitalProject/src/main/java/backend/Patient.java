/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author nbabu
 */
public class Patient{
    private Person person;
    private String isInsured;
    private String dateOfBirth;
    private String password;
    public Patient(Person person, String isInsured, String dateOfBirth, String password){
      this.person = person;
      this.isInsured = isInsured;
      this.dateOfBirth = dateOfBirth;
      this.password = password;
    }
    public Person getPerson()
    {
      return person;
    }
}
