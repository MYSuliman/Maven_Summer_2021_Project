package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ActionItem_3 {

    public static void main(String[] args) throws InterruptedException {

        String[] zipCode = new String[3];
        zipCode[0] = "92336";
        zipCode[1] = "91711";
        zipCode[2] = "91786";

        //set the path to the driver
        WebDriverManager.chromedriver().setup();
        //Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);

        for (int i=0; i < zipCode.length; i++) {
            //navigate to web page
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop");

            //click in the studio link
            driver.findElement(By.xpath("//*[@class='studioIcon-2TdMR']")).click();

            //enter location
            driver.findElement(By.xpath("//*[@id='location-search']")).sendKeys(zipCode[i]);

            //click submit button
            driver.findElement(By.xpath("//*[@class='rightArrow-daPRP']")).submit();

            Thread.sleep(2000);

            //use if else condition inside to loop
            if (i==0){
                driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(0).click();
            }if (i==1){
               driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(1).click();
            }else if (i==2) {
                driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(2).click();

            }//end of conditional
                Thread.sleep(3000);

                //print out location
                String result = driver.findElement(By.xpath("//*[@class='locationName-1jro_']")).getText();
                System.out.println(result);

                //Scroll to bottom of page in order to capture result number
                JavascriptExecutor jse = (JavascriptExecutor)driver;
                jse.executeScript("scroll(0,3500)");

                //print out hours
                String hours = driver.findElement(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).getText();
                System.out.println(hours);

        }//end of loop

    }//end of main method
}//end of java class
