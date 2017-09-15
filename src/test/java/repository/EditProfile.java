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
    @AndroidFindBy(id = "com.bluemark.ablifree:id/et_industry")
    private AndroidElement Industry;

    /**Field of Work field on Edit Profile screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/et_skills_set")
    public AndroidElement FieldOfWork;

    /**Mobile number field on Edit Profile screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/et_skills_set")
    public AndroidElement MobileNumber;

    /**Date of Birth field on Edit Profile screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/edt_dob")
    private AndroidElement DateOfBirthSelctor;

    /**Gender selector field on Edit Profile screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/spinner_gender")
    private AndroidElement GenderSelctor;

    /**Marital Status selector field on Edit Profile screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/spinner_marital_status")
    private AndroidElement MaritalStatusSelctor;

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
    private AndroidElement SearchIndustry;

    /**Select Industry field on Edit Profile screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/tv_industry_name")
    private AndroidElement SelectIndustry;

    /**Gender List on Edit Profile screen**/
    @AndroidFindBy(id = "android:id/text1")
    private List<AndroidElement> GenderList;

    /**Marital Status on Edit Profile screen**/
    @AndroidFindBy(id = "android:id/text1")
    private List<AndroidElement> StatusList;

    /**Back Button*/
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    public AndroidElement BackButton;

    /**Yes Button on Alert*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/ld_btn_yes")
    public AndroidElement AlertYesButton;

    /**No Button on Alert*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/ld_btn_no")
    public AndroidElement AlertNoButton;

    /**Add Post Error Toast*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/snackbar_text")
    public AndroidElement ErrorMessage;

    /**Year Picker*/
    @AndroidFindBy(id = "android:id/date_picker_year")
    private AndroidElement Year;

    /**Day Picker*/
    @AndroidFindBy(id = "android:id/date_picker_day")
    private AndroidElement Day;

    /**Month Picker*/
    @AndroidFindBy(id = "android:id/date_picker_month")
    private AndroidElement Month;

    /**Year List*/
    @AndroidFindBy(id = "android:id/month_text_view")
    private List<AndroidElement> yearlist;

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

    /**
     * @param day accepts day as String.
     * @param month accepts month as String.
     * @param year accepts year as String.
     *
     * @throws Exception if fail.
     **/
    public void select_Date_Of_Birth (String day, String month, String year)throws Exception{
        int i=0;
        TouchAction touch = new TouchAction(driver);
        DateOfBirthSelctor.click();
        Year.click();

        while (yearlist.get(i).getText().equals(year)) {
            for(i=0; i<4; i++){
               if(yearlist.get(i).getText().equals(year)){
                   yearlist.get(i).click();
                   break;
               }
            }
            if(i==4){
                touch.press(yearlist.get(0)).moveTo(yearlist.get(3)).release().perform();
            }
        }
    }
}

