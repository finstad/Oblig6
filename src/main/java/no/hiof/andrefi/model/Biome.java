package no.hiof.andrefi.model;

import java.util.ArrayList;

public class Biome {
    private String name, mainElement;
    private int temperature;

    public Biome (String name, String mainElement, int temperature){
        this.name = name;
        this.mainElement = mainElement;
        this.temperature = temperature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMainElement() {
        return mainElement;
    }

    public void setMainElement(String mainElement) {
        this.mainElement = mainElement;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "\nMain element: " + getMainElement() + "\nTemperature" + getTemperature();
    }
}
