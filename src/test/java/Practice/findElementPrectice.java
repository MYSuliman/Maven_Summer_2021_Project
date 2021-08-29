package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class findElementPrectice {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        //set the conditions for chromeoptions before the webdriver is defined
        ChromeOptions options = new ChromeOptions();
        //set arguments to maximize the driver and make it incognito
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        //define the webdriver
        WebDriver driver = new ChromeDriver(options);

        //navigate to facebook.com
        driver.navigate().to("https://www.facebook.com/");

        //click on email
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("momosuliman@yahoo.com");

        driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("123456");

        Thread.sleep(1000);

        driver.quit();












    }//end of main method
}//end of java class
