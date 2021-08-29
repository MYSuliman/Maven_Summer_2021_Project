package DAY3_071721;

public class loop_with_Conditional_Statements {
    public static void main(String[] args) {

        String [] cities = new String[4];
        cities[0] = "Brooklyn";
        cities[1] = "Manhattan";
        cities[2] = "Queens";
        cities[3] = "Staten Island";

        for (int i =0; i< cities.length; i ++){
            if (cities[i]=="Brooklyn"){
                 System.out.println("My city is " + cities[i]);
            } else if (cities[i]=="Manhattan") {
                System.out.println("My city is " + cities[i]);
            }//end of conditions
        }//end of for loop
    }//end of main method
}//end of java class
