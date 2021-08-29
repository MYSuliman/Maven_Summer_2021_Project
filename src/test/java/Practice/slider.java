package Practice;

import Reusable_Classes.Reusable_Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class slider {
    public static void main(String[] args) throws InterruptedException {

        //WebDriver driver = Reusable_Methods.setDriver();
        //driver.navigate().to("http://demo.automationtesting.in/Slider.html");
        //Thread.sleep(3000);
        //Reusable_Methods.slider(driver,"//div[@id='slider']",200,301);

        //Reusable_Methods.clickMethod(driver,"//span[contains(text(),'2021 Medicare plans through an employer')]","click on Plan");
        //Reusable_Methods.sendKeysMethod(driver,"//input[@id='medZip']","92336","zipCode");
        //Reusable_Methods.slider(driver,"//*[class@='rz-bar-wrapper']",568,900 );
        //Thread.sleep(2000);


        WebDriver driver = Reusable_Methods.setDriver();
        driver.navigate().to("https://www.aetna.com/dsepublic/#/contentPage?page=providerSearchLanding&site_id=medicare&language=en");
        Thread.sleep(3000);
        Reusable_Methods.clickMethod(driver,"//span[contains(text(),'2021 Medicare plans through an employer')]","click on Plan");
        Reusable_Methods.slider(driver,"//*[@class='rz-pointer rz-pointer-min']",-120,0);
        //Reusable_Methods.slider(driver,"//*[text()='" + 44 + "Miles" +"']",0,0);
        //Reusable_Methods.clickMethod(driver, "//*[text()='" + Size + "']", "Sizes");







    }
}
