package ActionItems;

import Reusable_Classes.Reusable_Methods;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.geom.RectangularShape;
import java.io.File;
import java.io.IOException;

public class ActionItem_5 {
    public static void main(String[] args) throws InterruptedException, IOException, BiffException, WriteException {

        //step 1: locate the file path
        Workbook readableFile = Workbook.getWorkbook(new File("src/main/resources/Express_DataDriven.xls"));
        //create a writable file that mimics the readable in order to write back your result
        WritableWorkbook writableFile = Workbook.createWorkbook(new File("src/main/resources/Express_DataDriven_results.xls"), readableFile);
        //Step 2: accessing the excel sheet from the workbook
        WritableSheet writableSheet = writableFile.getSheet(0);
        //Step 3: row count will return all the rows which is not empty
        int rowCount = writableSheet.getRows();
        //set the driver
        WebDriver driver = Reusable_Methods.setDriver();
        //call the for loop to iterate through your test data from excel
        for (int i = 1; i < rowCount; i++) {
            String Size = writableSheet.getCell(0, i).getContents();
            String Quantity = writableSheet.getCell(1, i).getContents();
            String firstName = writableSheet.getCell(2, i).getContents();
            String lastName = writableSheet.getCell(3, i).getContents();
            String email = writableSheet.getCell(4, i).getContents();
            String PhoneNumber = writableSheet.getCell(5, i).getContents();
            String Address = writableSheet.getCell(6, i).getContents();
            String PostalCode = writableSheet.getCell(7, i).getContents();
            String City = writableSheet.getCell(8, i).getContents();
            String State = writableSheet.getCell(9, i).getContents();

            //navigate ot express
            driver.navigate().to("https://www.express.com");

            Reusable_Methods.clickMethod(driver, "//button[@id='closeModal']", "ClosePopUp");
            Reusable_Methods.mouseHover(driver, "//*[@class='MegaMenu_primaryNav__3G5fm']", 1, "mensTab");
            Thread.sleep(2000);
            Reusable_Methods.clickMethodByIndex(driver, "//*[contains(text(),'Polos')]", 1, "Polos");
            Thread.sleep(3000);
            Reusable_Methods.scrolling(driver, "0,5000");
            Reusable_Methods.clickMethod(driver, "//*[@class='cdS1D9eKI7bXTMHp5xeAA']", "firstPolo");
            Thread.sleep(3000);
            Reusable_Methods.clickMethod(driver, "//*[text()='" + Size + "']", "Sizes");
            Thread.sleep(2000);
            Reusable_Methods.clickMethod(driver, "//button[contains(text(),'Add to Bag')]", "addToBag");
            Thread.sleep(3000);
            Reusable_Methods.clickMethod(driver, "//p[contains(text(),'Item added to your bag')]", "AddtoBag");
            Thread.sleep(3000);
            Reusable_Methods.selectMethod(driver, "//select[@id='qdd-0-quantity']", Quantity, "Quantity");
            Thread.sleep(2000);
            Reusable_Methods.clickMethod(driver, "//button[@id='continue-to-checkout']", "checkout");
            Reusable_Methods.clickMethod(driver, "//button[contains(text(),'Checkout as Guest')]", "GuestCheckout");
            Thread.sleep(3000);
            Reusable_Methods.sendKeysMethod(driver, "//input[@id='contact-information-firstname']", firstName, "FirstName");
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='lastname']", lastName, "LastName");
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='email']", email, "email");
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='confirmEmail']", email, "email");
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='phone']", PhoneNumber, "PhoneNumber");
            Reusable_Methods.clickMethod(driver, "//span[contains(text(),'Continue')]", "Continue");
            Reusable_Methods.clickMethod(driver, "//*[@name='bluecoreCloseButton']", "closePopUp");
            Reusable_Methods.sendKeysMethod(driver, "//input[@id='shipping-firstName']", firstName, "FirstName");
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='shipping.lastName']", lastName, "LastName");
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='shipping.line1']", Address, "Address");
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='shipping.postalCode']", PostalCode, "postal");
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='shipping.city']", City, "City");
            Reusable_Methods.selectMethod(driver, "//*[@name='shipping.state']", State, "State");
            Reusable_Methods.clickMethod(driver, "//span[contains(text(),'Continue')]", "Continue");
            Thread.sleep(3000);
            String result = Reusable_Methods.getText(driver, "//*[@class='_2GPjWxrOkUxtXC7ebenttM']","ShippingToHome");
            System.out.println("My items will be delivered " + result);
            Label label = new Label(10, i, result);
            writableSheet.addCell(label);

            driver.manage().deleteAllCookies();
        }//end of loop

        writableFile.write();
        writableFile.close();

        //quit the driver
        driver.quit();

    }//end of main method
}//end of java class
