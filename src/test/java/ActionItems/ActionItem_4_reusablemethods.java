package ActionItems;

import Reusable_Classes.Reusable_Methods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class ActionItem_4_reusablemethods {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Reusable_Methods.setDriver();

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

            Reusable_Methods.clickMethod(driver,"//*[contains(text(),'Find a doctor')]","findDoctor");
            Thread.sleep(5000);
            Reusable_Methods.clickMethod(driver,"//*[@id='ip-no'","closePopUp");
            Reusable_Methods.clickMethod(driver,"//button[contains(text(),'Select your plan to sign in')]","dropDown");
            Reusable_Methods.clickMethod(driver,"//a[contains(text(),'Medicaid plan')]","Medicaid");
            Thread.sleep(2000);

            //switch to new tab
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            Reusable_Methods.clickMethod(driver,"//button[@id='registerbutton']","Registerbutton" );
            Reusable_Methods.sendKeysMethod(driver,"//input[@id='firstName']",firstName.get(i),"FirstName");
            Reusable_Methods.sendKeysMethod(driver,"//input[@id='lastName']",lastName.get(i),"LastName");
            Reusable_Methods.selectMethod(driver,"//select[@id='dob_month_input']",Month.get(i),"SelectMonth");
            Reusable_Methods.sendKeysMethod(driver,"//input[@id='dob_day']",Day.get(i),"SelectDay");
            Reusable_Methods.sendKeysMethod(driver,"//input[@id='dob_year']",Year.get(i),"SelectYear");
            Reusable_Methods.sendKeysMethod(driver,"//input[@id='memberId']",MemberID.get(i),"MemeberID");
            Reusable_Methods.sendKeysMethod(driver,"//input[@id='groupNumber']",GroupID.get(i),"GroupID");
            Reusable_Methods.clickMethod(driver,"//*[@id='submitBtn']","ContinueButton");
            Reusable_Methods.getText(driver,"//*[@id='personalInfo_errors']","getText");
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



