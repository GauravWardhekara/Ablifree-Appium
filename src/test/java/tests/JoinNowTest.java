package tests;

import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import repository.JoinNowScreen;
import repository.LaunchScreen;
import utility.GetOTP;

import org.testng.annotations.BeforeTest;
import java.net.MalformedURLException;
import org.testng.annotations.AfterTest;

public class JoinNowTest {
    public AppiumDriver<AndroidElement> driver;
    @Test
    public void test() throws Exception {
        String mobile = "127637658232542";
        LaunchScreen launch = new LaunchScreen(driver);
        launch.JoinNowButton.click();
        JoinNowScreen joinnowscreen = new JoinNowScreen(driver);
        joinnowscreen.AllowButton.click();
        joinnowscreen.FullName.setValue("TeST GauRAv");
        joinnowscreen.Email.clear();
        joinnowscreen.Email.setValue("kali7@test.com");
        joinnowscreen.Mobile.setValue(mobile);
        joinnowscreen.Password.setValue("gaurav");
        joinnowscreen.ConfirmPassword.setValue("gaurav");
        /**Scroll screen*/
        TouchAction scroll = new TouchAction(driver);
        scroll.longPress(joinnowscreen.ConfirmPassword).moveTo(100,100).release().perform();
        Thread.sleep(3000);
        joinnowscreen.NextButton.click();
        joinnowscreen.AllowButton.click();
        GetOTP otp = new GetOTP();
        joinnowscreen.OTP.setValue(otp.getOTP(mobile));
        joinnowscreen.OTPSubmitButton.click();
        Thread.sleep(3000);

    }

    @SuppressWarnings("unchecked")
    @BeforeTest
    public void beforeTest() throws MalformedURLException, InterruptedException {
        driver =  (AppiumDriver<AndroidElement>) DriverInit.getInstance().getDriver();
    }

    @AfterTest
    public void afterTest() {
        driver.closeApp();
    }

}
