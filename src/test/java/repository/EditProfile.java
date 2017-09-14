package repository;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class EditProfile {
    @SuppressWarnings("unused")
    private AppiumDriver<AndroidElement> driver;
    public EditProfile(AppiumDriver<AndroidElement> driver) {
        this.driver =  driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /**Select image button on Edit Profile screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/iv_camera_small")
    public AndroidElement SelectImageButton;

    /**Full Name button on Edit Profile screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/edt_first_name")
    public AndroidElement Fullname;

    /**Email address field on Edit Profile screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/edt_email")
    public AndroidElement EmailAddress;

    /**Industry selector field on Edit Profile screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/et_industry")
    public AndroidElement Industry;

    /**Field of Work field on Edit Profile screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/et_skills_set")
    public AndroidElement FieldOfWork;

    /**Mobile number field on Edit Profile screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/et_skills_set")
    public AndroidElement MobileNumber;

    /**Date of Birth field on Edit Profile screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/edt_dob")
    public AndroidElement DateOfBirthSelctor;

    /**Gender selector field on Edit Profile screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/spinner_gender")
    public AndroidElement GenderSelctor;

    /**Marital Status selector field on Edit Profile screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/spinner_marital_status")
    public AndroidElement MaritalStatusSelctor;

    /**Country field on Edit Profile screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/edt_country")
    public AndroidElement Country;

    /**State field on Edit Profile screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/edt_state")
    public AndroidElement State;

    /**City field on Edit Profile screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/edt_city")
    public AndroidElement City;

    /**Submit button on Edit Profile screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/iv_submit_profile")
    public AndroidElement SubmitButton;

    /**Search Industry field on Edit Profile screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/edt_industry_search")
    public AndroidElement SearchIndustry;

    /**Select Industry field on Edit Profile screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/tv_industry_name")
    public AndroidElement SelectIndustry;

    /**Gender List on Edit Profile screen**/
    @AndroidFindBy(id = "android:id/text1")
    public List<AndroidElement> GenderList;

    /**Marital Status on Edit Profile screen**/
    @AndroidFindBy(id = "android:id/text1")
    public List<AndroidElement> StatusList;

    /**
     * @param gender accepts Gender as String.
     * Selects gender of the user on Edit Profile screen.
     * **/
    public void select_Gender(String gender){
        GenderSelctor.click();
        switch (gender){
            case "Male":GenderList.get(1).click();
                break;
            case "Female":GenderList.get(2).click();
                break;
            case "Other":GenderList.get(3).click();
                break;
            default:GenderList.get(0).click();
                break;
        }
    }

    /**
     * @param status accepts Marital Status as String.
     * Selects Marital Status of the user on Edit Profile screen.
     * **/
    public void select_Marital_Status(String status){
        MaritalStatusSelctor.click();
        switch (status){
            case "Single":StatusList.get(1).click();
                break;
            case "Married":StatusList.get(2).click();
                break;
            default:StatusList.get(0).click();
                break;
        }
    }

    /**
     * @param industry accepts Industry as String.
     * Selects Industry of the user on Edit Profile screen.
     * @throws Exception if fail.
     **/
    public void select_Industry (String industry)throws Exception{
        TouchAction touch = new TouchAction(driver);
        touch.longPress(Industry, Duration.ofSeconds(8)).release().tap(Industry)
                .tap(Industry).perform();
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(SearchIndustry));
        while(!SearchIndustry.isDisplayed()){
            touch.tap(Industry).perform();
        }
        SearchIndustry.setValue(industry);
        Thread.sleep(3000);
        SelectIndustry.click();
    }
}

