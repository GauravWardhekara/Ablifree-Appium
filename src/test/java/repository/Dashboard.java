package repository;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
    private AppiumDriver<AndroidElement> driver;
    public Dashboard(AppiumDriver<AndroidElement> driver) {
        this.driver =  driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /**Feeds button on Dashboard.*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/ll_feeds")
    public AndroidElement FeedsButton;

    /**My Networks button on Dashboard.*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/ll_my_network")
    public AndroidElement MyNetworksButton;

    /**Favourites button on Dashboard.*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/ll_favourites")
    public AndroidElement FavouritesButton;

    /**Posts button on Dashboard.*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/ll_posts")
    public AndroidElement PostsButton;

    /**Share EditProfile button on Dashboard.*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/ll_share_profile")
    public AndroidElement SharePofileButton;

    /**Nearby People button on Dashboard.*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/iv_nearby_people")
    public AndroidElement NearbyPeopleButton;

    /**Notification button on Dashboard.*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/iv_nearby_people")
    public AndroidElement NotificationButton;

    /**Search button on Dashboard.*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/iv_search")
    public AndroidElement SearchButton;

    /**Search button on Dashboard.*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/ll_my_profile")
    public AndroidElement MyProfileButton;

    /**Search button on Dashboard.*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_invite")
    public AndroidElement InviteButton;
}
