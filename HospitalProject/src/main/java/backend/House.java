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
public class House {
    private int id;
    private String name;
    private String owner;    
    private Community community;
    private static ArrayList<House> houseList = new ArrayList<>();
    public House(int id, String name, String owner, Community community){
       this.id = id;
       this.name = name;
       this.owner = owner;
       this.community = community;
    }
    public void addHouseList(){
      houseList.add(this);
    }
    public int getId(){
      return id;
    }
    public String getName(){
      return name;
    }
    public String getOwner(){
      return owner;
    }
    public void setCommunity(Community community){
      this.community = community;
    }    
    public Community getCommunity(){
      return community;
    }
    public static void setHouseList(ArrayList<House> newHouseList){
      houseList = newHouseList;
    }
    public static ArrayList<House> getHouseList(){
      return houseList;
    }
}
