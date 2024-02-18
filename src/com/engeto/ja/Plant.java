package com.engeto.ja;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collections;

public class Plant {
    private String name;
    private String notes;
    private LocalDate planted;
    private LocalDate watering;
    private int frequencyOfWatering;

    public Plant(String name, String notes, LocalDate planted, LocalDate watering, int frequencyOfWatering) {
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        this.watering = watering;
        this.frequencyOfWatering = frequencyOfWatering;
    }

        public Plant(String name, String notes, LocalDate watering) {
        this.name = name;
        this.notes = "   ";
        this.watering = LocalDate.now();
    }
    public Plant(String name,LocalDate planted, LocalDate watering, int frequencyOfWatering) {
        this.name = name;
        this.planted = LocalDate.now();
        this.watering = LocalDate.now();
        this.frequencyOfWatering = 7;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    public LocalDate getWatering() {
        return watering;
    }

    public void setWatering(LocalDate watering) {
        this.watering = watering;
    }

    public int getFrequencyOfWatering() {
        return frequencyOfWatering;
    }

    public void setFrequencyOfWatering(int frequencyOfWatering) {
        this.frequencyOfWatering = frequencyOfWatering;
    }

    public LocalDate getWatering(LocalDate watering,int frequencyOfWatering){
        LocalDate wateringDate = ChronoUnit.DAYS.addTo(watering,frequencyOfWatering);
        return wateringDate;



    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                               ", watering=" + watering +", other watering="+getWatering()                ;
    }
}
