package DAY3_071721;

public class  Execution_Class {
    public static void main(String[] args) {

        Reusable_Methods.addTwoNumbers(2,3);
        Reusable_Methods.subtractTwoNumber(3,4);

        int result = Reusable_Methods.addTwoNumbersForReturn(10,20);
        System.out.println("The new result is "+ (result+5));

        int result1 = Reusable_Methods.subtractTwoNumbersForReturn(10,5);
        System.out.println("the new result it " + (result1+ 3));



    }//end of main method
}//end of java class
