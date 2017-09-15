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

public class AddCard {
    private AppiumDriver<AndroidElement> driver;
    public AddCard(AppiumDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    /** */
    @AndroidFindBy(id = " ")
    public AndroidElement CompanyName;
    /** */
    @AndroidFindBy(id = " ")
    public AndroidElement BusinessDescription;
    /** */
    @AndroidFindBy(id = " ")
    public AndroidElement EmailAddress;
    /** */
    @AndroidFindBy(id = " ")
    private AndroidElement Industry;
    /** */
    @AndroidFindBy(id = " ")
    public AndroidElement FieldOfWork;
    /** */
    @AndroidFindBy(id = " ")
    public AndroidElement MobileNumber;
    /** */
    @AndroidFindBy(id = " ")
    public AndroidElement BusinessLandline;
    /** */
    @AndroidFindBy(id = " ")
    public AndroidElement CompanyWebsite;
    /** */
    @AndroidFindBy(id = " ")
    public AndroidElement Designation;
    /** */
    @AndroidFindBy(id = " ")
    public AndroidElement DocumentVisibility;
    /** */
    @AndroidFindBy(id = " ")
    public AndroidElement SubmitButton;
    /** */
    @AndroidFindBy(id = " ")
    public AndroidElement SearchCountry;

    /** */
    @AndroidFindBy(id = " ")
    public AndroidElement CountrySelector;
    /** */
    @AndroidFindBy(id = " ")
    public AndroidElement TemplatesButton;
    /** */
    @AndroidFindBy(id = " ")
    public AndroidElement DeleteButton;
    /** */
    @AndroidFindBy(id = " ")
    List<AndroidElement> TemplateList;

    /**Select Industry field on Edit Profile screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/tv_industry_name")
    private AndroidElement SelectIndustry;

    /**Search Industry field on Edit Profile screen**/
    @AndroidFindBy(id ="com.bluemark.ablifree:id/edt_industry_search")
    private AndroidElement SearchIndustry;

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
