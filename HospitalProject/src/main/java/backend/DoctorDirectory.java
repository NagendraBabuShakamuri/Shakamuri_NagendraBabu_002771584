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
public class DoctorDirectory {
    private static ArrayList<Doctor> doctorList = new ArrayList<>();
    public static void addDoctor(Doctor d)
    {
      doctorList.add(d);
    }
    public static ArrayList<Doctor> getDoctorList(){
      return doctorList;
    }
}
