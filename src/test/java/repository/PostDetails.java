package repository;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PostDetails {

    @SuppressWarnings("unused")
    private AppiumDriver<AndroidElement> driver;
    public PostDetails(AppiumDriver<AndroidElement> driver) {
        this.driver = (AppiumDriver<AndroidElement>) driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /**User name on Post Details screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/tv_user_name")
    public AndroidElement UserName;

    /**User Industry on Post Details screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/tv_card_industry")
    public AndroidElement UserIndustry;

    /**Posted on date on Post Details screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/tv_posted_on")
    public AndroidElement Date;

    /**Post title on Post Details screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/tv_post_name")
    public AndroidElement Title;

    /**Post description on Post Details screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/tv_post_description")
    public AndroidElement Description;

    /**Target Industry caption on Post Details screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/tv_targeted_industry")
    public AndroidElement TargetIndustryCaption;

    /**Target Industry names on Post Details screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/tv_industry_name")
    public AndroidElement TargetIndustryNames;

    /**Target Area caption on Post Details screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/tv_targeted_area")
    public AndroidElement TargetAreaCaption;

    /**Target Area name list on Post Details screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/tv_target_name")
    public List<AndroidElement> TargetAreaNameList;

    /**View count on Post Details screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/tv_post_view_count")
    public List<AndroidElement> ViewCount;

    /**Favourite count on Post Details screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/tv_post_favorite_count")
    public List<AndroidElement> FavouriteCount;

    /**Interest count on Post Details screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/tv_post_interested_count")
    public List<AndroidElement> InterestCount;

    /**Save to favourites button on Post Details screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/ll_save_post")
    public List<AndroidElement> SaveButton;

    /**I'm Interested button on Post Details screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/ll_interested")
    public List<AndroidElement> InterestButton;

    /**Save to favourites button caption on Post Details screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/tv_save_post")
    public List<AndroidElement> SaveButtonCaption;

    /**I'm Interested button caption on Post Details screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/tv_interested_post")
    public List<AndroidElement> InterestButtonCaption;

    /**Post Screen Title on Post Details screen**/
    @AndroidFindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/"
            + "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/"
            + "android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView")
    public List<AndroidElement> ScreenTitle;
}
