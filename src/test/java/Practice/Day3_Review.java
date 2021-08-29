package Practice;

public class Day3_Review {
    public static void main(String[] args) {

        String [] cities = new String[4];
        cities[0] = "Brooklyn";
        cities[1] = "Manhattan";
        cities[2] = "Queens";
        cities[3] = "Staten Island";

        for (int i =0; i< cities.length; i ++){
            switch (cities[i]){
                case "Queens":
                case "Brooklyn":
                case "Manhattan":
                    System.out.println("My city is " + cities[i]);
                    break;
            }// end of switch
        }//end of for loop




    }//end of main method
}//end of java class
