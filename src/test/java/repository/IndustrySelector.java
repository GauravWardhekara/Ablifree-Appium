package repository;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class IndustrySelector {
    private AppiumDriver<AndroidElement> driver;
    public IndustrySelector(AppiumDriver<AndroidElement> driver) {
        this.driver = (AppiumDriver<AndroidElement>) driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    /**Clear button. Clears selected industries.*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/btn_clear_filter")
    public AndroidElement ClearButton;
    /**Back button.*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/iv_back_button")
    public AndroidElement BackButton;

    /**Industry List.*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/recyclerView")
    public List<AndroidElement> IndustryList;

    /**Apply Button.*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/btn_apply")
    public AndroidElement ApplyButton;



}
