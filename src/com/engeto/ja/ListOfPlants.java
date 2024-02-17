package com.engeto.ja;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOfPlants {
    private List<Plant> plantList = new ArrayList<>();

    public void addPlant(Plant plant) {
        plantList.add(plant);
    }
    public Plant plant(int index) {
        return plantList.get(index);
    }
    public void removePlant(int index) {
        plantList.remove(index);
    }

    public List<Plant> getOtherPlant() {
        return new ArrayList<>(plantList);
    }

    public void setOtherPlant(List<Plant> otherPlant) {
        this.plantList = plantList;
    }

    private List<Plant> plants = new ArrayList<>();
    public void loadContentFromFile(String fileName) throws RuntimeException {
        fileName="ressources/kvetiny.txt";
        int lineCounter = 0;
        plants.clear();
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)))) {
            while (scanner.hasNextLine()) {
                lineCounter++;
                String line = scanner.nextLine();
                String[] parts = line.split("\t");
                if (parts.length != 5) throw new RuntimeException(
                        "Nesprávný počet položek na řádku číslo: "+lineCounter+": "+line+"!");
                String name = parts[0];
                String description = parts[1];
                LocalDate planted = LocalDate.parse(parts[2]);
                LocalDate watering = LocalDate.parse(parts[3]);
                int frequencyOfWatering = Integer.parseInt(parts[4]);
                plants.add(plant);
                            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Soubor "+fileName+" nebyl nalezen!\n"+ e.getLocalizedMessage());
        } catch (NumberFormatException e) {
            throw new RuntimeException("Chyba při čtení číselné hodnoty na řádku číslo: "+lineCounter+":\n"
                    + e.getLocalizedMessage());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Chyba při čtení kategorie na řádku číslo: "+lineCounter+":\n"
                    + e.getLocalizedMessage());
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Chyba při čtení data na řádku číslo: "+lineCounter+":\n"
                    + e.getLocalizedMessage());
        }
    }





}
