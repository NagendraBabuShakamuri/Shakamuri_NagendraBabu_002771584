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
public class Community {
    private String name;
    private String zipCode;
    private City city;
    private static ArrayList<Community> communityList = new ArrayList<>();
    Community(String name, String zipCode, City city){
      this.name = name;
      this.zipCode = zipCode;
      this.city = city;
    }
    public String getName(){
      return name;
    }
    public String zipCode(){
      return zipCode;
    }
    public City getCity(){
      return city;
    }
    public static ArrayList<Community> getCommunityList(){
      return communityList;
    }
    public static void main(String[] args){
     City city = new City("Boston", "Massachussets");
     for(City c: City.getCityList())
        System.out.println("Name: " + c.getName() + "\n" + "State: " + c.getState());
     Community c1 = new Community("2001 falls blvd street", "02169", city);
     System.out.println(c1.getName());
    }
}
