package edu.utsa.cs3443.dinoParkManager.model;

/**
 * Abstract class for Stegosaur dinos
 * @author Andres Tostado
 */
public abstract class Stegosaur implements Dinosaur {
    String name;	//Dino name
    boolean isVegetarian;	//If vegetarian

    /**
     * Constructor for a Stegosaur (Super class)
     * @param name (String)
     * @param isVegetarian (boolean)
     */
    public Stegosaur (String name, boolean isVegetarian) {	//Constructor
        this.name = name;
        this.isVegetarian = isVegetarian;
    }

    /**
     * Returns representation of dinosaur as a string
     * @return String of dinosaur (String)
     */
    public String toString() {
        String carnivore;	//String for if carnivore or not
        if(isVegetarian() == true) {	//Assigns correct string to carnivore
            carnivore = "not carnivore";
        }
        else {
            carnivore = "carnivore";
        }
        return "* Stegosaur: " + getType() + " named " + getName() + " (" + carnivore + ")";
    }

    /**
     * Calls getSubType from subclasses
     * @return getSubType (String)
     */
    public String getType() {
        return getSubType();
    }

    /**
     * Abstract method that is given a return value in subclass
     * @return whatever sub type is from subclass (String)
     */
    public abstract String getSubType();

    //Getters

    /**
     * Gets name of dino
     * @return name (String)
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name of dino
     * @param name (String)
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets if vegetarian
     * @return isVegetarian (boolean)
     */
    public boolean isVegetarian() {
        return isVegetarian;
    }

    /**
     * Sets isVegetarian
     * @param vegetarian (boolean)
     */
    public void setVegetarian(boolean vegetarian) {
        this.isVegetarian = vegetarian;
    }
}
