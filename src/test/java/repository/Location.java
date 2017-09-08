package repository;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Location {
    @SuppressWarnings("unused")
    private AppiumDriver<AndroidElement> driver;
    public Location(AppiumDriver<AndroidElement> driver) {
        this.driver = (AppiumDriver<AndroidElement>) driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /**Search field in Location Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/search_src_text")
    public AndroidElement SearchLocation;

    /**Info message in Location Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_info_message")
    public AndroidElement Info;

    /**Select Location Title in Location Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_address_title")
    public AndroidElement SelectLocationTitle;

    /**Select Location Description in Location Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_address_description")
    public AndroidElement SelectLocationDescription;

    /**Select Location in Location Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/rootLayout")
    public AndroidElement SelectLocation;

    /**Clear text in Location Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/search_close_btn")
    public AndroidElement ClearText;
}
