package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import repository.*;

import java.util.concurrent.TimeUnit;

public class AddPostTest {
    public AppiumDriver<AndroidElement> driver;

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

    }

    @Test
    public void postOffering() throws Exception {
        People people = new People(driver);
        people.AddButton.click();
        people.AddOfferingButton.click();
        AddPost post = new AddPost(driver);
        post.PostTitle.setValue("Test Offering");
        post.PostDescription.setValue("Offering description for auto test");
        post.TargetIndustriesSelctor.click();
        Industry industry = new Industry(driver);
        industry.selectIndustry("Accounting");
        industry.ApplyButton.click();
        post.TargetLocationSelctor.click();
        Location location = new Location(driver);
        location.SearchLocation.setValue("Pune");
        location.SelectLocation.click();
        post.PostButton.click();
        Assert.assertFalse(post.ErrorMessage.isDisplayed(),"Post Successful");
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.closeApp();
        DriverInit.getInstance().appiumService.stop();
    }
}
