package no.hiof.andrefi.repository;

import no.hiof.andrefi.model.Biome;
import no.hiof.andrefi.model.Location;
import no.hiof.andrefi.model.Observations;

import java.util.ArrayList;

public interface IMapOfLifeRepository {
    ArrayList<Observations> getAllObservations();
    Observations getObservation(String name);
    void createObservation(String animalType, String name, String scientificName, int population, boolean heardAnimal, String pictureURL, String comment, String planetName, double longitude, double latitude);
    void createBiome(String name, String mainElement, int temperature, boolean addToList);
    void deleteObservation(String fileName, String name);
    void update(String filename);
}
