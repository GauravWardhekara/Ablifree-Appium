package tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import repository.LaunchScreen;
import repository.SinginScreen;
import utility.Contants;
import utility.ExcelReader;

public class Demo {
    public AppiumDriver<AndroidElement> driver;


    @Test(description="Check for invalid email ids")
    public void email_invalid() throws InterruptedException {
        SinginScreen signin = new SinginScreen(driver);
        signin.SignInWithEmail("test55@gmail.com", "123456");
        Thread.sleep(20000);
    }


    @SuppressWarnings("unchecked")
    @BeforeTest
    public void setUp() throws Exception {

        /*Initialize Driver*/
        driver =  (AppiumDriver<AndroidElement>) DriverInit.getInstance().getDriver();


        LaunchScreen launch = new LaunchScreen(driver);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        launch.SignInButton.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        SinginScreen signin = new SinginScreen(driver);

        signin.ViewPasswordToggle.click();
    }

    @DataProvider(name = "DP2")

    public Object[] InvalidEmail() throws Exception{

        ExcelReader userData = new ExcelReader(Contants.TestData, "Sheet1");

        ArrayList<Object> dataList = new ArrayList<Object>();

        int i = 1;// excluding header row
        int totalRows = userData.getLastRow();
        while (i < totalRows) {
            Object[] dataLine = new Object[1];
            dataLine[0] = userData.getCell(i, 0);
            dataList.add(dataLine);

            i++;
        }

        Object[][] data = new Object[dataList.size()][];
        for (i = 0; i < dataList.size(); i++)
            data[i] = (Object[]) dataList.get(i);

        return data;

    }

    @AfterTest
    public void tearDown() throws Exception{
        driver.closeApp();
        DriverInit.getInstance().appiumService.stop();
    }

}
