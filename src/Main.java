import com.engeto.ja.ListOfPlants;
import com.engeto.ja.Plant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDate.*;

public class Main {
    public static void main(String[] args) {

        ListOfPlants listOfPlants = new ListOfPlants();
        listOfPlants.addPlant(new Plant("Fialka","málo se zalévá",LocalDate.of(2022,2,3),LocalDate.of(2024,1,2),7));


        getWateringInfo(listOfPlants);
    }

    private static void getWateringInfo(ListOfPlants listOfPlants) {
        System.out.println(listOfPlants.getOtherPlant());
    }
}