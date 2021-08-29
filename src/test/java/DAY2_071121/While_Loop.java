package DAY2_071121;

public class While_Loop {

    public static void main(String[] args) {

        String[] countries = new String[5];
        countries[0] = "USA";
        countries[1] = "Bangladesh";
        countries[2] = "Pakistan";
        countries[3] = "India";
        countries[4] = "Russia";

        //se the initializer first
        int i = 0;
        //call the while loop and define the end point
        while (i< countries.length){
            System.out.println( "My country is  " + countries[i]);
            // incrementation
            i= i +1;
        }// end of while loop

    }// end of main

}//end of class
