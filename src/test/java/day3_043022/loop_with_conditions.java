package day3_043022;

import java.util.ArrayList;

public class loop_with_conditions {
    public static void main(String[] args) {
        // create an array with fruits and print only when fruit is apple or orange
        ArrayList<String>fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Grape");
        fruits.add("Strawberry");

        for(int i=0; i<fruits.size(); i++){
            //with if conditions

            if(fruits.get(i)== "Apple"){
                System.out.println("My fruit is " + fruits.get(i));
            } else if (fruits.get(i)== "Grape"){
                System.out.println("My fruit is " + fruits.get(i));
            }
        }
    }// end of main




}// end of java class
