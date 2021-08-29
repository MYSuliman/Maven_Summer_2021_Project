package DAY9_081421;

import Reusable_Classes.Reusable_Methods;
import org.openqa.selenium.WebDriver;

public class mlcalc_with_reusable_concepts {

    public static void main(String[] args) {
        WebDriver driver = Reusable_Methods.setDriver();

        //navigate ot mlalc
        driver.navigate().to("https://www.mlcalc.com");

        //clear and enter a purchase price
        Reusable_Methods.sendKeysMethod(driver,"//*[@id='ma']","4000","PurchasePrice");
        //clear and enter down payment
        Reusable_Methods.sendKeysMethod(driver,"//*[@id='dp']","25","Down Payment");








    }//end of main method
}//end of java class
