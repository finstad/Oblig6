package no.hiof.andrefi.model;

public class Bird extends Animal{

    private boolean canFly;

    public Bird (String animalType,String name, String scientificName, int population, boolean canFly, String pictureURL){
        super(animalType, name, scientificName, population, pictureURL);
        this.canFly = canFly;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "\nScientific name: " + getScientificName() + "\nPopulation: " + getPopulation() + "\ncan fly: " + isCanFly();
    }
}
