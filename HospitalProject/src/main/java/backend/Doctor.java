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
  private String medicalSpeciality;
  private int yearsOfExp;
  Doctor(Person person, String medicalSpeciality, int yearsOfExp){
    this.person = person;
    this.medicalSpeciality = medicalSpeciality;
    this.yearsOfExp = yearsOfExp;
  }
  public void updateMedicalSpeciality(String speciality){
    medicalSpeciality = speciality;
  }
  public void updateYearsOfExp(int exp){
    yearsOfExp = exp;
  }
  public String getMedicalSpeciality(){
    return medicalSpeciality;
  }
  public int getYearsOfExp(){
    return yearsOfExp;
  }
}
