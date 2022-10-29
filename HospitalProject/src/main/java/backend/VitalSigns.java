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
    double temperature;
    int pulseRatePerMinute;
    int respirationRate;
    int systolicBloodPressure;
    int diastolicBloodPressure;
    public VitalSigns(double temperature, int pulseRatePerMinute, int respirationRate, int systolicBloodPressure, int diastolicBloodPressure){
      this.temperature = temperature;
      this.pulseRatePerMinute = pulseRatePerMinute;
      this.respirationRate = respirationRate;
      this.systolicBloodPressure = systolicBloodPressure;
      this.diastolicBloodPressure = diastolicBloodPressure;
    }
    public double getTemperature()
    {
      return temperature;
    }
    public int getPulseRatePerMinute()
    {
      return pulseRatePerMinute;
    }
    public int getRespirationRate()
    {
      return respirationRate;
    }
    public int getSystolicBloodPressure()
    {
      return systolicBloodPressure;
    }
    public int getDiastolicBloodPressure()
    {
      return diastolicBloodPressure;
    }
}
