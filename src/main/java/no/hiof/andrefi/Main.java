package no.hiof.andrefi;

import io.javalin.Javalin;
import io.javalin.plugin.rendering.vue.VueComponent;
import no.hiof.andrefi.controller.ObservationsController;
import no.hiof.andrefi.model.*;
import no.hiof.andrefi.repository.MapOfLifeRepository;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main (String[] args){




        //Animals
        Invertebrate crab = new Invertebrate("Invertebrate","crab", "crabusmaxus", 10, false, "https://cdnph.upi.com/svc/sv/i/79191335220833/2012/1/13352187807432/Colorful-crab-species-found-on-island.jpg");
        Amphibian spisssnuteFrosk = new Amphibian("Amphibian","Spissnutefrosk", "Rana arvalis", 64, true, "https://storage.googleapis.com/snl-no-media/media/125301/standard_spissnutefrosk_43151.jpg");
        Bird eagle = new Bird("Bird","Hvithode havørn", "Haliaweetus leucocephalus", 4, true, "https://upload.wikimedia.org/wikipedia/commons/1/1e/Bald_Eagle_Portrait.jpg");
        Bird kakadue = new Bird("Bird","Kakadue", "Cacatuidae", 24, true, "https://dyrebar.no/media/encyclopedia/2017/11/01/48e7bd927ec44a12b7dff33b7b183224.jpg.1110x625_q85.jpg");
        Invertebrate oyenstikker = new Invertebrate("Invertebrate","Øyenstikker", "Odonata", 100, false, "https://upload.wikimedia.org/wikipedia/commons/thumb/3/33/Orthetrum_cancellatum.jpg/250px-Orthetrum_cancellatum.jpg");

        //biomes
        ArrayList<Biome> biome1 = new ArrayList<>();
        ArrayList<Biome> biome2 = new ArrayList<>();
        ArrayList<Biome> biome3 = new ArrayList<>();
        ArrayList<Biome> biome4 = new ArrayList<>();
        Biome jungle = new Biome("Jungle", "forest", 30);
        Biome sea = new Biome("Ocean", "water", 12);
        Biome desert = new Biome("Desert", "Sand", 35);
        Biome mountain = new Biome("Mountain", "rock", 2);
        Biome swamp = new Biome("Swamp", "Wet ground", 17);
        biome1.add(jungle);
        biome1.add(sea);
        biome2.add(mountain);
        biome3.add(swamp);
        biome4.add(desert);



        //locations
        Location asia = new Location("Earth", biome1, 23, 21);
        Location himalaya = new Location("Earth", biome2, 87, 28);
        Location swamp1 = new Location("Earth", biome3, 12, 34);
        Location desert1 = new Location("Mars", biome4, 26, 12);
        Location australia = new Location("Earth", biome1, 83, 78);

        //observations
        Observations observations1 = new Observations(crab, asia, "sadnasdad");
        Observations observations2 = new Observations(spisssnuteFrosk, himalaya, "Lots of mountains");
        Observations observations3 = new Observations(eagle, himalaya, "Flies well");
        Observations observations4 = new Observations(kakadue, australia, "weird feathers");
        Observations observations5 = new Observations(oyenstikker, swamp1,"lots of colors");

        /*System.out.println(observation1);
        System.out.println(observation2);
        System.out.println(observation3);
        System.out.println(observation4);
        System.out.println(observation5);

        System.out.println(observation1.getAnimal());*/


        HashMap<String, Observations> hashMapTest = new HashMap<String, Observations>();

        hashMapTest.put(observations1.getInvertebrate().getName(), observations1);
        hashMapTest.put(observations2.getAmphibian().getName(), observations2);
        hashMapTest.put(observations3.getBird().getName(), observations3);
        hashMapTest.put(observations4.getBird().getName(), observations4);
        hashMapTest.put(observations5.getInvertebrate().getName(), observations5);




        Javalin app = Javalin.create().start(8080);

        app.config.enableWebjars();

        MapOfLifeRepository mapOfLifeRepository = new MapOfLifeRepository("observations.csv", hashMapTest);
        ObservationsController observationsController = new ObservationsController(mapOfLifeRepository);


        app.get("/observations", new VueComponent("observations-overview"));

        app.get("/observations/:observations-name", new VueComponent("observations-detail"));

        app.get("/api/observations/", observationsController::getAllObservations);

        app.get("/api/observations/:observations-name", observationsController::getObservation);

    }
}
