package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(dash.PostsButton));
        dash.PostsButton.click();
        Thread.sleep(30000);
    }

    @Test(description="Check Successful Add Offering.")
    public void postOffering() throws Exception {
        People people = new People(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(people.AddButton));

        people.AddButton.click();
        people.AddOfferingButton.click();
        AddPost post = new AddPost(driver);
        post.PostTitle.setValue("Test Offering");
        post.PostDescription.setValue("Offering description for auto test");
        post.TargetIndustriesSector.click();
        Industry industry = new Industry(driver);
        industry.selectIndustry("Accounting");
        industry.ApplyButton.click();
        TouchAction scroll = new TouchAction(driver);
        scroll.longPress(post.TargetIndustriesSector).moveTo(50,50).release().perform();
        post.TargetLocationSelctor.click();
        Location location = new Location(driver);
        location.SearchLocation.setValue("Pune");
        location.SelectLocation.click();
        Thread.sleep(3000);
        post.PostButton.click();
        Assert.assertFalse(people.AddButton.isDisplayed(),"Post Successful");
    }

    @Test(description="Check Successful Add Requirement.")
    public void postRequirement() throws Exception {
        People people = new People(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(people.AddButton));
        people.AddButton.click();
        people.AddRequirementButton.click();
        AddPost post = new AddPost(driver);
        post.PostTitle.setValue("Test Requirement");
        post.PostDescription.setValue("Offering description for auto test");
        post.TargetIndustriesSector.click();
        Industry industry = new Industry(driver);
        industry.selectIndustry("Accounting");
        industry.ApplyButton.click();
        Location location = new Location(driver);
        location.SearchLocation.setValue("Pune");
        location.SelectLocation.click();
        Thread.sleep(3000);
        post.PostButton.click();
        Assert.assertFalse(post.ErrorMessage.isDisplayed(),"Post Successful");
    }

    @Test(description="Check Title length validation for 120 characters.")
    public void postTitle_Length_Is_Equals_To_Max() throws Exception {
        People people = new People(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(people.AddButton));
        people.AddButton.click();
        people.AddRequirementButton.click();
        AddPost post = new AddPost(driver);
        post.PostTitle.setValue("12345678901234567890123456789012345678901234567890" +
                "1234567890123456789012345678901234567890123456789012345678901234567890");
        Assert.assertTrue(post.PostTitle.getText().length()== 120,"Accepts 120 characters");
        post.BackButton.click();
        Thread.sleep(2000);
        post.AlertYesButton.click();
    }

    @Test(description="Check Title length validation for more than 120 characters.")
    public void postTitle_Length_Is_Not_More_Than_Max() throws Exception {
        People people = new People(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(people.AddButton));
        people.AddButton.click();
        people.AddRequirementButton.click();
        AddPost post = new AddPost(driver);
        post.PostTitle.setValue("12345678901234567890123456789012345678901234567890" +
                "12345678901234567890123456789012345678901234567890123456789012345678901");
        Assert.assertTrue(post.PostTitle.getText().length()== 120,"Accepts 120 characters");
        post.BackButton.click();
        Thread.sleep(2000);
        post.AlertYesButton.click();
    }

    @Test(description="Check Title length validation for less than 120 characters.")
    public void postTitle_Length_Is_Not_Less_Than_Max() throws Exception {
        People people = new People(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(people.AddButton));
        people.AddButton.click();
        people.AddRequirementButton.click();
        AddPost post = new AddPost(driver);
        post.PostTitle.setValue("12345678901234567890123456789012345678901234567890" +
                "123456789012345678901234567890123456789012345678901234567890123456789");
        Assert.assertTrue(post.PostTitle.getText().length()< 120,"Accepts less than 120 characters");
        post.BackButton.click();
        Thread.sleep(2000);
        post.AlertYesButton.click();
    }
    @Test(description="Check Description length validation for 300 characters.")
    public void postDescription_Length_Is_Equals_To_Max() throws Exception {
        People people = new People(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(people.AddButton));
        people.AddButton.click();
        people.AddRequirementButton.click();
        AddPost post = new AddPost(driver);
        post.PostDescription.setValue("12345678901234567890123456789012345678901234567890" +
                "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890" +
                "12345678901234567890123456789012345678901234567890" +
                "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
        Assert.assertTrue(post.PostDescription.getText().length()== 300,"Accepts 300 characters");
        post.BackButton.click();
        Thread.sleep(2000);
        post.AlertYesButton.click();
    }

    @Test(description="Check Description length validation for more than 300 characters.")
    public void postDescription_Length_Is_Not_More_Than_Max() throws Exception {
        People people = new People(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(people.AddButton));
        people.AddButton.click();
        people.AddRequirementButton.click();
        AddPost post = new AddPost(driver);
        post.PostDescription.setValue("12345678901234567890123456789012345678901234567890" +
                "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890" +
                "12345678901234567890123456789012345678901234567890" +
                "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678902");
        System.out.println(post.PostTitle.getText().length());
        Assert.assertTrue(post.PostTitle.getText().length()== 300,"Accepts 300 characters");
        post.BackButton.click();
        Thread.sleep(2000);
        post.AlertYesButton.click();
    }

    @Test(description="Check Description length validation for less than 300 characters.")
    public void postDescription_Length_Is_Not_Less_Than_Max() throws Exception {
        People people = new People(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(people.AddButton));
        people.AddButton.click();
        people.AddRequirementButton.click();
        AddPost post = new AddPost(driver);
        post.PostDescription.setValue("12345678901234567890123456789012345678901234567890" +
                "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890" +
                "12345678901234567890123456789012345678901234567890" +
                "123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789");
        Assert.assertTrue(post.PostTitle.getText().length()< 300,"Accepts less than 300 characters");
        post.BackButton.click();
        Thread.sleep(2000);
        post.AlertYesButton.click();
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.closeApp();
        DriverInit.getInstance().appiumService.stop();
    }
}
