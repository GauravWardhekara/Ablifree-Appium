package repository;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class People {
    @SuppressWarnings("unused")
    private AppiumDriver<AndroidElement> driver;
    public People(AppiumDriver<AndroidElement> driver) {
        this.driver = (AppiumDriver<AndroidElement>) driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /**Cards Tab in People Screen*/
    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.HorizontalScrollView"
            + "/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[1]")
    public AndroidElement CardsTab;

    /**Posts Tab in People Screen*/
    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.HorizontalScrollView"
            + "/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[2]")
    public AndroidElement PostsTab;

    /**Address in People Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_title")
    public AndroidElement Address;

    /**Search in People Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/iv_search_users")
    public AndroidElement Search;

    /**Menu in People Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/iv_menu_item")
    public AndroidElement Menu;

    /**Filter button in People Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/fb_menu_item")
    public AndroidElement FilterButton;

    /**People Screen in People Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/fb_menu_item")
    public AndroidElement PeopleScreen;

    /**Card User Name on a card in People Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_user_name")
    public AndroidElement CardUserName;

    /**Card Industry on a card in People Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_card_industry")
    public AndroidElement CardIndustry;

    /**Card View Count on a card in People Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_view_count")
    public AndroidElement CardViewCount;

    /**Card Count on a card in People Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_user_card_count")
    public AndroidElement CardCount;

    /**Card Downloads Count on a card in People Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_download_count")
    public AndroidElement CardDownloadsCount;

    /**Card Distance Count on a card in People Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_cards_distance")
    public AndroidElement CardDistance;

    /**Card Image Count on a card in People Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/iv_card_photo")
    public AndroidElement CardImage;

    /**Add Offering button in People Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/menu_offering")
    public AndroidElement AddOfferingButton;

    /**Add Requirement button in People Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/menu_requirement")
    public AndroidElement AddRequirementButton;

    /**Requirement Filter in People Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_requirement")
    public AndroidElement RequirementFilter;

    /**Offering Filter in People Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_offering")
    public AndroidElement OfferingFilter;

    /**Remaining posts info in People Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_remaining_post_info")
    public AndroidElement RemainingPosts;

    /**Cross button in People Screen*/
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/"
            + "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/"
            + "android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/"
            + "android.support.v4.view.ViewPager/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ImageButton[3]")
    public AndroidElement CrossButton;

    /**Add button in People Screen*/
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/"
            + "android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/"
            + "android.support.v4.view.ViewPager/android.widget.LinearLayout/android.support.v4.view.ViewPager/"
            + "android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ImageButton")
    public AndroidElement AddButton;

    /**Applied Filter count in People Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_filter_active")
    public AndroidElement AppliedFilterCount;

    /**Post Filter count in People Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_changeFilter")
    public AndroidElement PostFilter;

    /**Post Sort By count in People Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_post_sort")
    public AndroidElement SortBy;

    /**Post Sort By toggle in People Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_default_sort")
    public AndroidElement SortByToggle;

    /**Post info message in People Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_info_message")
    public AndroidElement PostInfoMessage;

    /**Post filter label in People Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_filter_label")
    public AndroidElement PostFilterLabel;

    /**Post By my favourites in People Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_show_favorites")
    public AndroidElement PostByMyFavourites;

    /**Post My Favourites Posts in People Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_save_posts")
    public AndroidElement MyFavouritePost;

    /**My Interested Posts in People Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_interested_post")
    public AndroidElement MyInterestedPosts;

    /**My Posts in People Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_my_posts")
    public AndroidElement MyPosts;

    /**Cancel Button in Posts Menu in People Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_cancel")
    public AndroidElement CancelButton;

    /**Share Card Toggle in People Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_share_location")
    public AndroidElement ShareToggle;

    /**Fetch Cards Toggle in People Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_fetch_cards")
    public AndroidElement FetchToggle;
}
