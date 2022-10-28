/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author nbabu
 */
import java.time.LocalDateTime;
public class Encounter {
    private int id;
    private String type;
    private Patient patient;
    private Doctor doctor;
    private LocalDateTime dateTime;
    private VitalSigns vitalSigns;
    public Encounter(int id, String type, Patient patient, Doctor doctor, LocalDateTime dateTime, VitalSigns vitalSigns){
      this.id = id;
      this.type = type;
      this.patient = patient;
      this.doctor = doctor;
      this.dateTime = dateTime;
      this.vitalSigns = vitalSigns;
    }
    public int getId()
    {
      return id;
    }
    public String getType()
    {
      return type;
    }
    public void setPatient(Patient patient)
    {
      this.patient = patient;
    }
    public Patient getPatient()
    {
      return patient;
    }
    public void setDoctor(Doctor doctor)
    {
      this.doctor = doctor;
    }
    public Doctor getDoctor()
    {
      return doctor;
    }
    public LocalDateTime getDateTime()
    {
      return dateTime;
    }
    public VitalSigns getVitalSigns()
    {
      return vitalSigns;
    }
}
