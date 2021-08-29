package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class practice2 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        //set the conditions for chromeoptions before the webdriver is defined
        ChromeOptions options = new ChromeOptions();
        //set arguments to maximize the driver and make it incognito
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        //define the webdriver
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.google.com");
        System.out.println(driver.getTitle());

        System.out.println(driver.getCurrentUrl());

        //System.out.println(driver.getPageSource());

        driver.navigate().to("https://www.yahoo.com");

        driver.navigate().back();

        driver.quit();









    }//end of main method
}//end of java class
