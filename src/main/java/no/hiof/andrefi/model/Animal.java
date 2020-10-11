package no.hiof.andrefi.model;

import java.time.LocalDate;
import java.util.Comparator;

public class Animal implements Comparator<Animal> {
    private int population;
    private String name, scientificName, pictureURL, animalType;

    public Animal (String animalType, String name, String scientificName, int population, String pictureURL){
        this.name = name;
        this.scientificName = scientificName;
        this.population = population;
        this.pictureURL = pictureURL;
        this.animalType = animalType;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }




    @Override
    public String toString() {
        return "Name: " + getName() + "\nScientific name: " + getScientificName() + "\nPopulation: " + getPopulation();
    }


    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.getPopulation() - o2.getPopulation();
    }
}
