package edu.utsa.cs3443.dinoParkManager.model;

import android.app.Activity;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Park class holds all data inside a park (zones and dinos)
 * @author Andres Tostado
 */
public class Park {

    ArrayList<Zone> zones;

    /**
     * constructor for Park class (nothing needed)
     */
    public Park () {
    }

    /**
     * Loads zone info from csv files, creates zone and dinosaur objects ands sorts them
     * @param manager manages asset folder (AssetManager)
     * @param activity activity happening in app (Activity)
     */
    public void loadZones(AssetManager manager, Activity activity) {

        Scanner scan;
        boolean chasmosaurine = false;
        boolean sauropod = false;
        boolean stegosaur = false;
        boolean theropod = false;
        if (zones == null) {
            zones = new ArrayList<Zone>();
        }
            try {
                InputStream file1 = manager.open("zones.csv");
                scan = new Scanner(file1);
                String zone = "";
                String[] tokens1;

                while (scan.hasNextLine()) {
                    zone = scan.nextLine();
                    tokens1 = zone.split(",");

                    String DinoType = tokens1[0];
                    String risk = tokens1[1];
                    String ZoneName = tokens1[2];
                    String guests = tokens1[3];
                    int guestNum = Integer.parseInt(guests);

                    zones.add(new Zone(ZoneName, guestNum));
                }
                InputStream file3 = manager.open("types.csv");
                scan = new Scanner(file3);
                String types = "";
                String[] tokens3;

                while (scan.hasNextLine()) {
                    types = scan.nextLine();
                    tokens3 = types.split(",");
                    String DinoType = tokens3[0];
                    String vegetarian = tokens3[1];
                    boolean vege;
                    if (vegetarian.equals("TRUE")) {
                        vege = true;
                    } else {
                        vege = false;
                    }
                    switch (DinoType) {
                        case "Chasmosaurine":
                            chasmosaurine = vege;
                            break;
                        case "Sauropod":
                            sauropod = vege;
                            break;
                        case "Stegosaur":
                            stegosaur = vege;
                            break;
                        case "Theropod":
                            theropod = vege;
                            break;
                    }
                }

                InputStream file2 = activity.openFileInput("dinos.csv");
                scan = new Scanner(file2);
                String dino = "";
                String[] tokens2;

                while (scan.hasNextLine()) {
                    dino = scan.nextLine();
                    tokens2 = dino.split(",");

                    String dinoName = tokens2[0];
                    String dinoSubType = tokens2[1];
                    String zoneDino = tokens2[2];
                    Dinosaur dinosaur = null;
                    switch (dinoSubType) {
                        case "Apatosaurus":
                            dinosaur = new Apatosaurus(dinoName, sauropod);
                            break;
                        case "Brachiosaurus":
                            dinosaur = new Brachiosaurus(dinoName, sauropod);
                            break;
                        case "Dilophosaurus":
                            dinosaur = new Dilophosaurus(dinoName, theropod);
                            break;
                        case "Gallimimus":
                            dinosaur = new Gallimimus(dinoName, theropod);
                            break;
                        case "Indominous Rex":
                            dinosaur = new Indominous(dinoName, theropod);
                            break;
                        case "Stegosaurus":
                            dinosaur = new Stegosaurus(dinoName, stegosaur);
                            break;
                        case "Triceratops":
                            dinosaur = new Triceratops(dinoName, chasmosaurine);
                            break;
                        case "Tyrannosaurus":
                            dinosaur = new Tyrannosaurus(dinoName, theropod);
                            break;
                        case "Velociraptor":
                            dinosaur = new Velociraptor(dinoName, theropod);
                            break;
                    }
                    for (Zone zones : zones) {
                        if (zones.getZoneName().equals(zoneDino)) {
                            zones.addDinosaur(dinosaur);
                        }
                    }
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

    /**
     * Gets the needed zone from name parameter
     * @param zone zone name (String)
     * @return correct zone object (Zone)
     */
    public Zone getZoneFromName(String zone){
        for (Zone zones : zones) {
            if (zones.getZoneName().equals(zone)) {
                return zones;
            }
        }
        return null;
    }
}
