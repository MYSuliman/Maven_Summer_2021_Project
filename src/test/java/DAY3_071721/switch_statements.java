package DAY3_071721;

public class switch_statements {
    public static void main(String[] args) {

        //define an array list, iterate through each array value but only print when
        //the city is queens or brooklyn

        String[] cities = new String[4];
        cities[0] = "Brooklyn";
        cities[1] = "Manhattan";
        cities[2] = "Queens";
        cities[3] = "Staten island";

        //using for loop to iterate through cities and only print when it's brooklyn or queens
        for (int i = 0; i < cities.length; i++) {
            switch (cities[i]) {
                case "Queens":
                case "Brooklyn":
                case "Manhattan":
                    System.out.println("My city is " + cities[i]);
                    break;
            }//end of switch
        }///end of loop
    }//end of main method
}//end of java class