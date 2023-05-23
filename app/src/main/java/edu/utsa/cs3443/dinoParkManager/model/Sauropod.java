package edu.utsa.cs3443.dinoParkManager.model;

/**
 * Abstract class for Sauropod dinos
 * @author Andres Tostado
 */
public abstract class Sauropod implements Dinosaur {
    String name;	//dino name
    boolean isVegetarian;	//if dinosaur is vegetarian or not

    /**
     * Constructor for a Sauropod (Super class)
     * @param name (String)
     * @param isVegetarian (boolean)
     */
    public Sauropod (String name, boolean isVegetarian) {
        this.name = name;
        this.isVegetarian = isVegetarian;
    }

    /**
     * Returns representation of dinosaur as a string
     * @return String of dinosaur (String)
     */
    public String toString() {
        String carnivore;	//String that states if dinosaur is carnivore or not
        if(isVegetarian() == true) {	//If loop that will assign string carnivore with the correct string
            carnivore = "not carnivore";
        }
        else {
            carnivore = "carnivore";
        }
        return "* Sauropod: " + getType() + " named " + getName() + " (" + carnivore + ")";
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
