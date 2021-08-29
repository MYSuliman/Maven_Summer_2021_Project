package ActionItems;

import Reusable_Classes.Reusable_Annotations_Class;
import Reusable_Classes.Reusable_Methods;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ActionItem_6 extends Reusable_Annotations_Class {


    //declare the global variables outside the annotation methods
    WebDriver driver;
    Workbook readableFile;
    WritableWorkbook writableFile;
    WritableSheet writableSheet;
    int rowCount;

    //precondition for express
    @BeforeSuite
    public void setTheDriverAndWorkbook() throws IOException, BiffException {
        readableFile = Workbook.getWorkbook(new File("src/main/resources/AetnaWorkbook.xls"));
        writableFile = Workbook.createWorkbook(new File("src/main/resources/AetnaWorkbook_Results.xls"), readableFile);
        writableSheet = writableFile.getSheet(0);
        rowCount = writableSheet.getRows();
        driver = Reusable_Methods.setDriver();
    }//end of before suite

    @Test
    public void AetnaDoctorSearch() throws InterruptedException, WriteException, IOException {
        for (int i = 1; i < rowCount; i++) {
            //get cell's 2 arguments are column and row
            String zipCode = writableSheet.getCell(0, i).getContents();
            String Miles = writableSheet.getCell(1, i).getContents();

            //navigate to aetna
            driver.navigate().to("https://www.aetna.com/");
            Thread.sleep(2500);
            Reusable_Methods.clickMethod(driver, "//*[@class='megamenu__primary--item']", "Shop for plan");
            Thread.sleep(2000);
            Reusable_Methods.clickMethod(driver, "//*[text()='Medicare']", "click on medicare");
            Thread.sleep(2000);
            Reusable_Methods.clickMethodByIndex(driver, "//*[@class='megamenu__tertiary--link link__text--inline--tertiary']", 1, "find a doc");
            Thread.sleep(2000);
            Reusable_Methods.clickMethod(driver, "//span[contains(text(),'2021 Medicare plans you purchase yourself')]", "find a doctor");
            Reusable_Methods.sendKeysMethod(driver, "//input[@id='medZip']", zipCode, "zipCode");
            Reusable_Methods.clickMethod(driver, "//*[text()='" + zipCode + "']", "zip selection");
            Thread.sleep(2000);
            Reusable_Methods.slider(driver, "//*[@class='rz-pointer rz-pointer-min']", -100, 0);
            Thread.sleep(2000);
            Reusable_Methods.clickMethod(driver, "//*[@class='primaryPurple BtnWidth col-md-6 col-xs-12']", "Skip plan selection");
            Thread.sleep(2000);
            Reusable_Methods.clickMethod(driver, "//*[@class='mobileMarAdj anchorTagGuided']", "Medical doctor and specialist slection");
            Reusable_Methods.clickMethod(driver, "//*[@class='mobileMarAdj anchorTagGuided']", "PCP");
            Reusable_Methods.clickMethod(driver, "//*[@class='contentLink txtDecNone']", "All PCP");
            //capture text from delivery options and write to excel
            String deliveryText = Reusable_Methods.getText(driver, "//*[@class='mobileFont14px dataGridPadding']", "Doctor list");
            System.out.println(deliveryText);
            Label label = new Label(2, i, deliveryText);
            writableSheet.addCell(label);
        }//end of loop

    }//end of test

    @AfterSuite
    public void writeExcelAndQuit() throws IOException, WriteException {
        writableFile.write();
        writableFile.close();

    }//end og after suite

}//end of main
