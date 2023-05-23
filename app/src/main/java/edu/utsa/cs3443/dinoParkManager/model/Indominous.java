package edu.utsa.cs3443.dinoParkManager.model;

/**
 * Indominous class represents a Indominous object
 * @author Andres Tostado
 */
public class Indominous extends Theropod {
    /**
     * Constructor for Indominous class
     * @param name name of dino (String)
     * @param isVegetarian if vegetarian (boolean)
     */
    public Indominous (String name, boolean isVegetarian) {	//Constructor
        super(name, isVegetarian);	//References superclass (Theropod)
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
     * gets if dino is vegetarian
     * @return isVegetarian (boolean)
     */
    public boolean getVegetarian() {
        return isVegetarian;
    }

    //Setters

    /**
     * Sets name of dino
     * @param name (String)
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets whether or not dino is vegetarian or not
     * @param isVegetarian (boolean)
     */
    public void setVegetarian(boolean isVegetarian) {
        this.isVegetarian = isVegetarian;
    }

    /**
     * Returns getSubType for superclass
     * @return getSubType (String)
     */
    public String getType() {
        return getSubType();
    }

    /**
     * Returns subType as a string
     * @return "Indominous Rex" (String)
     */
    public String getSubType() {
        return "Indominous Rex";
    }
}
