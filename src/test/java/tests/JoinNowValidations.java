package tests;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import repository.JoinNowScreen;
import repository.LaunchScreen;
import utility.Contants;
import utility.ExcelUtils;

public class JoinNowValidations {
    public AppiumDriver<AndroidElement> driver;
    private String sTestCaseName;
    private int iTestCaseRow;
    @Test
    public void name_more_than_Max() {
        String MAX = "ABCDEFGHIGABCDEFGHIGABCDEFGHIGABCDEFGHIGABCDEFGHIGABCDEFGHIGABCDEFGHIGABCDEFGHIGABCDEFGHIGABCDEFGHIGq";
        JoinNowScreen joinnowscreen = new JoinNowScreen(driver);
        joinnowscreen.FullName.click();
        joinnowscreen.FullName.clear();
        joinnowscreen.FullName.setValue(MAX);
        Assert.assertTrue(joinnowscreen.FullName.getText().length()<=100,"name field accepts more than 100 charecters.");
    }

    @Test
    public void name_Max() {
        String MAX = "ABCDEFGHIGABCDEFGHIGABCDEFGHIGABCDEFGHIGABCDEFGHIGABCDEFGHIGABCDEFGHIGABCDEFGHIGABCDEFGHIGABCDEFGHIG";
        JoinNowScreen joinnowscreen = new JoinNowScreen(driver);
        joinnowscreen.FullName.click();
        joinnowscreen.FullName.clear();
        joinnowscreen.FullName.setValue(MAX);
        Assert.assertTrue(joinnowscreen.FullName.getText().length()==100,"name field does not accept 100 charecters.");
    }

    @Test
    public void name_less_than_Max() {
        String MAX = "ABCDEFGHIGABCDEFGHIGABCDEFGHIGABCDEFGHIGABCDEFGHIGABCDEFGHIGABCDEFGHIGABCDEFGHIGABCDEFGHIGABCDEFGHI";
        JoinNowScreen joinnowscreen = new JoinNowScreen(driver);
        joinnowscreen.FullName.click();
        joinnowscreen.FullName.clear();
        joinnowscreen.FullName.setValue(MAX);
        Assert.assertTrue(joinnowscreen.FullName.getText().length()<100,"name field does not accept less than 100 charecters.");
    }

    @SuppressWarnings("unchecked")
    @BeforeTest
    public void beforeTest() throws MalformedURLException, InterruptedException {
        int permission = 0;
        /**Initialize Driver*/
        driver =  (AppiumDriver<AndroidElement>) DriverInit.getInstance().getDriver();
        /**Check OS version*/
        String Version = driver.getCapabilities().getCapability("platformVersion").toString();
        /**Set permission flag for Android version 6 and above.*/
        if(Version.startsWith("6") || Version.startsWith("7"))
            permission = 1;
        LaunchScreen launch = new LaunchScreen(driver);

        if(permission==1)
            launch.AllowButton.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        launch.JoinNowButton.click();
        JoinNowScreen joinnowscreen = new JoinNowScreen(driver);

        if(permission==1)
            joinnowscreen.AllowButton.click();
    }

    @AfterTest
    public void afterTest() {
        driver.closeApp();
    }
    @DataProvider

    public Object[][] InvalidEmails() throws Exception{

        // Setting up the Test Data Excel file

        ExcelUtils.setExcelFile(Contants.TestData,"Sheet1");
        sTestCaseName = this.toString();
        sTestCaseName = ExcelUtils.getTestCaseName(this.toString());
        iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,0);
        Object[][] testObjArray = ExcelUtils.getTableArray(Contants.TestData,"Sheet2",iTestCaseRow);

        return (testObjArray);

    }
}
