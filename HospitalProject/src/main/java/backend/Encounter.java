/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author nbabu
 */
public class Encounter {
    private String encounterDate;
    private String encounterTime;
    private VitalSigns vitalSigns;
    Encounter(String encounterDate, String encounterTime, float temperature, int pulseRatePerMinute, int systolicBloodPressure, int diastolicBloodPressure){
      this.encounterDate = encounterDate;
      this.encounterTime = encounterTime;
      vitalSigns = new VitalSigns(temperature, pulseRatePerMinute, systolicBloodPressure, diastolicBloodPressure);
    }
}
