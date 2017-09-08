package repository;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LaunchScreen {
    @SuppressWarnings("unused")
    private AppiumDriver<AndroidElement> driver;
    public LaunchScreen(AppiumDriver<AndroidElement> driver) {
        this.driver = (AppiumDriver<AndroidElement>) driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    /**Join Now button on launch screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/btn_join_now")
    public AndroidElement JoinNowButton;
    /**Sign In button on launch screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/btn_sign_in")
    public AndroidElement SignInButton;
    /**Allow button of Access Contact alert on Join Now screen*/
    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    public AndroidElement AllowButton;
    /**Deny button of Access Contact alert on Join Now screen*/
    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_deny_button")
    public AndroidElement DenyButton;
}
