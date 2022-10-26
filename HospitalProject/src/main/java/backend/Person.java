/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author nbabu
 */
public class Person {
    private int id;
    private String name;
    private String gender;
    private long mobileNumber;
    private String email;
    private House house;
    private String role;
    private String password;
    Person(int id, String name, String gender, long mobileNumber, String email, House house, String role, String password){
      this.id = id;
      this.name = name;
      this.gender = gender;
      this.mobileNumber = mobileNumber;
      this.email = email;
      this.house = house;
      this.role = role;
      this.password = password;
    }
    public int getId(){
      return id;
    }
    public String getName(){
      return name;
    }
    public String getGender(){
      return gender;
    }
    public long mobileNumber(){
      return mobileNumber;
    }
    public String getEmail(){
      return email;
    }
    public House getHouse(){
      return house;
    }
    public String getRole(){
      return role;
    }
    public String getPassword(){
      return password;
    }
}
