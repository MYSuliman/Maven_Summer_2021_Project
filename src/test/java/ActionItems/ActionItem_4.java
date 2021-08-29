package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class ActionItem_4 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        //set the conditions for chromeoptions before the webdriver is defined
        ChromeOptions options = new ChromeOptions();
        //set arguments to maximize the driver and make it incognito
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        //define the webdriver
        WebDriver driver = new ChromeDriver(options);


        ArrayList<String> firstName = new ArrayList<>();
        firstName.add("James");
        firstName.add("Nick");
        firstName.add("Bob");

        ArrayList<String> lastName = new ArrayList<>();
        lastName.add("White");
        lastName.add("Jones");
        lastName.add("Smith");

        ArrayList<String> Month = new ArrayList<>();
        Month.add("June");
        Month.add("July");
        Month.add("August");

        ArrayList<String> Day = new ArrayList<>();
        Day.add("11");
        Day.add("12");
        Day.add("13");

        ArrayList<String> Year = new ArrayList<>();
        Year.add("2000");
        Year.add("1999");
        Year.add("1998");

        ArrayList<String> MemberID = new ArrayList<>();
        MemberID.add("11111");
        MemberID.add("22222");
        MemberID.add("33333");

        ArrayList<String> GroupID =  new ArrayList<>();
        GroupID.add("123456");
        GroupID.add("123456");
        GroupID.add("123456");



        //iterate through the array list of month and year
        for(int i = 0; i < firstName.size();i++) {


            //navigate to united health care website
            driver.navigate().to("https://www.uhc.com/");
            Thread.sleep(2500);


            //click on find a doctor
            try {
                System.out.println("clicked on find a doctor button");
                driver.findElement(By.xpath("//*[contains(text(),'Find a doctor')]")).click();
            } catch (Exception err) {
            }//end of clicking on find a doctor

            Thread.sleep(5000);

            //closing pop up
            try {
                System.out.println("Closed the pop up, if it exists");
                driver.findElement(By.xpath("//*[@id='ip-no'")).click();
            }catch (Exception err){
            }//end of pop up


            //click on sign in drop down
            try {
                System.out.println("Clicked in sign in drop down menu");
                driver.findElement(By.xpath("//button[contains(text(),'Select your plan to sign in')]")).click();
            }catch (Exception err){
            }//end fo clicking in sign in drop down menu

            //click on Medicaid plan
            try {
                System.out.println("Clicked on Medicaid Plan");
                driver.findElement(By.xpath("//a[contains(text(),'Medicaid plan')]")).click();
            }catch (Exception err){
            }//end of clicking on Medicaid plan

            Thread.sleep(2000);

            //switch to new tab
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));


            try {
                System.out.println("Clicked on Register now button");
                driver.findElement(By.xpath("//button[@id='registerbutton']")).click();
            }catch (Exception err){
            }//end fo register now button


            try {
                System.out.println("Entering first name");
                WebElement fname = driver.findElement(By.xpath("//input[@id='firstName']"));
                fname.clear();
                fname.sendKeys(firstName.get(i));
            }catch (Exception err){
            }//end of entering first name

            try {
                System.out.println("Entering last name");
                WebElement lname = driver.findElement(By.xpath("//input[@id='lastName']"));
                lname.clear();
                lname.sendKeys(lastName.get(i));
            }catch (Exception err){
            }//end of entering first name

            try {
                System.out.println("Selecting Month");
                WebElement birthMonth = driver.findElement(By.xpath("//select[@id='dob_month_input']"));
                Select mth = new Select(birthMonth);
                mth.selectByVisibleText(Month.get(i));
            }catch (Exception err){
            }//end of entering birth month

            try {
                System.out.println("Selecting birth day");
                WebElement birthDay = driver.findElement(By.xpath("//input[@id='dob_day']"));
                birthDay.clear();
                birthDay.sendKeys(Day.get(i));
            }catch (Exception err){
            }//end of entering birth month

            try {
                System.out.println("Selecting birth year");
                WebElement birthYear = driver.findElement(By.xpath("//input[@id='dob_year']"));
                birthYear.clear();
                birthYear.sendKeys(Year.get(i));
            }catch (Exception err){
            }//end of entering birth year

            try {
                System.out.println("Entering Member ID");
                WebElement MemID = driver.findElement(By.xpath("//input[@id='memberId']"));
                MemID.clear();
                MemID.sendKeys(MemberID.get(i));
            }catch (Exception err){
            }//end of entering member ID

            try {
                System.out.println("Entering Group Number");
                WebElement GrpID = driver.findElement(By.xpath("//input[@id='groupNumber']"));
                GrpID.clear();
                GrpID.sendKeys(GroupID.get(i));
            }catch (Exception err){
            }//end of entering group ID

            //click on continue button
            try {
                System.out.println("Click on continue button");
                driver.findElement(By.xpath("//*[@id='submitBtn']")).click();
            }catch (Exception err){
            }//end of continue

            try{
                //capture error
                System.out.println("Printing out error code");
                String result = driver.findElement(By.xpath("//*[@id='personalInfo_errors']")).getText();
                System.out.println(result);
            }catch (Exception err){
                System.out.println("Unable to capture results " + err);
            }//end of error code

            Thread.sleep(2000);

            try {
                System.out.println("Switch to tab 1");
                driver.switchTo().window(tabs.get(0));
            }catch (Exception err){
            }//of of switch to tab 1

        }//end of for loop


        //close the tab that is currently open
        try {
            //close all newly opened tabs
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            driver.close();
            driver.switchTo().window(tabs.get(2));
            driver.close();
            driver.switchTo().window(tabs.get(3));
            driver.close();
        }catch (Exception err){




        }//closed the tab
    }//end of main method
}//end of java class



