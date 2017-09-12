package repository;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddPost {
    @SuppressWarnings("unused")
    private AppiumDriver<AndroidElement> driver;
    public AddPost(AppiumDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /**Screen Title on Add Posts screen*/
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/"
            + "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/"
            + "android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView")
    public AndroidElement ScreenTitle;

    /**Post Title field in Add Posts Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/et_post_title")
    public AndroidElement PostTitle;

    /**Post Description field in Add Posts Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/et_post_description")
    public AndroidElement PostDescription;

    /**Post First image selector in Add Posts Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/iv_post_image_first")
    public AndroidElement FirstImage;

    /**Post Second image selector in Add Posts Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/iv_post_image_second")
    public AndroidElement SecondImage;

    /**Post Target Industries selector in Add Posts Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/rl_add_target_industry")
    public AndroidElement TargetIndustriesSector;

    /**Post Target Industries Description in Add Posts Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_target_industries_description")
    public AndroidElement TargetIndustriesDescription;

    /**Post Target Industries Name in Add Posts Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_industry_name")
    public List<AndroidElement> TargetIndustriesName;

    /**Post Target Industries Delete button in Add Posts Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/iv_delete_industry")
    public List<AndroidElement> TargetIndustriesDeleteButton;

    /**Post Target Are/City selector in Add Posts Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/rl_add_target_location")
    public AndroidElement TargetLocationSelctor;

    /**Post Target Are/City description in Add Posts Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_target_address_description")
    public AndroidElement TargetLocationDescription;

    /**Post Target Are/City Name in Add Posts Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_target_name")
    public List<AndroidElement> TargetLocationName;

    /**Post Target Are/City Delete button in Add Posts Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/iv_delete_target")
    public List<AndroidElement> TargetLocationDeleterButton;

    /**Post Button in Add Posts Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/btn_add_post")
    public AndroidElement PostButton;

    /**Add Post Error Toast*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/snackbar_text")
    public AndroidElement ErrorMessage;

    /**Image Alert Text*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/ld_message")
    public AndroidElement ImageAlertMessage;

    /**Image Alert Gallery Button*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/ld_btn_no")
    public AndroidElement ImageAlertGalleryButton;

    /**Image Alert Camera Button*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/ld_btn_yes")
    public AndroidElement ImageAlertCameraButton;

    /**Back Button*/
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    public AndroidElement BackButton;

    /**Yes Button on Alert*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/ld_btn_no")
    public AndroidElement AlertYesButton;

    /**No Button on Alert*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/ld_btn_yes")
    public AndroidElement AlertNoButton;

}
