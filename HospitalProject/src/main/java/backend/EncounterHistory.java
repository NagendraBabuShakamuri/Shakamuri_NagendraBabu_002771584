/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author nbabu
 */
import java.util.ArrayList;
public class EncounterHistory {
    private static ArrayList<Encounter> encounterList = new ArrayList<>();
    public static void addEncounter(Encounter e)
    {
      encounterList.add(e);
    }
    public static void setEncounterList(ArrayList<Encounter> newEncounterList)
    {
      encounterList = newEncounterList;
    }
    public static ArrayList<Encounter> getEncounterList(){
      return encounterList;
    }
}
