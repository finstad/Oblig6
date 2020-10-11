package no.hiof.andrefi.controller;

import io.javalin.http.Context;
import no.hiof.andrefi.model.Observations;
import no.hiof.andrefi.repository.IMapOfLifeRepository;


import java.util.ArrayList;

public class ObservationsController {
    private IMapOfLifeRepository mapOfLifeRepository;

    public ObservationsController(IMapOfLifeRepository mapOfLifeRepository) {
        this.mapOfLifeRepository = mapOfLifeRepository;
    }

public void getAllObservations(Context context){
    ArrayList<Observations> allObservations = mapOfLifeRepository.getAllObservations();

    context.json(allObservations);
}

public void getObservation(Context context){
        String observationName = context.pathParam(":observations-name");

        System.out.println(observationName);

        Observations observations = mapOfLifeRepository.getObservation(observationName);

        System.out.println(observations);

        context.json(observations);
}

}
