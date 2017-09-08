package repository;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MenuTab {
    @SuppressWarnings("unused")
    private AppiumDriver<AndroidElement> driver;
    public MenuTab(AppiumDriver<AndroidElement> driver) {
        this.driver = (AppiumDriver<AndroidElement>) driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    /**People Tab on Tab bar*/
    @AndroidFindBy(xpath = "/android.widget.LinearLayout/android.widget.HorizontalScrollView"
            + "/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[1]")
    public AndroidElement PeopleTab;
    /**Notification Tab on Tab bar*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/ll_notification")
    public AndroidElement NotificationTab;
    /**Notification Count on Tab bar*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_notification_count")
    public AndroidElement NotificationCount;
    /**Explore Tab on Tab bar*/
    @AndroidFindBy(xpath =  "/android.widget.LinearLayout/android.widget.HorizontalScrollView"
            + "/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[2]")
    public AndroidElement ExploreTab;
    /**MyFavourites Tab on Tab bar*/
    @AndroidFindBy(xpath =  "/android.widget.LinearLayout/android.widget.HorizontalScrollView"
            + "/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[3]")
    public AndroidElement MyFavouritesTab;
    /**Profile Tab on Tab bar*/
    @AndroidFindBy(xpath =  "/android.widget.LinearLayout/android.widget.HorizontalScrollView"
            + "/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[5]")
    public AndroidElement ProfileTab;
}
