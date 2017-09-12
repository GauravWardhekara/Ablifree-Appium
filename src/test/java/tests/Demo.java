package tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import repository.*;
import utility.Contants;
import utility.ExcelReader;

public class Demo {
    public AppiumDriver<AndroidElement> driver;


    @Test(description="Check Title length validation for 120 characters.")
    public void postTitle_Length_Is_Equals_To_Max() throws Exception {
        People people = new People(driver);
        people.AddButton.click();
        people.AddRequirementButton.click();
        AddPost post = new AddPost(driver);
        post.PostDescription.setValue("12345678901234567890123456789012345678901234567890" +
                "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890" +
                "12345678901234567890123456789012345678901234567890" +
                "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678902");
        System.out.println("length: " + post.PostTitle.getText().length());
      //  Assert.assertTrue(post.PostTitle.getText().length()== 300,"Accepts 300 characters");
        post.BackButton.click();
        Thread.sleep(2000);
        post.AlertYesButton.click();
    }


    @SuppressWarnings("unchecked")
    @BeforeTest
    public void setUp() throws Exception {

        /*Initialize Driver*/
        driver =  (AppiumDriver<AndroidElement>) DriverInit.getInstance().getDriver();

        LaunchScreen launch = new LaunchScreen(driver);
        Thread.sleep(10000);
        launch.SignInButton.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        SinginScreen signin = new SinginScreen(driver);
        Thread.sleep(10000);
        signin.SignInWithEmail("tatsgaurav@gmail.com", "123456");
        Dashboard dash = new Dashboard(driver);
        dash.PostsButton.click();
        Thread.sleep(6000);
    }

    @DataProvider(name = "DP2")

    public Object[] InvalidEmail() throws Exception{

        ExcelReader userData = new ExcelReader(Contants.TestData, "Sheet1");

        ArrayList<Object> dataList = new ArrayList<>();

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
    public void tearDown() throws Exception {
        driver.closeApp();
        DriverInit.getInstance().appiumService.stop();
    }

}
