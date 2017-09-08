package repository;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Notifications {
    @SuppressWarnings("unused")
    private AppiumDriver<AndroidElement> driver;
    public Notifications(AppiumDriver<AndroidElement> driver) {
        this.driver = (AppiumDriver<AndroidElement>) driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /**You Tab on Notification screen.*/
    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.HorizontalScrollView"
            + "/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[1]")
    public AndroidElement YouTab;
    /**Event Tab on Notification screen.*/
    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.HorizontalScrollView"
            + "/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[1]")
    public AndroidElement EventTab;
    /**Notification title on Notification screen.*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_notification_title")
    public AndroidElement NotificationTitle;
    /**Notification description on Notification screen.*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_notification_description")
    public AndroidElement NotificationDescription;
    /**Notification time on Notification screen.*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_notification_time")
    public AndroidElement NotificationTime;
    /**Notification view details button on Notification screen.*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/btn_view_details")
    public AndroidElement VIewDetailsButton;
    /**Notification Pic button on Notification screen.*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/iv_feed_pic")
    public AndroidElement NotificationPic;
}
