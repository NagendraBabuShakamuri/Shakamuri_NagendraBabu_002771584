/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author nbabu
 */
public class Hospital {    
    private int id;
    private String name;
    private long mobileNumber;
    private Community community;
    public Hospital(int id, String name, Community community)
    {
      this.id = id;
      this.name = name;
      this.community = community;
    }
    public int getId()
    {
      return id;
    }
    public String getName()
    {
      return name;
    }
    public Community getCommunity()
    {
      return community;
    }
}
