package tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import repository.LaunchScreen;
import repository.MenuTab;
import repository.SinginScreen;
import utility.Contants;
import utility.ExcelReader;

public class SignInValidations {
    public AppiumDriver<AndroidElement> driver;

    @Test(description="Check for Mobile number lenght more than 4 numbers")
    public void mobile_more_than_Min() {
        SinginScreen signin = new SinginScreen(driver);
        signin.SignInWithMobile("12345", "abcdefgh");
        Assert.assertFalse(signin.ErrorMessage.getText().equals("Invalid Email address or Mobile number"));
        signin.ErrorDismissButton.click();
    }

    @Test(description="Check for Mobile number lenght of 4 numbers")
    public void mobile__Min() {
        SinginScreen signin = new SinginScreen(driver);
        signin.SignInWithMobile("1234", "abcdefgh");
        Assert.assertFalse(signin.ErrorMessage.getText().equals("Invalid Email address or Mobile number"));
        signin.ErrorDismissButton.click();
    }

    @Test(description="Check for Mobile number lenght less than 4 numbers")
    public void mobile_less_than_Min() {
        SinginScreen signin = new SinginScreen(driver);
        signin.SignInWithMobile("123", "abcdefgh");
        Assert.assertTrue(signin.ErrorMessage.getText().equals("Invalid Email address or Mobile number"));
        signin.ErrorDismissButton.click();
    }

    @Test(description="Check for Mobile number lenght more than 15 numbers")
    public void mobile_more_than_Max() {
        SinginScreen signin = new SinginScreen(driver);
        signin.MobileNumber.click();
        signin.MobileNumber.clear();
        signin.MobileNumber.setValue("1234567890123456");
        Assert.assertTrue(signin.MobileNumber.getText().length()<=15,"Mobile field accepts more than 15 charecters.");
    }

    @Test(description="Check for Mobile number lenght of 15 numbers")
    public void mobile_Max() {
        SinginScreen signin = new SinginScreen(driver);
        signin.MobileNumber.click();
        signin.MobileNumber.clear();
        signin.MobileNumber.setValue("123456789012345");
        Assert.assertTrue(signin.MobileNumber.getText().length()==15,"Mobile field does not accept 15 charecters.");
    }

    @Test(description="Check for Mobile number lenght less than 15 numbers")
    public void mobile_less_than_Max() {
        SinginScreen signin = new SinginScreen(driver);
        signin.MobileNumber.click();
        signin.MobileNumber.clear();
        signin.MobileNumber.setValue("12345678901234");
        Assert.assertTrue(signin.MobileNumber.getText().length()<15,"Mobile field does not accept less than 15 charecters.");
    }

    @Test(description="Check for Email Address for lenght more than 256 charecters")
    public void email_more_than_Max() {
        String MAX = "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij"
                + "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij"
                + "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefg";
        SinginScreen signin = new SinginScreen(driver);
        signin.EmailAddress.replaceValue(MAX);
        Assert.assertTrue(signin.EmailAddress.getText().length()<=256,"Email field accepts more than 256 charecters.");
    }

    @Test(description="Check for Email Address for lenght of 256 charecters")
    public void email_Max() {
        String MAX = "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij"
                + "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij"
                + "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdef";
        SinginScreen signin = new SinginScreen(driver);
        signin.EmailAddress.replaceValue(MAX);
        Assert.assertTrue(signin.EmailAddress.getText().length()==256,"Mobile field accepts 256 charecters.");
    }

    @Test(description="Check for Email Address for lenght less than 256 charecters")
    public void email_less_than_Max() {
        String MAX = "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij"
                + "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij"
                + "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcde";
        SinginScreen signin = new SinginScreen(driver);
        signin.EmailAddress.replaceValue(MAX);
        Assert.assertTrue(signin.EmailAddress.getText().length()<256,"Mobile field accepts less than 256 charecters.");
    }

    @Test(description="Check for Email Address for lenght more than 6 charecters")
    public void email_more_than_Min() {
        SinginScreen signin = new SinginScreen(driver);
        signin.SignInWithEmail("a@b.com", "abcdefgh");
        Assert.assertFalse(signin.ErrorMessage.getText().equals("Invalid Email address or Mobile number"));
        signin.ErrorDismissButton.click();
    }

    @Test(description="Check for Email Address for lenght of 6 charecters")
    public void email__Min() {
        SinginScreen signin = new SinginScreen(driver);
        signin.SignInWithEmail("a@b.ca", "abcdefgh");
        Assert.assertFalse(signin.ErrorMessage.getText().equals("Invalid Email address or Mobile number"));
        signin.ErrorDismissButton.click();
    }

    @Test(description="Check for Email Address for lenght less than 6 charecters")
    public void email_less_than_Min() {
        SinginScreen signin = new SinginScreen(driver);
        signin.SignInWithEmail("a@b.c", "abcdefgh");
        Assert.assertTrue(signin.ErrorMessage.getText().equals("Invalid Email address or Mobile number"));
        signin.ErrorDismissButton.click();
    }

