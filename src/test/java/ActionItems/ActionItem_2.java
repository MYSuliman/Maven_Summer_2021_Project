package ActionItems;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActionItem_2 {
    public static void main(String[] args) throws InterruptedException {

        String[] colors = new String[3];
        colors[0] = "Blue";
        colors[1] = "Green";
        colors[2] = "White";

        //set the property and path to your chromedriver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //define the chrome driver
        WebDriver driver = new ChromeDriver();


        for (int i = 0; i < colors.length; i++) {
            //navigate to bing search page
            driver.navigate().to("https://www.bing.com");

            //maximize  browser
            driver.manage().window().maximize();

            //put few seconds wait
            Thread.sleep(2500);

            //identify the search field and enter a keyword
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(colors[i]);

            //hit submit button
            driver.findElement(By.xpath("//*[@class='sb_form_q']")).submit();

            //sleep
            Thread.sleep(2500);

            //capture the search result and only print out the number
            String result = driver.findElement(By.xpath("//*[@id='b_tween']")).getText();


            //extract the result
            String[] arrayResult = result.split(" ");
            System.out.println("The number of results for " + colors[i] + " is " + arrayResult[0]);


        }//end of loop

        //quit the driver
        driver.quit();


    }//end of main method

}//end of java class
