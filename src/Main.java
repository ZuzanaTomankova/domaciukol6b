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

        getWateringInfo(listOfPlants);

        String fileName="resources/kvetiny.txt";
        listOfPlants.loadContentFromFile(fileName);


        String fileName1 = "resources/kvetiny1.txt";
        listOfPlants.saveContentToFile(fileName1);



    }

    private static void getWateringInfo(ListOfPlants listOfPlants) {
        System.out.println(listOfPlants.getOtherPlant());
    }
}