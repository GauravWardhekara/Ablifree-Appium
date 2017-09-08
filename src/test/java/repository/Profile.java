package repository;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Profile {
    @SuppressWarnings("unused")
    private AppiumDriver<AndroidElement> driver;
    public Profile(AppiumDriver<AndroidElement> driver) {
        this.driver = (AppiumDriver<AndroidElement>) driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /**Favourite count on Post Details screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/tv_post_favorite_count")
    public List<AndroidElement> FavouriteCount;
}
