package tests;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class StartApplicaton {
    @SuppressWarnings("rawtypes")
    private static AndroidDriver driver;
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/Apps/Ablifree/");
        File app = new File(appDir, "app-debug(test-v2.2.5).apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		/*capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "6.0.1");
		capabilities.setCapability("deviceName", "Samsung Galaxy On7 Pro");


		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.bluemark.ablifree");
		capabilities.setCapability("appActivity", "com.bluemark.ablifree.ui.activity.LaunchScreenActivity");*/
        capabilities.setCapability("device","Android");
        //mandatory capabilities
        capabilities.setCapability("deviceName","Android");
        capabilities.setCapability("platformName","Android");
        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        Thread.sleep(10000);

        //driver.findElementsById("com.bluemark.ablifree:id/btn_sign_in")
        driver.quit();

    }
}
