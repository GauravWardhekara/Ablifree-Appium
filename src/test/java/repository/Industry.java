package repository;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Industry {

    @SuppressWarnings("unused")
    private AppiumDriver<AndroidElement> driver;
    public Industry(AppiumDriver<AndroidElement> driver) {
        this.driver = (AppiumDriver<AndroidElement>) driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /**Industry Name in Industry Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_industry_name")
    public List<AndroidElement> IndustryName;

    /**Apply button in Industry Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/btn_apply")
    public AndroidElement ApplyButton;

    /**Back button in Industry Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/iv_back_button")
    public AndroidElement BackButton;

    /**Clear button in Industry Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/btn_clear_filter")
    public AndroidElement ClearButton;

    /**Title in Industry Screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_filter_title")
    public AndroidElement Title;

    /**
     * Select Industry
     */
    public void selectIndustry(String industry)	{
        Iterator<AndroidElement> Select = IndustryName.iterator();
        do{
            AndroidElement Indus = Select.next();
            if(Indus.getText().equals(industry)) {
                Indus.click();
                break;
            }
        }while(Select.hasNext());
    }
}
