package com.engeto.ja;

import java.time.LocalDate;

public class PlantException extends Exception{
    public void setFrequencyOfWatering (int frequencyOfWatering){
       if (frequencyOfWatering<=0){
           throw new IllegalArgumentException("Frequency of watering must be greater than zero.Given frequency: "+frequencyOfWatering);
       }
    }
    public class WateringException extends Exception{
        public void setWatering   (LocalDate planted, LocalDate watering){
        if (watering.isBefore(planted)){
            throw new IllegalArgumentException("Watering must be after planting. Given watering: "+watering+" Given planting: "+planted);
        }}
    }


}
