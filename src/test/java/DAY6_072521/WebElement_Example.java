package DAY6_072521;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebElement_Example {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        //Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        //options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);
        //navigate to mortgage calculator site
        driver.navigate().to("https://www.mortgagecalculator.org/");
        //sleep
        Thread.sleep(3000);
        //store home value as web element for shortcut so you can reuse the locator againg
        WebElement homeVal = driver.findElement(By.xpath("//*[@id='homeval']"));
        //clear the exising data on home val
        homeVal.clear();
        //enter new val on home field
        homeVal.sendKeys("45000");










    }//end of main
}//end of java class
