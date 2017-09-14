package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import repository.*;

import java.util.concurrent.TimeUnit;

public class EditProfileTest {
    public AppiumDriver<AndroidElement> driver;


    @Test(description="Check updating of user profilr with all fields filled")
    public void edit_User_Profile_With_All_Fields_Filled() throws Exception {
        MyProfile myProfile = new MyProfile(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(myProfile.EditProfileButton));
        myProfile.EditProfileButton.click();
        EditProfile editProfile = new EditProfile(driver);
        editProfile.Fullname.clear();
        editProfile.Fullname.setValue("Gaurav");
        editProfile.select_Industry("Aerobics");
        editProfile.FieldOfWork.clear();
        editProfile.FieldOfWork.setValue("Zoomba");
        TouchAction scroll = new TouchAction(driver);
        scroll.longPress(editProfile.MobileNumber).moveTo(50,50).release().perform();
        editProfile.select_Gender("Male");
        editProfile.select_Maritul_Status("Married");
        editProfile.Country.clear();
        editProfile.Country.setValue("India");
        editProfile.State.clear();
        editProfile.State.setValue("Maharashtra");
        editProfile.City.clear();
        editProfile.City.setValue("Pune");
        editProfile.SubmitButton.click();
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
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(dash.PostsButton));
        dash.MyProfileButton.click();
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.closeApp();
        DriverInit.getInstance().appiumService.stop();
    }

}
