package edu.utsa.cs3443.dinoParkManager.model;

/**
 * Interface for Dinosaur objects
 * @author Andres Tostado
 */
public interface Dinosaur {
    public String toString();	//method that returns a string representation of dinos
    public boolean isVegetarian();	//method that returns boolean for being vegetarian
    public String getName();	//Gets name of dinosaur
    public String getType();	//Gets type of dinosaur
}
