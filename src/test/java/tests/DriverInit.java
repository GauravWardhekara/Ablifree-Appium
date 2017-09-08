package tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;

/**Initiate Test*/
public class DriverInit {
    @SuppressWarnings("rawtypes")
    public AppiumDriver driver;
    private static DriverInit driverInit;
    AppiumDriverLocalService appiumService;
    String appiumServiceUrl;

    public static DriverInit getInstance() throws MalformedURLException, InterruptedException {
        if (driverInit == null) {
            driverInit = new DriverInit();
        }
        return driverInit;
    }
    /**Launch application*/
    @SuppressWarnings("rawtypes")
    private DriverInit() throws MalformedURLException, InterruptedException {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/Apps/Ablifree/");
        File app = new File(appDir, "ablifree_debug(test-2.4.7).apk");
        appiumService = AppiumDriverLocalService.buildDefaultService();
        appiumService.start();
        appiumServiceUrl = appiumService.getUrl().toString();
        System.out.println("Appium Service Address : - "+ appiumServiceUrl);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("device","Android");
        /**mandatory capabilities*/
        capabilities.setCapability("deviceName","Android");
        capabilities.setCapability("platformName","Android");
        /**other capabilities*/
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("autoGrantPermissions", "true");
        capabilities.setCapability("appPackage", "com.bluemark.ablifree");
        capabilities.setCapability("appActivity", "com.bluemark.ablifree.ui.activity.LaunchScreenActivity");
        /**disable native keyboard*/
        capabilities.setCapability("unicodeKeyboard", true);
        capabilities.setCapability("resetKeyboard", true);
        capabilities.setCapability("clearSystemFiles", true);
        driver = new AppiumDriver(new URL(appiumServiceUrl), capabilities);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        Thread.sleep(4000);
    }

    @SuppressWarnings("rawtypes")
    public AppiumDriver getDriver() {
        return this.driver;
    }
}
