package hw;

import java.util.ArrayList;

public class ACTIONIPART1 {
    public static void main(String[] args) {
        //Create at least 4 data for each variable and iterate through each
        ArrayList<String> country = new ArrayList<>();
        country.add("Brazil");
        country.add("India");
        country.add("Bangladesh");
        country.add("Greece");

                ArrayList<Integer> countryArea = new ArrayList<>();
        countryArea.add(55);
        countryArea.add(91);
        countryArea.add(88);
        countryArea.add(30);

        for (int i =0; i<country.size(); i++) {
        System.out.println("My country is " + country.get(i) + " and my country area is " + countryArea.get(i));

        }// end of int
    }// end of country
}// end of class
