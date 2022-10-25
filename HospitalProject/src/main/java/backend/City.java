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
public class City {
    private int id;
    private String name;
    private String state;
    private static ArrayList<City> cityList = new ArrayList<>();
    public City(int id, String name, String state){
      this.id = id;
      this.name = name;
      this.state = state;      
    }
    public void addCityList(){
      cityList.add(this);
    }  
    public int getId(){
      return id; 
    }  
    public String getName(){
      return name;
    }
    public String getState(){
      return state;
    }
    public static void setCityList(ArrayList<City> newCityList){
      cityList = newCityList;
    }
    public static ArrayList<City> getCityList(){
      return cityList;
    }
}
