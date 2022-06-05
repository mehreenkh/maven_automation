package hw;

import java.util.ArrayList;

public class part2 {
    // using array loop conditions with cities

    public static void main(String[] args) {
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Staten Isand");
        cities.add("Manhattan");
        cities.add("Queens");
        cities.add("Brooklyn");

        for (int i=0; i < cities.size(); i++){
            //with if conditions

            if (cities.get(i) == "Brooklyn"){
                System.out.println(" My city is " + cities.get(i));
            } else if (cities.get(i) == "Manhattan") {
                System.out.println( " My city is " + cities.get(i));
            }
        } // end of loop

    }



}// end of main

