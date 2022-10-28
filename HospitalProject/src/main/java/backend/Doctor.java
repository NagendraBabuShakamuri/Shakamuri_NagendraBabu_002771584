/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author nbabu
 */
public class Doctor extends Person{
//  private Person person;
  private Hospital hospital;
  private String medicalSpeciality;
  private String doctorType;
  private int yearsOfExp;
  public Doctor(int id, String name, String gender, long mobileNumber, String email, House house, String role, String password, Hospital hospital, String medicalSpeciality, String doctorType, int yearsOfExp)
  {
    super(id, name, gender, mobileNumber, email, house, role, password);
    this.hospital = hospital;
    this.medicalSpeciality = medicalSpeciality;
    this.doctorType = doctorType;
    this.yearsOfExp = yearsOfExp;
  }
  public void setHospital(Hospital hospital)
  {
    this.hospital = hospital;
  }
  public void setMedicalSpeciality(String speciality){
    medicalSpeciality = speciality;
  }
  public void setYearsOfExp(int exp){
    yearsOfExp = exp;
  }
  public Hospital getHospital()
  {
    return hospital;
  }
  public String getMedicalSpeciality(){
    return medicalSpeciality;
  }
  public String getDoctorType()
  {
    return doctorType;
  }          
  public int getYearsOfExp(){
    return yearsOfExp;
  }
}
