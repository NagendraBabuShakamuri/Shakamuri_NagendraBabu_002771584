/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author nbabu
 */
public class Doctor{
  private Person person;
  private Hospital hospital;
  private String medicalSpeciality;
  private String doctorType;
  private int yearsOfExp;
  private String password;
  public Doctor(Person person, Hospital hospital, String medicalSpeciality, String doctorType, int yearsOfExp, String password){
    this.person = person;
    this.hospital = hospital;
    this.medicalSpeciality = medicalSpeciality;
    this.doctorType = doctorType;
    this.yearsOfExp = yearsOfExp;
    this.password = password;
  }
  public void setMedicalSpeciality(String speciality){
    medicalSpeciality = speciality;
  }
  public void setYearsOfExp(int exp){
    yearsOfExp = exp;
  }
  public Person getPerson()
  {
    return person;
  }
  public String getMedicalSpeciality(){
    return medicalSpeciality;
  }
  public int getYearsOfExp(){
    return yearsOfExp;
  }
}
