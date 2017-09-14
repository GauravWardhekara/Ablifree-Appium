package repository;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MyProfile {
    @SuppressWarnings("unused")
    private AppiumDriver<AndroidElement> driver;
    public MyProfile(AppiumDriver<AndroidElement> driver) {
        this.driver =  driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    /**Add Card button on EditProfile screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/fab_add_card")
    public AndroidElement AddCardButton;

    /**Settings button on EditProfile screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/iv_profile_setting")
    public AndroidElement SettingsButton;

    /**Dashboard button on EditProfile screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/iv_dashboard_menu")
    public AndroidElement DashboardButton;

    /**Edit EditProfile button on EditProfile screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/iv_edit_profile")
    public AndroidElement EditProfileButton;

    /**My Posts button on EditProfile screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/rl_my_post_count")
    public AndroidElement MyPostsButton;

    /**My Posts count on EditProfile screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/tv_my_post_count")
    public AndroidElement MyPostsCount;

    /**My Events button on EditProfile screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/rl_events_count")
    public AndroidElement MyEventsButton;

    /**My Events count on EditProfile screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/tv_my_events_count")
    public AndroidElement MyEventsCount;

    /**User Name on EditProfile screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/tv_user_name")
    public AndroidElement Username;

    /**User Email on EditProfile screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/tv_user_email")
    public AndroidElement EmailAddress;

    /**Security Pin on EditProfile screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/tv_secure_pin")
    public AndroidElement SecurityPin;
}
