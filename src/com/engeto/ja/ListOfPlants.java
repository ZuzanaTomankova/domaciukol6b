package com.engeto.ja;

import java.util.List;

public class ListOfPlants {
List<Plant> otherPlant;

    public ListOfPlants(List<Plant> otherPlant) {
        this.otherPlant = otherPlant;
    }

    public List<Plant> getOtherPlant() {
        return otherPlant;
    }

    public void setOtherPlant(List<Plant> otherPlant) {
        this.otherPlant = otherPlant;
    }
}
