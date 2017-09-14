package repository;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SinginScreen {
    @SuppressWarnings("unused")
    private AppiumDriver<AndroidElement> driver;

    public SinginScreen(AppiumDriver<AndroidElement> driver) {
        this.driver =  driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    /**Allow button of Access Contact alert on Join Now screen*/
    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    public AndroidElement AllowButton;
    /**Deny button of Access Contact alert on Join Now screen*/
    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_deny_button")
    public AndroidElement DenyButton;
    /**Back button on Sign In screen*/
    @AndroidFindBy(accessibility = "com.bluemark.ablifree:id/btn_join_now")
    public AndroidElement BackButton;
    /**Email Address field on Sign In screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/emailEditText")
    public AndroidElement EmailAddress;
    /**Mobile Number field on Sign In screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/edt_mobile_number")
    public AndroidElement MobileNumber;
    /**Password field on Sign In screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/passwordEditText")
    public AndroidElement Password;
    /**Forgot Your Password link on Sign In screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/forgotPasswordTextView")
    public AndroidElement ForgotPassword;
    /**Terms And Conditions link on Sign In screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/tv_terms_condition")
    public AndroidElement TermsAndConditions;
    /**SignIn Button on Sign In screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/signInButton")
    public AndroidElement SignInButton;
    /**Password Visible Toggle on Sign In screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/text_input_password_toggle")
    public AndroidElement ViewPasswordToggle;
    /**Error message on Sign In screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/snackbar_text")
    public AndroidElement ErrorMessage;
    /**Error message Dismiss button on Sign In screen*/
    @AndroidFindBy(id = "com.bluemark.ablifree:id/snackbar_action")
    public AndroidElement ErrorDismissButton;

    /**Sign In using Mobile Number and Password
     * @param email accepts mobile no as String.
     * @param password accepts password as String.
     **/
    public void SignInWithEmail(String email, String password){
        EmailAddress.replaceValue(email);
        Password.replaceValue(password);
        SignInButton.click();
    }
    /**Sign In using Mobile Number and Password
     * @param mobileno accepts mobile no as String.
     * @param password accepts password as String.
     **/
    public void SignInWithMobile(String mobileno, String password){
        EmailAddress.replaceValue("");
        MobileNumber.clear();
        MobileNumber.setValue(mobileno);
        Password.clear();
        Password.setValue(password);
        SignInButton.click();
    }
}