    @Test(description="Check for Email Address field for valid email address")
    public void email_valid() {
        SinginScreen signin = new SinginScreen(driver);
        signin.SignInWithEmail("abc@hg.com", "abcdefgh");
        Assert.assertFalse(signin.ErrorMessage.getText().equals("Invalid Email address or Mobile number"));
        signin.ErrorDismissButton.click();
    }

    @Test(description="Check for invalid email ids", dataProvider= "InvalidEmail")
    public void email_invalid(String email) {
        SinginScreen signin = new SinginScreen(driver);
        signin.SignInWithEmail(email, "abcdefgh");
        Assert.assertTrue(signin.ErrorMessage.getText().equals("Invalid Email address or Mobile number"));
        signin.ErrorDismissButton.click();
    }

    @Test(description="Check for Password field for lenght more than 6 charecters")
    public void password_more_than_Min() {
        SinginScreen signin = new SinginScreen(driver);
        signin.SignInWithEmail("a@b.com", "abcdefg");
        Assert.assertFalse(signin.ErrorMessage.getText().equals("Invalid Email address or Mobile number"));
        signin.ErrorDismissButton.click();
    }

    @Test(description="Check for Password field for lenght of 6 charecters")
    public void password__Min() {
        SinginScreen signin = new SinginScreen(driver);
        signin.SignInWithEmail("a@b.com", "abcdef");
        Assert.assertFalse(signin.ErrorMessage.getText().equals("Invalid Email address or Mobile number"));
        signin.ErrorDismissButton.click();
    }

    @Test(description="Check for Password field for lenght less than 6 charecters")
    public void password_less_than_Min() {
        SinginScreen signin = new SinginScreen(driver);
        signin.SignInWithEmail("a@b.com", "abcde");
        Assert.assertTrue(signin.ErrorMessage.getText().equals("Invalid Email address or Mobile number"));
        signin.ErrorDismissButton.click();
    }

    @Test(description="Check for Password field for lenght more than 25 charecters")
    public void password_more_than_Max() {
        String MAX = "abcd567890efgh56789012345a";
        SinginScreen signin = new SinginScreen(driver);

        signin.Password.clear();
        signin.Password.setValue(MAX);
        Assert.assertTrue(signin.Password.getText().length()<=25);
    }

    @Test(description="Check for Password field for lenght of 25 charecters")
    public void password_Max() {
        String MAX = "abcd567890efgh56789012345";
        SinginScreen signin = new SinginScreen(driver);

        signin.Password.clear();
        signin.Password.setValue(MAX);
        Assert.assertTrue(signin.Password.getText().length()==25);
    }

    @Test(description="Check for Password field for lenght more than 6 charecters")
    public void password_less_than_Max() {
        String MAX = "abcd567890efgh5678901234";
        SinginScreen signin = new SinginScreen(driver);

        signin.Password.clear();
        signin.Password.setValue(MAX);
        Assert.assertTrue(signin.Password.getText().length()<25);
    }

    @Test(description="Check for Password field for lenght more than 6 charecters")
    public void validSignIn() {
        SinginScreen signin = new SinginScreen(driver);
        signin.SignInWithEmail("tatsgaurav@gmail.com", "gaurav@123");
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        MenuTab menu = new MenuTab(driver);
        Assert.assertTrue(menu.ExploreTab.isDisplayed());
    }

    @DataProvider(name = "InvalidEmail")

    public Object[] InvalidEmail() throws Exception{

        ExcelReader userData = new ExcelReader(Contants.TestData, "Sheet1");

        ArrayList<Object> dataList = new ArrayList<Object>();

        int i = 1;// excluding header row
        int totalRows = userData.getLastRow();
        while (i < totalRows) {
            Object[] dataLine = new Object[1];
            dataLine[0] = userData.getCell(i, 0);
            dataList.add(dataLine);

            i++;
        }

        Object[][] data = new Object[dataList.size()][];
        for (i = 0; i < dataList.size(); i++)
            data[i] = (Object[]) dataList.get(i);

        return data;

    }



    @SuppressWarnings("unchecked")
    @BeforeTest
    public void setUp() throws Exception {
        int permission = 0;
        /**Initialize Driver*/
        driver =  (AppiumDriver<AndroidElement>) DriverInit.getInstance().getDriver();
        /**Check OS version*/
        String Version = driver.getCapabilities().getCapability("platformVersion").toString();
        /**Set permission flag for Android version 6 and above.*/
        if(Version.startsWith("6") || Version.startsWith("7"))
            permission = 1;
        LaunchScreen launch = new LaunchScreen(driver);

        if(permission==1)
            launch.AllowButton.click();
        launch.SignInButton.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        SinginScreen signin = new SinginScreen(driver);
        if(permission==1)
            signin.AllowButton.click();
        signin.ViewPasswordToggle.click();
    }

    @AfterTest
    public void tearDown() {
        driver.closeApp();
    }
}
