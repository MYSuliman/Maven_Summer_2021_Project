package DAY8_080121;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class mouse_actions {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        //set the conditions for chromeoptions before the webdriver is defined
        ChromeOptions options = new ChromeOptions();
        //set arguments to maximize the driver and make it incognito
        options.addArguments("start-maximized");
        //options.addArguments("incognito");
        //define the webdriver
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.usps.com");

        Thread.sleep(2000);

        //move to send tab using mouse actions
        Actions mouseMove = new Actions(driver);
        try{
            System.out.println("Hovering to send tab");
            WebElement sendTab = driver.findElement(By.xpath("//*[@id='mail-ship-width']"));
            mouseMove.moveToElement(sendTab).perform();
        }catch (Exception err){
            System.out.println("unable to hover to send tab " + err);
        }//end of send tab exception

        //using actions to click to schedule a pick up
        try{
            System.out.println("Clicking to schedule a pickup");
            WebElement schedulePickup = driver.findElement(By.xpath("//a[text()='Schedule a Pickup']"));
            mouseMove.moveToElement(schedulePickup).click().perform();
        }catch (Exception err){
            System.out.println("unable to schedule a pickup "+ err);
        }//end of schedule a pickup exception

    }//end of main method
}//end of java class

