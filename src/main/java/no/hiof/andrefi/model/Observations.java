package no.hiof.andrefi.model;

import java.time.LocalDate;
import java.util.Comparator;

public class Observations implements Comparator<Observations> {
    private Invertebrate invertebrate;
    private Amphibian amphibian;
    private Bird bird;
    private String comment;
    private LocalDate observationDate;
    private Location location;
    private long id;


    public Observations(Invertebrate invertebrate, Location location, String comment){
        this.id = System.nanoTime();
        this.invertebrate = invertebrate;
        this.location = location;
        this.comment = comment;
        this.observationDate = LocalDate.now();
    }

    public Observations(Amphibian amphibian, Location location, String comment){
        this.id = System.nanoTime();
        this.amphibian = amphibian;
        this.location = location;
        this.comment = comment;
        this.observationDate = LocalDate.now();
    }

    public Observations(Bird bird, Location location, String comment){
        this.id = System.nanoTime();
        this.bird = bird;
        this.location = location;
        this.comment = comment;
        this.observationDate = LocalDate.now();
    }

    public Invertebrate getInvertebrate() {
        return invertebrate;
    }

    public void setInvertebrate(Invertebrate invertebrate) {
        this.invertebrate = invertebrate;
    }

    public Amphibian getAmphibian() {
        return amphibian;
    }

    public void setAmphibian(Amphibian amphibian) {
        this.amphibian = amphibian;
    }

    public Bird getBird() {
        return bird;
    }

    public void setBird(Bird bird) {
        this.bird = bird;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getObservationDate() {
        return observationDate;
    }

    /*public void setObservationDate(String observationDate) {
        this.observationDate = observationDate;
    }*/

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        if (this.bird instanceof Bird) {
            return bird.toString() + "\n" + location.toString() + "\nDate: " + getObservationDate() + "\nComment: " + getComment() + "\n";
        } else if (this.invertebrate instanceof Invertebrate) {
            return invertebrate.toString() + "\n" + location.toString() + "\nDate: " + getObservationDate() + "\nComment: " + getComment() + "\n";
        } else {
            return amphibian.toString() + "\n" + location.toString() + "\nDate: " + getObservationDate() + "\nComment: " + getComment() + "\n";
        }

        //return animal.toString() + "\n" + location.toString() + "\nDate: " + getObservationDate() + "\nComment: " + getComment() + "\n";
    }



    @Override
    public int compare(Observations o1, Observations o2) {
        return (int) (o1.getId() - o2.getId());
    }
}
