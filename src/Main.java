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
        listOfPlants.addPlant(new Plant("Fialka fialová","málo se zalévá",LocalDate.of(2022,1,2),LocalDate.of(2024,2,15),7));

        getWateringInfo(listOfPlants);

        String fileName="resources/kvetiny.txt";
        listOfPlants.loadContentFromFile(fileName);


        String fileName1 = "resources/kvetiny1.txt";
       listOfPlants.saveContentToFile(fileName1);


        List<Plant> plantList = listOfPlants.getOtherPlant();
        for(Plant plant :plantList) { System.out.println("Načtený seznam květin:"+plant.getName() + plant.getWatering());}


        Collections.sort(plantList,Comparator.comparing(Plant::getName));
        System.out.println(plantList);

        Collections.sort(plantList,Comparator.comparing(Plant::getWatering));

        System.out.println(plantList);


    }

    private static void getWateringInfo(ListOfPlants listOfPlants) {
        System.out.println(listOfPlants.getOtherPlant());
    }
}