import com.engeto.ja.ListOfPlants;
import com.engeto.ja.Plant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.time.LocalDate.*;

public class Main {
    public static void main(String[] args) {

        ListOfPlants listOfPlants = new ListOfPlants();



        String fileName="resources/kvetiny (3).txt";
        listOfPlants.loadContentFromFile(fileName);



        listOfPlants.addPlant(new Plant("Fialka fialová","málo se zalévá",LocalDate.of(2022,1,2),LocalDate.of(2024,2,15),7));
        listOfPlants.addPlant(new Plant("Kapradina","hodně se zalévá",LocalDate.of(2022,1,2),LocalDate.of(2024,2,15),1));

        listOfPlants.removePlant(1);

        String fileName1 = "resources/kvetiny1.txt";
       listOfPlants.saveContentToFile(fileName1);


        System.out.println("Načtený seznam s přidanými a odebranými květinami:");
        List<Plant> plantList = listOfPlants.getOtherPlant();
        for(Plant plant :plantList) { System.out.println(plant.getName() +" " +plant.getWatering());}

        System.out.println("\n");
        System.out.println("Seznam setříděný podle jména:");
        Collections.sort(plantList,Comparator.comparing(Plant::getName));
        System.out.println(plantList);

        System.out.println("Seznam setříděný podle poslední zálivky:");
        Collections.sort(plantList,Comparator.comparing(Plant::getWatering));

        System.out.println(plantList);


    }


    }
