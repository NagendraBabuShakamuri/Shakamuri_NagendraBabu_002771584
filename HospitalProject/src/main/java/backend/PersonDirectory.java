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
public class PersonDirectory {
    private ArrayList<Person> personDirectory = new ArrayList<>();
    public void addPatient(Person p){
      personDirectory.add(p);
    }
}
