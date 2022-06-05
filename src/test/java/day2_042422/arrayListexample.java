package day2_042422;

import java.util.ArrayList;

public class arrayListexample {
    public static void main(String[] args) {
        //create an ArrayList for countries
        ArrayList<String> countries = new ArrayList<>();
        countries.add("USA"); //this is index 0
        countries.add ("Bangladesh"); // this is index 1
        countries.add("India");
        countries.add("Canada");
        countries.add("Pakistan");

        //I want to print 4th value from list
        System.out.println("My last country is " + countries.get(3) + " and my third country is " + countries.get(2));
    }





}// end of java class
