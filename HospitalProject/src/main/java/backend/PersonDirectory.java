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
    private static ArrayList<Person> personDirectory = new ArrayList<>(Arrays.asList(commAdmin));
    public void addPerson(Person p)
    {
      personDirectory.add(p);
    }
    public static ArrayList<Person> getPersonList()
    {
      return personDirectory;
    }
}
