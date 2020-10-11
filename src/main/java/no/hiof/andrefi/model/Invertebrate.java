package no.hiof.andrefi.model;

import java.time.LocalDate;

public class Invertebrate extends Animal{
    private boolean heardAnimal;

    public Invertebrate(String animalType, String name, String scientificName, int population, boolean heardAnimal, String pictureURL){
        super(animalType, name, scientificName, population, pictureURL);
        this.heardAnimal = heardAnimal;
    }

    public boolean isHeardAnimal() {
        return heardAnimal;
    }

    public void setHeardAnimal(boolean heardAnimal) {
        this.heardAnimal = heardAnimal;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "\nScientific name: " + getScientificName() + "\nPopulation: " + getPopulation() + "\nHeard animal: " + isHeardAnimal();
    }
}
