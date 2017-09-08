package repository;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class JoinNowScreen {
    @SuppressWarnings("unused")
    private AppiumDriver<AndroidElement> driver;
    public JoinNowScreen(AppiumDriver<AndroidElement> driver) {
        this.driver = (AppiumDriver<AndroidElement>) driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    /**Allow button of Access Contact alert on Join Now screen*/
    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    public AndroidElement AllowButton;
    /**Deny button of Access Contact alert on Join Now screen*/
    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_deny_button")
    public AndroidElement DenyButton;
    /**Camera button in select profile pic on Join Now screen*/
    @AndroidFindBy(id = "android:id/button1")
    public AndroidElement CameraButton;
    /**Gallery button in select profile pic on Join Now screen*/
    @AndroidFindBy(id = "android:id/button2")
    public AndroidElement GalleryButton;
    /**Google Sign in Button on Join Now screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/sign_in_button")
    public AndroidElement GoogleSignInButton;
    /**Full Name field on Join Now screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/edt_first_name")
    public AndroidElement FullName;
    /**Email field on Join Now screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/edt_email")
    public AndroidElement Email;
    /**Mobile field Join Now screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/edt_mobile_number")
    public AndroidElement Mobile;
    /**Password field on Join Now screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/edt_password")
    public AndroidElement Password;
    /**Confirm Password field on Join Now screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/edt_confirm_password")
    public AndroidElement ConfirmPassword;
    /**Next Button on Join Now screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/nextStepImageView")
    public AndroidElement NextButton;
    /**Back Button on Join Now screen*/
    @AndroidFindBy(accessibility  = "Navigate up")
    public AndroidElement BackButton;
    /**Select Country Code Button on Join Now screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/countryCodeHolder")
    public AndroidElement CountryCodeButton;
    /**Country Search field on Join Now screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/editText_search")
    public AndroidElement CountrySearch;
    /**Enter OTP field on Join Now screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/et_otp")
    public AndroidElement OTP;
    /**OTP Submit button on Join Now screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/ib_submit_otp")
    public AndroidElement OTPSubmitButton;
    /**Resend OTP button on Join Now screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_resend_otp")
    public AndroidElement ResendOTPButton;
    /**Error message on Sign In screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/snackbar_text")
    public AndroidElement ErrorMessage;
    /**Error message Dismiss button on Sign In screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/snackbar_action")
    public AndroidElement ErrorDismissButton;
}
