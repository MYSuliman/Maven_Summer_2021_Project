package DAY3_071721;

public class Reusable_Methods {

    //create a void methods for adding two integer values
    public static void addTwoNumbers(int num1,int num2){
        System.out.println("My result is  " + (num1 + num2));
    }//end of method

    public static void subtractTwoNumber(int num1, int num2){
        System.out.println("My result is " + (num1-num2));
    }//end of add two numbers method

    //create a return method that will add two numbers and also you can return the result of the numbers
    public static int addTwoNumbersForReturn(int num1, int num2){
        int result = num1 + num2;
        System.out.println("My result is " + result);
        return result;
    }//end of return add two numbers


    // subtract two numbers with return
    public static int subtractTwoNumbersForReturn(int num1, int num2){
        int result1 = num1 + num2;
        return result1;
    }//

}// end of java class
