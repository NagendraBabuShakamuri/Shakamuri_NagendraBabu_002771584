/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author nbabu
 */
import java.util.*;
public class City {
    private String name;
    private String state;
    private static ArrayList<City> cityList = new ArrayList<>();
    City(String name, String state){
      this.name = name;
      this.state = state;
      cityList.add(this);
    }
    public String getName(){
     return name;
    }
    public String getState(){
      return state;
    }
    public static ArrayList<City> getCityList(){
      return cityList;
    }
    public static void main(String[] args){
      City c1 = new City("Quincy", "Massachussets");
      City c2 = new City("Boston", "Massachussets");
      System.out.println("City List:");
      for(City c: getCityList())
        System.out.println("Name: " + c.getName() + "\n" + "State: " + c.getState());
    }
}
