package hw;

public class ActionPart2 {
    public static void main(String[] args) {
        //4 variable and ireate through each to print out the i
        String[] region = new String[] {"LA","Miami","Syracuse","Las Vegas"};
        int[] AreaCode= new int[] {213,786,315, 702};
        int i = 0;
        while (i < AreaCode.length){
            System.out.println("My region is " + region[i] + " and my area code is " + AreaCode[i]);

            // incramenting
            i= i +1;
        }

    }// end of main
}// end of class
