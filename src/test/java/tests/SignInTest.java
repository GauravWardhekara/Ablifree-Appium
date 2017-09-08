package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import repository.LaunchScreen;
import repository.SinginScreen;

public class SignInTest {
    public AppiumDriver<AndroidElement> driver;
    @Test
    public void test() throws Exception {
        LaunchScreen launch = new LaunchScreen(driver);
        launch.SignInButton.click();
        SinginScreen signin = new SinginScreen(driver);
        Thread.sleep(10000);
        signin.SignInWithEmail("tatsgaurav@gmail.com", "123456");
    }

    @SuppressWarnings("unchecked")
    @BeforeTest
    public void setUp() throws Exception {
        driver =  (AppiumDriver<AndroidElement>) DriverInit.getInstance().getDriver();
        String Version = driver.getCapabilities().getCapability("platformVersion").toString();
        System.out.println(Version);
    }

    @AfterTest
    public void tearDown() {
        driver.closeApp();
    }
}
