package ActionItems;

public class ActionItem_1 {

    public static void main(String[] args) {


        //Declare zip code
        String[] myZipCode = new String[4];
        myZipCode[0] = "92336";
        myZipCode[1] = "91711";
        myZipCode[2] = "90210";
        myZipCode[3] = "91786";

        //declare street number
        int[] myStreetNumber = new int[4];
        myStreetNumber[0] = 15920;
        myStreetNumber[1] = 7861;
        myStreetNumber[2] = 1234;
        myStreetNumber[3] = 8599;

        //set the initializer
        for (int i =0; i<myZipCode.length;i++){
            //print the result

            System.out.println("My zip code is " + myZipCode[i] + " and my street number is  " + myStreetNumber[i]);
        }//end of loop

    }//end of main method
}//end of class
