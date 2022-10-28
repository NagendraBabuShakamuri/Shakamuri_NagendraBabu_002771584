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
    private static ArrayList<Patient> patientList = new ArrayList<>();
    public static void addPatient(Patient p)
    {
      patientList.add(p);
    }
    public static void setPatientList(ArrayList<Patient> newPatientList)
    {
      patientList = newPatientList;
    }
    public static ArrayList<Patient> getPatientList(){
      return patientList;
    }
}
