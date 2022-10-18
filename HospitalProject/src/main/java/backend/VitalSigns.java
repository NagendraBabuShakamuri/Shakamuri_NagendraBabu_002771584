/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author nbabu
 */
public class VitalSigns {
    float temperature;
    int pulaseRatePerMinute;
    int systolicBloodPressure;
    int diastolicBloodPressure;
    VitalSigns(float temperature, int pulaseRatePerMinute, int systolicBloodPressure, int diastolicBloodPressure){
      this.temperature = temperature;
      this.pulaseRatePerMinute = pulaseRatePerMinute;
      this.systolicBloodPressure = systolicBloodPressure;
      this.diastolicBloodPressure = diastolicBloodPressure;
    }
}
