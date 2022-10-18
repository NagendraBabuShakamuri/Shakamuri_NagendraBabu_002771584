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
    private Doctor doctor;
    private Encounter encounter;
    private Hospital hospital;
    private Community community;
    Patient(Person person){
      this.person = person;   
    }
       
}
