/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author nbabu
 */
public class House {
    private int houseId;
    private Community community;
    private City city;
    
    House(int houseId, String communityName, String communityZipCode, String cityName, String cityState, String cityCountry){
       this.houseId = houseId;
       community = new Community(communityName, communityZipCode);
       city = new City(cityName, cityState, cityCountry);
    }
}
