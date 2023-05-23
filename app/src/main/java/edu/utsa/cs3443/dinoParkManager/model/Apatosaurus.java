package edu.utsa.cs3443.dinoParkManager.model;

/**
 * Class represents an Apatosaurus object
 * @author Andres Tostado
 */
public class Apatosaurus extends Sauropod {

    /**
     * Constructor for Apatosaurus class
     * @param name name of dino (String)
     * @param isVegetarian if dino is vegetarian (boolean)
     */
    public Apatosaurus (String name, boolean isVegetarian) { //Constructor
        super(name, isVegetarian); //Reference to superclass (Sauropod)
        this.name = name;
        this.isVegetarian = isVegetarian;
    }

    //Getters

    /**
     * Gets name of dino
     * @return name of dino (String)
     */
    public String getName() {
        return name;
    }

    /**
     * Return true if dino is vegetarian
     * @return true or false for if vegetarian (boolean)
     */
    public boolean getVegetarian() {
        return isVegetarian;
    }

    //Setters

    /**
     * Sets dino name
     * @param name dino name (String)
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * sets if vegetarian
     * @param isVegetarian vegetarian true/false (boolean)
     */
    public void setVegetarian(boolean isVegetarian) {
        this.isVegetarian = isVegetarian;
    }

    /**
     * Calls subType, used for super class
     * @return sub type of dino (String)
     */
    public String getType() {
        return getSubType();
    }

    /**
     * Returns string representation of sub type
     * @return "Apatosaurus" (String)
     */
    public String getSubType() {
        return "Apatosaurus";
    }
}
