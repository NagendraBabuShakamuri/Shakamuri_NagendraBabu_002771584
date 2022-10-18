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
    Person(int id, String name, String gender, long mobileNumber, String email){
      this.id = id;
      this.name = name;
      this.gender = gender;
      this.mobileNumber = mobileNumber;
      this.email = email;
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
}
