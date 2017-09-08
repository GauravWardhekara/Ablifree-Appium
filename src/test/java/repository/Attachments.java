/**
 *
 */
package repository;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * @author Gaurav Wardhekar
 *
 */
public class Attachments {

    /**
     *
     */
    @SuppressWarnings("unused")
    private AppiumDriver<AndroidElement> driver;
    public Attachments(AppiumDriver<AndroidElement> driver) {
        this.driver = (AppiumDriver<AndroidElement>) driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

}
