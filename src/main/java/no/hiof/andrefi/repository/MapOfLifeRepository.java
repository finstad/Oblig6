package no.hiof.andrefi.repository;

import no.hiof.andrefi.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class MapOfLifeRepository implements IMapOfLifeRepository {
    private ArrayList<Observations> allObservations = new ArrayList<>();
    private ArrayList<Biome> biomesList = new ArrayList<>();
    private HashMap<String, Observations> observationsHashMap;


    public MapOfLifeRepository(String fileName, HashMap<String, Observations> observationHashMap) {
        writeToCsv(fileName, observationHashMap);

        observationsHashMap = readFromCSV("observations.csv");

        allObservations.addAll(observationHashMap.values());

    }

    public static HashMap<String, Observations> readFromCSV(String fileName) {
        HashMap<String, Observations> observationHashMap = new HashMap<>();

        Invertebrate invertebrate = null;
        Amphibian amphibian = null;
        Animal animal = null;
        Bird bird = null;
        Location location = null;
        Biome biome1 = null;
        ArrayList<Biome> biomeArrayList = new ArrayList<>();
        Observations observations = null;

        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            while ((line = br.readLine()) != null) {

                String[] splitter = line.split(",");


                if (splitter[1].equals("Invertebrate")) {

                    invertebrate = new Invertebrate(splitter[1], splitter[2], splitter[3], Integer.parseInt(splitter[4]), Boolean.parseBoolean(splitter[5]), splitter[6]);

                    if (splitter.length > 16) {
                        for (int i = 0; i < 4; i = i + 3) {
                            biome1 = new Biome(splitter[9 + i], splitter[10 + i], Integer.parseInt(splitter[11 + i]));
                            biomeArrayList.add(biome1);
                        }
                    } else {
                        biome1 = new Biome(splitter[9], splitter[10], Integer.parseInt(splitter[11]));
                        biomeArrayList.add(biome1);
                    }

                    location = new Location(splitter[8], biomeArrayList, Double.parseDouble(splitter[splitter.length - 3]), Double.parseDouble(splitter[splitter.length - 2]));

                    observations = new Observations(invertebrate, location, splitter[splitter.length - 1]);

                    observationHashMap.put(splitter[2], observations);

                    biomeArrayList.clear();
                } else if (splitter[1].equals("Amphibian")) {

                    amphibian = new Amphibian(splitter[1], splitter[2], splitter[3], Integer.parseInt(splitter[4]), Boolean.parseBoolean(splitter[5]), splitter[6]);

                    if (splitter.length > 16) {
                        for (int i = 0; i < 4; i = i + 3) {
                            biome1 = new Biome(splitter[9 + i], splitter[10 + i], Integer.parseInt(splitter[11 + i]));
                            biomeArrayList.add(biome1);
                        }
                    } else {
                        biome1 = new Biome(splitter[9], splitter[10], Integer.parseInt(splitter[11]));
                        biomeArrayList.add(biome1);
                    }

                    location = new Location(splitter[8], biomeArrayList, Double.parseDouble(splitter[splitter.length - 3]), Double.parseDouble(splitter[splitter.length - 2]));

                    observations = new Observations(amphibian, location, splitter[splitter.length - 1]);

                    observationHashMap.put(splitter[2], observations);

                    biomeArrayList.clear();
                } else if (splitter[1].equals("Bird")) {

                    bird = new Bird(splitter[1], splitter[2], splitter[3], Integer.parseInt(splitter[4]), Boolean.parseBoolean(splitter[5]), splitter[6]);

                    if (splitter.length > 16) {
                        for (int i = 0; i < 4; i = i + 3) {
                            biome1 = new Biome(splitter[9 + i], splitter[10 + i], Integer.parseInt(splitter[11 + i]));
                            biomeArrayList.add(biome1);
                        }
                    } else {
                        biome1 = new Biome(splitter[9], splitter[10], Integer.parseInt(splitter[11]));
                        biomeArrayList.add(biome1);
                    }

                    location = new Location(splitter[8], biomeArrayList, Double.parseDouble(splitter[splitter.length - 3]), Double.parseDouble(splitter[splitter.length - 2]));

                    observations = new Observations(bird, location, splitter[splitter.length - 1]);

                    observationHashMap.put(splitter[2], observations);

                    biomeArrayList.clear();

                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return observationHashMap;
    }

    public static void writeToCsv(String fileName, HashMap<String, Observations> observationHashMap) {

        try (FileWriter fileWriter = new FileWriter(fileName, false)) {
            for (Observations observations : observationHashMap.values()) {
                if (observations.getInvertebrate() instanceof Invertebrate) {
                    fileWriter.write(observations.getId() + "," +
                            observations.getInvertebrate().getAnimalType() + "," +
                            observations.getInvertebrate().getName() + "," +
                            observations.getInvertebrate().getScientificName() + "," +
                            observations.getInvertebrate().getPopulation() + "," +
                            observations.getInvertebrate().isHeardAnimal() + "," +
                            observations.getInvertebrate().getPictureURL() + "," +
                            observations.getObservationDate() + "," +
                            observations.getLocation().getPlanetName() + ",");
                    for (Biome biome : observations.getLocation().getBiomes()) {
                        fileWriter.write(biome.getName() + "," +
                                biome.getMainElement() + "," +
                                biome.getTemperature() + ",");
                    }
                    fileWriter.write(observations.getLocation().getLongitude() + "," +
                            observations.getLocation().getLatitude() + "," +
                            observations.getComment() + "\n");
                } else if (observations.getAmphibian() instanceof Amphibian) {
                    fileWriter.write(observations.getId() + "," +
                            observations.getAmphibian().getAnimalType() + "," +
                            observations.getAmphibian().getName() + "," +
                            observations.getAmphibian().getScientificName() + "," +
                            observations.getAmphibian().getPopulation() + "," +
                            observations.getAmphibian().isHibernating() + "," +
                            observations.getAmphibian().getPictureURL() + "," +
                            observations.getObservationDate() + "," +
                            observations.getLocation().getPlanetName() + ",");
                    for (Biome biome : observations.getLocation().getBiomes()) {
                        fileWriter.write(biome.getName() + "," +
                                biome.getMainElement() + "," +
                                biome.getTemperature() + ",");
                    }
                    fileWriter.write(observations.getLocation().getLongitude() + "," +
                            observations.getLocation().getLatitude() + "," +
                            observations.getComment() + "\n");
                } else if (observations.getBird() instanceof Bird) {
                    fileWriter.write(observations.getId() + "," +
                            observations.getBird().getAnimalType() + "," +
                            observations.getBird().getName() + "," +
                            observations.getBird().getScientificName() + "," +
                            observations.getBird().getPopulation() + "," +
                            observations.getBird().isCanFly() + "," +
                            observations.getBird().getPictureURL() + "," +
                            observations.getObservationDate() + "," +
                            observations.getLocation().getPlanetName() + ",");
                    for (Biome biome : observations.getLocation().getBiomes()) {
                        fileWriter.write(biome.getName() + "," +
                                biome.getMainElement() + "," +
                                biome.getTemperature() + ",");
                    }
                    fileWriter.write(observations.getLocation().getLongitude() + "," +
                            observations.getLocation().getLatitude() + "," +
                            observations.getComment() + "\n");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<Observations> getAllObservations() {
        return allObservations;
    }

    @Override
    public Observations getObservation(String name) {

        for (Observations observations : allObservations) {
            if (observations.getBird() instanceof Bird) {
                if (observations.getBird().getName().equals(name)) {
                    return observations;
                }
            } else if (observations.getInvertebrate() instanceof Invertebrate) {
                if (observations.getInvertebrate().getName().equals(name)) {
                    return observations;
                }
            } else {
                if (observations.getAmphibian().getName().equals(name)) {
                    return observations;
                }
            }
        }
        return null;
    }

    @Override
    public void createObservation(String animalType, String name, String scientificName, int population, boolean variableBoolean, String pictureURL, String comment, String planetName, double longitude, double latitude) {

        Location location = new Location(planetName, biomesList, longitude, latitude);

        if (animalType == "Invertebrate") {
            Invertebrate invertebrate = new Invertebrate(animalType, name, scientificName, population, variableBoolean, pictureURL);
            Observations observation = new Observations(invertebrate, location, comment);

            observationsHashMap.put(invertebrate.getName(), observation);
            writeToCsv("observations.csv", observationsHashMap);

        } else if (animalType == "Amphibian") {
            Amphibian amphibian = new Amphibian(animalType, name, scientificName, population, variableBoolean, pictureURL);
            Observations observation = new Observations(amphibian, location, comment);

            observationsHashMap.put(amphibian.getName(), observation);
            writeToCsv("observations.csv", observationsHashMap);

        } else if (animalType == "Bird") {
            Bird bird = new Bird(animalType, name, scientificName, population, variableBoolean, pictureURL);
            Observations observation = new Observations(bird, location, comment);

            observationsHashMap.put(bird.getName(), observation);
            writeToCsv("observations.csv", observationsHashMap);

        }

    }

    @Override
    public void createBiome(String name, String mainElement, int temperature, boolean addToList) {
        Biome biome = new Biome(name, mainElement, temperature);

        if (addToList == true) {
            biomesList.add(biome);
        } else {
            biomesList.clear();
            biomesList.add(biome);
        }
    }

    @Override
    public void deleteObservation(String fileName, String name) {

        for (Observations observations : observationsHashMap.values()) {
            if ( observations.getAmphibian() instanceof Amphibian && observations.getAmphibian().getName().equals(name)) {
                observationsHashMap.remove(name);
                writeToCsv(fileName, observationsHashMap);
            } else if ( observations.getInvertebrate() instanceof Invertebrate && observations.getInvertebrate().getName().equals(name)) {
                observationsHashMap.remove(name);
                writeToCsv(fileName, observationsHashMap);
            } else if ( observations.getBird() instanceof Bird && observations.getBird().getName().equals(name)) {
                observationsHashMap.remove(name);
                writeToCsv(fileName, observationsHashMap);
            }

        }

    }

    @Override
    public void update(String filename) {
        HashMap<String, Observations> temporaryHashMap = readFromCSV("observations.csv");

        HashMap<String, Observations> emptyHashMap = new HashMap<>();

        writeToCsv("observations.csv", emptyHashMap);

        writeToCsv("observations.csv", temporaryHashMap);

    }
}
