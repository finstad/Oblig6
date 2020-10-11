package no.hiof.andrefi.model;

public class Amphibian extends Animal{
    private boolean hibernating;

    public Amphibian (String animalType, String name, String scientificName, int population, boolean hibernating, String pictureURL){
        super(animalType, name, scientificName, population, pictureURL);
        this.hibernating = hibernating;
    }

    public boolean isHibernating() {
        return hibernating;
    }

    public void setHibernating(boolean hibernating) {
        this.hibernating = hibernating;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "\nScientific name: " + getScientificName() + "\nPopulation: " + getPopulation() + "\nHibernating: " + isHibernating();
    }
}
