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
public class HospitalDirectory {
    private static ArrayList<Hospital> hospitalList = new ArrayList<>();
    public void addHospital(Hospital h)
    {
      hospitalList.add(h);
    }
    public ArrayList<Hospital> getHospitalList(){
      return hospitalList;
    }
}
