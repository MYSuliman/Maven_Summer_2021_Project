package DAY6_072521;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scrolling_Example {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        //Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        //options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);
        //navigate to mortgage calculator site
        driver.navigate().to("https://www.yahoo.com/");
        //wait a few seconds
        Thread.sleep(3000);
        WebElement searchField = driver.findElement(By.xpath("//*[@name='p']"));
        searchField.sendKeys("cars");
        //hit the submit button on search field
        searchField.submit();

        Thread.sleep(3000);
        //need to scroll to bottom of page in order to capture result number
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0,5000)");

        //capture result and print out the number only
        String result = driver.findElement(By.xpath("//*[@class='compPagination']")).getText();
        String [] arrayResult = result.split("Next");
        System.out.println("My search number is " + arrayResult[1].trim());

        String newResult = arrayResult[1].trim();
        String [] newArray = newResult.split(" ");
        System.out.println("My search number is " + newArray[0]);

        //scroll back up to the top
        jse.executeScript("scroll(0,-5000)");
        Thread.sleep(2000);

        ///quit the driver
        driver.quit();

    }//end go main method
}//end of java class
