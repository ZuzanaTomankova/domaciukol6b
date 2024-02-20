package com.engeto.ja;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

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



    public void loadContentFromFile(String fileName) throws RuntimeException {
        int lineCounter = 0;
        plantList.clear();
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)))) {
            while (scanner.hasNextLine()) {
                lineCounter++;
                String line = scanner.nextLine();
                String[] parts = line.split("\t");
                if (parts.length != 5) throw new RuntimeException(
                        "Nesprávný počet položek na řádku číslo: " + lineCounter + ": " + line + "!");
                String name = parts[0];
                String description = parts[1];
                int frequencyOfWatering = Integer.parseInt(parts[2]);
                LocalDate watering = LocalDate.parse(parts[4]);
                LocalDate planted = LocalDate.parse(parts[3]);


                Plant plant = new Plant(name, description, planted, watering, frequencyOfWatering);
                plantList.add(plant);



            }


    } catch(
    FileNotFoundException e)

    {
        throw new RuntimeException("Soubor " + fileName + " nebyl nalezen!\n" + e.getLocalizedMessage());
    } catch(
    NumberFormatException e)

    {
        throw new RuntimeException("Chyba při čtení číselné hodnoty na řádku číslo: " + lineCounter + ":\n"
                + e.getLocalizedMessage());
    } catch(
    IllegalArgumentException e)

    {
        throw new RuntimeException("Chyba při čtení kategorie na řádku číslo: " + lineCounter + ":\n"
                + e.getLocalizedMessage());
    } catch(
    DateTimeParseException e)

    {
        throw new RuntimeException("Chyba při čtení data na řádku číslo: " + lineCounter + ":\n"
                + e.getLocalizedMessage());
    }

    }



    public void saveContentToFile(String fileName1) throws RuntimeException {
        String delimiter = "\t";
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName1)))) {
            for (Plant plant : plantList) {
                writer.println(plant.getName() + "\t"
                        + plant.getNotes() + "\t"
                        + plant.getPlanted() + "\t"
                        + plant.getWatering() + "\t"
                        + (plant.getFrequencyOfWatering() + "\t"));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Soubor "+fileName1+" nebyl nalezen!\n"
                    + e.getLocalizedMessage());
        } catch (IOException e) {
            throw new RuntimeException("Chyba výstupu při zápisu do souboru: "+fileName1
                    +":\n"+ e.getLocalizedMessage());
        }



    }




}
