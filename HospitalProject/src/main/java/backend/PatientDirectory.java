/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author nbabu
 */
import java.util.ArrayList;
public class PatientDirectory {
    private ArrayList<Patient> patientDirectory;
    PatientDirectory(){
     patientDirectory = new ArrayList<>();
    }
    public void addPatient(Patient p){
      patientDirectory.add(p);
    }
}
