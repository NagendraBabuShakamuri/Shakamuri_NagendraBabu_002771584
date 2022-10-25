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
    private int id;
    private String name;
    private int zipCode;
    private City city;
    private static ArrayList<Community> communityList = new ArrayList<>();
    public Community(int id, String name, int zipCode, City city){
      this.id = id;
      this.name = name;
      this.zipCode = zipCode;
      this.city = city;
    }
    public void addCommunityList(){
      communityList.add(this);
    }
    public int getId(){
      return id;
    }
    public String getName(){
      return name;
    }
    public int getZipCode(){
      return zipCode;
    }
    public void setCity(City city){
      this.city = city;
    }
    public City getCity(){
      return city;
    }
    public static void setCommunityList(ArrayList<Community> newCommunityList){
      communityList = newCommunityList;
    }
    public static ArrayList<Community> getCommunityList(){
      return communityList;
    }
}
