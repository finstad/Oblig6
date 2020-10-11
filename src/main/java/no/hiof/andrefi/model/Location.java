package no.hiof.andrefi.model;

import java.util.ArrayList;
import no.hiof.andrefi.model.Biome;

public class Location implements Comparable<Location>{
    private String planetName;
    private double longitude, latitude;
    private ArrayList<Biome> biomes;

    public Location (String planetName, ArrayList<Biome> biomes, double longitude, double latitude){
        this.planetName = planetName;
        this.biomes = biomes;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public ArrayList<Biome> getBiomes() {
        return biomes;
    }

    public void setBiomes(ArrayList<Biome> biomes) {
        this.biomes = biomes;
    }

    @Override
    public String toString() {
        String biomes = "";
        for(Biome biome : getBiomes()){biomes += biome.getName() + " ";}
        return "Planet name: " + getPlanetName() + "\nBiomes: " + biomes + "\nLongitude: " + getLongitude() + "\nLatitude: " + getLatitude();
    }


    @Override
    public int compareTo(Location o) {
        return planetName.compareTo(o.getPlanetName());
    }
}
