package repository;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CardDetails {
    @SuppressWarnings("unused")
    private AppiumDriver<AndroidElement> driver;
    public CardDetails(AppiumDriver<AndroidElement> driver) {
        this.driver = (AppiumDriver<AndroidElement>) driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /**Favourite button on Card Detail screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/fab_save_card")
    public AndroidElement FavouriteButton;

    /**User Name on Card Detail screen**/
    @AndroidFindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/"
            + "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/"
            + "android.widget.RelativeLayout/android.view.ViewGroup/android.widget.TextView[1]")
    public AndroidElement UserName;

    /**Card Industry on Card Detail screen**/
    @AndroidFindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/"
            + "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/"
            + "android.widget.RelativeLayout/android.view.ViewGroup/android.widget.TextView[2]")
    public AndroidElement CardIndustry;

    /**Company name on Card Detail screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/tv_company_name")
    public AndroidElement CompanyName;

    /**Mobile number on Card Detail screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/iv_mobile_number")
    public AndroidElement MobileNumber;

    /**Landline number on Card Detail screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/iv_company_landline")
    public AndroidElement LandlineNumber;

    /**Email address on Card Detail screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/iv_company_email")
    public AndroidElement EmailAddress;

    /**URL on Card Detail screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/iv_company_address")
    public AndroidElement URL;

    /**View Attachments button on Card Detail screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/iv_company_address")
    public AndroidElement ViewAttachmentsButton;

    /**View Attachments button on Card Detail screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/btn_view_post")
    public AndroidElement ViewPostsButton;

    /**Document Count on Card Detail screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/tv_documents_counts")
    public AndroidElement DocumentsCount;

    /**Document Count on Card Detail screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/tv_links_counts")
    public AndroidElement LinksCount;

    /**Requirements Count on Card Detail screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/tv_requirements_counts")
    public AndroidElement RequirementsCount;

    /**Offerings Count on Card Detail screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/tv_offerings_counts")
    public AndroidElement OfferingsCount;

    /**Front Card Image on Card Detail screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/iv_front_card")
    public AndroidElement FrontCardImage;

    /**Front Card Image on Card Detail screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/iv_back_card")
    public AndroidElement BackCardImage;

    /**Add to contact button on Card Detail screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/add_contact_menu")
    public AndroidElement AddContactButton;
    /**Share button on Card Detail screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/share_menu")
    public AndroidElement ShareButton;
}
