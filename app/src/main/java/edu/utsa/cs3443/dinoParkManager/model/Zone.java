package edu.utsa.cs3443.dinoParkManager.model;

import java.util.ArrayList;

/**
 * Zone class holds data for Zone objects
 * @author Andres Tostado
 */
public class Zone {
    String zoneName;
    int numDinosZ;
    int numGuests;
    ArrayList<Dinosaur> dinosaurs;

    /**
     * Constructor for Zone
     * @param zoneName name of zone (String)
     * @param numGuests number of guests (int)
     */
    public Zone(String zoneName, int numGuests){
        this.zoneName = zoneName;
        this.numDinosZ = numDinosZ;
        this.numGuests = numGuests;
        this.dinosaurs = new ArrayList<Dinosaur>();
    }

    /**
     * Adds a dinosaur object to ArrayList
     * @param dinosaur Dinosaur object (Dinosaur)
     */
    public void addDinosaur(Dinosaur dinosaur) {
        dinosaurs.add(dinosaur);
    }

    /**
     * Gets the zone name
     * @return zone name (String)
     */
    public String getZoneName(){
        return zoneName;
    }

    /**
     * Gets the number of guests
     * @return number of guests (int)
     */
    public int getNumGuests(){
        return numGuests;
    }

    /**
     * Gets the number of dinos
     * @return size of dinosaurs ArrayList (int)
     */
    public int getNumDinosZ() {
        return dinosaurs.size();
    }

    /**
     * Gets the array of dinosaurs
     * @return ArrayList of Dinosaur objects (ArrayList(Dinosaur))
     */
    public ArrayList<Dinosaur> getDinoArray() {
        return dinosaurs;
    }


}
