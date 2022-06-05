package day2_042422;

public class whileloop {
    public static void main(String[] args) {
      // iterate through zipcode and its streetNumber using linear array and while loop
      String[] zipCodes= new String[] {"11215" , "11223" , "11204" , "11213"};

        int[] houseNumber = new int[] {111,222,333,444};

      //initlaize starting point before calling while loop
        int i = 0;
        //define the end point in while loop
        while (i < houseNumber.length){
            System.out.println("My zip code is " + zipCodes[i] + "house number" + houseNumber[i]);

            //increamenting
            i =i+1;

        }
    }// end of main


}// end of java class
