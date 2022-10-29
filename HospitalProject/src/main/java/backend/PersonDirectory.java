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
import java.util.Arrays;
public class PersonDirectory {
    private static Person commAdmin = new Person(1, "Community Admin", "male", 7818170970L, "commadmin@gmail.com", null, "Community Administrator", "root");
    private static Person hosAdmin = new Person(2, "Hospital Admin", "male", 9701998653L, "hosadmin@gmail.com", null, "Hospital Administrator", "root");
    private static Person sysAdmin = new Person(3, "System Admin", "male", 8919873191L, "sysadmin@gmail.com", null, "System Administrator", "root");
    private static ArrayList<Person> personDirectory = new ArrayList<>(Arrays.asList(commAdmin, hosAdmin, sysAdmin));  
    public void addPerson(Person p)
    {
      personDirectory.add(p);
    }
    public static ArrayList<Person> getPersonList()
    {
      return personDirectory;
    }
}
