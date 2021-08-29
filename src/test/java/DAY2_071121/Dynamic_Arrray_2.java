package DAY2_071121;

public class Dynamic_Arrray_2 {
    public static void main(String[] args) {

        String[] countries = new String[5];
        countries[0] = "USA";
        countries[1] = "Bangladesh";
        countries[2] = "Pakistan";
        countries[3] = "India";
        countries[4] = "Russia";

        String[] placements = new String[5];
        placements[0] = "First";
        placements[1] = "Second";
        placements[2] = "Third";
        placements[3] = "Fourth";
        placements[4] = "Fifth";

        // use for loop to iterate through the values
        for(int i=0; i < countries.length; i++){
            // print the result
            System.out.println("My country is " + countries[i] + " and my placement is  " + placements[i]);

        }// end of loop
    }// end of main method
}// end of class
