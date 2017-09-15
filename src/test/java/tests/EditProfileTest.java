package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import repository.*;

import java.util.concurrent.TimeUnit;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class EditProfileTest {
    public AppiumDriver<AndroidElement> driver;


    @Test(description="Check updating of user profile with all fields filled")
    public void edit_User_Profile_With_All_Fields_Filled() throws Exception {
        MyProfile myProfile = new MyProfile(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(myProfile.EditProfileButton));
        myProfile.EditProfileButton.click();
        EditProfile editProfile = new EditProfile(driver);
        editProfile.Fullname.clear();
        editProfile.Fullname.setValue("Gaurav");
        editProfile.select_Industry("Aerobics");
        editProfile.FieldOfWork.clear();
        editProfile.FieldOfWork.setValue("Zoomba");
        TouchAction scroll = new TouchAction(driver);
        scroll.longPress(editProfile.MobileNumber).moveTo(50,50).release().perform();
        editProfile.select_Gender("Male");
        editProfile.select_Marital_Status("Single");
        editProfile.Country.clear();
        editProfile.Country.setValue("India");
        editProfile.State.clear();
        editProfile.State.setValue("Maharashtra");
        editProfile.City.clear();
        editProfile.City.setValue("Pune");
        editProfile.SubmitButton.click();
    }

    @Test(description="Check validation of Fullname for maximum length in Edit Profile")
    public void edit_User_Profile_Validate_Maximum_Character_Length_Of_Fullname() throws Exception {
        MyProfile myProfile = new MyProfile(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(myProfile.EditProfileButton));
        myProfile.EditProfileButton.click();
        EditProfile editProfile = new EditProfile(driver);
        editProfile.Fullname.clear();
        editProfile.Fullname.setValue("ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDE" +
                "FGHI ABCDEFGHI ABCDEFGHI ABCDEFGHIJ");
        Assert.assertTrue(editProfile.Fullname.getText().length()==100,"Fullname filed accepts 100 characters.");
        editProfile.BackButton.click();
        editProfile.AlertYesButton.click();
    }

    @Test(description="Check validation of Fullname for minimum length in Edit Profile")
    public void edit_User_Profile_Validate_Minimum_Character_Length_Of_Fullname() throws Exception {
        MyProfile myProfile = new MyProfile(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(myProfile.EditProfileButton));
        myProfile.EditProfileButton.click();
        EditProfile editProfile = new EditProfile(driver);
        editProfile.Fullname.clear();
        editProfile.Fullname.setValue("AB");
        TouchAction scroll = new TouchAction(driver);
        scroll.longPress(editProfile.MobileNumber).moveTo(50,50).release().perform();
        editProfile.SubmitButton.click();
        Assert.assertTrue(myProfile.AddCardButton.isDisplayed() == TRUE,"Fullname filed accepts minimum 2 characters.");
    }

    @Test(description="Check validation of Fullname for less than minimum length in Edit Profile")
    public void edit_User_Profile_Validate_Less_Than_Minimum_Character_Length_Of_Fullname() throws Exception {
        MyProfile myProfile = new MyProfile(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(myProfile.EditProfileButton));
        myProfile.EditProfileButton.click();
        EditProfile editProfile = new EditProfile(driver);
        editProfile.Fullname.clear();
        editProfile.Fullname.setValue("A");
        TouchAction scroll = new TouchAction(driver);
        scroll.longPress(editProfile.MobileNumber).moveTo(50,50).release().perform();
        editProfile.SubmitButton.click();
        Assert.assertTrue(editProfile.ErrorMessage.isDisplayed(),"Fullname filed does not accepts less than 2 characters.");
        editProfile.BackButton.click();
        editProfile.AlertYesButton.click();
    }

    @Test(description="Check validation of Fullname for less than minimum length in Edit Profile")
    public void edit_User_Profile_Validate_More_Than_Maximum_Character_Length_Of_Fullname() throws Exception {
        MyProfile myProfile = new MyProfile(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(myProfile.EditProfileButton));
        myProfile.EditProfileButton.click();
        EditProfile editProfile = new EditProfile(driver);
        editProfile.Fullname.clear();
        editProfile.Fullname.setValue("ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDE" +
                "FGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI J");
        Assert.assertTrue(editProfile.Fullname.getText().length()==100,"Fullname filed does not accepts more than 100 characters.");
        editProfile.BackButton.click();
        editProfile.AlertYesButton.click();
    }

    @Test(description="Check validation of Fullname for less than minimum length in Edit Profile")
    public void edit_User_Profile_Validate_Less_Than_Maximum_Character_Length_Of_Fullname() throws Exception {
        MyProfile myProfile = new MyProfile(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(myProfile.EditProfileButton));
        myProfile.EditProfileButton.click();
        EditProfile editProfile = new EditProfile(driver);
        editProfile.Fullname.clear();
        editProfile.Fullname.setValue("ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDE" +
                "FGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI");
        Assert.assertTrue(editProfile.Fullname.getText().length()<=100,"Fullname filed does not accepts more than 100 characters.");
        editProfile.BackButton.click();
        editProfile.AlertYesButton.click();
    }

    @Test(description="Check validation of FieldOfWork for maximum length in Edit Profile")
    public void edit_User_Profile_Validate_Maximum_Character_Length_Of_FieldOfWork() throws Exception {
        MyProfile myProfile = new MyProfile(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(myProfile.EditProfileButton));
        myProfile.EditProfileButton.click();
        EditProfile editProfile = new EditProfile(driver);
        editProfile.FieldOfWork.clear();
        editProfile.FieldOfWork.setValue("ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDE" +
                "FGHI ABCDEFGHI ABCDEFGHI ABCDEFGHIJ");
        Assert.assertTrue(editProfile.FieldOfWork.getText().length()==30,"FieldOfWork filed accepts 30 characters.");
        editProfile.BackButton.click();
        editProfile.AlertYesButton.click();
    }

    @Test(description="Check validation of FieldOfWork for minimum length in Edit Profile")
    public void edit_User_Profile_Validate_Minimum_Character_Length_Of_FieldOfWork() throws Exception {
        MyProfile myProfile = new MyProfile(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(myProfile.EditProfileButton));
        myProfile.EditProfileButton.click();
        EditProfile editProfile = new EditProfile(driver);
        editProfile.FieldOfWork.clear();
        editProfile.FieldOfWork.setValue("AB");
        TouchAction scroll = new TouchAction(driver);
        scroll.longPress(editProfile.MobileNumber).moveTo(50,50).release().perform();
        editProfile.SubmitButton.click();
        Assert.assertTrue(myProfile.AddCardButton.isDisplayed() == TRUE,"FieldOfWork filed accepts minimum 2 characters.");
    }

    @Test(description="Check validation of FieldOfWork for less than minimum length in Edit Profile")
    public void edit_User_Profile_Validate_Less_Than_Minimum_Character_Length_Of_FieldOfWork() throws Exception {
        MyProfile myProfile = new MyProfile(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(myProfile.EditProfileButton));
        myProfile.EditProfileButton.click();
        EditProfile editProfile = new EditProfile(driver);
        editProfile.FieldOfWork.clear();
        editProfile.FieldOfWork.setValue("A");
        TouchAction scroll = new TouchAction(driver);
        scroll.longPress(editProfile.MobileNumber).moveTo(50,50).release().perform();
        editProfile.SubmitButton.click();
        Assert.assertTrue(editProfile.ErrorMessage.isDisplayed(),"FieldOfWork filed does not accepts less than 2 characters.");
        editProfile.BackButton.click();
        editProfile.AlertYesButton.click();
    }

    @Test(description="Check validation of FieldOfWork for less than minimum length in Edit Profile")
    public void edit_User_Profile_Validate_More_Than_Maximum_Character_Length_Of_FieldOfWork() throws Exception {
        MyProfile myProfile = new MyProfile(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(myProfile.EditProfileButton));
        myProfile.EditProfileButton.click();
        EditProfile editProfile = new EditProfile(driver);
        editProfile.FieldOfWork.clear();
        editProfile.FieldOfWork.setValue("ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDE" +
                "FGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI J");
        Assert.assertTrue(editProfile.FieldOfWork.getText().length()==30,"FieldOfWork filed does not accepts more than 30 characters.");
        editProfile.BackButton.click();
        editProfile.AlertYesButton.click();
    }

    @Test(description="Check validation of FieldOfWork for less than minimum length in Edit Profile")
    public void edit_User_Profile_Validate_Less_Than_Maximum_Character_Length_Of_FieldOfWork() throws Exception {
        MyProfile myProfile = new MyProfile(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(myProfile.EditProfileButton));
        myProfile.EditProfileButton.click();
        EditProfile editProfile = new EditProfile(driver);
        editProfile.FieldOfWork.clear();
        editProfile.FieldOfWork.setValue("ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDE" +
                "FGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI");
        Assert.assertTrue(editProfile.FieldOfWork.getText().length()<=30,"FieldOfWork filed does not accepts more than 30 characters.");
        editProfile.BackButton.click();
        editProfile.AlertYesButton.click();
    }

    @Test(description="Check validation of Country for maximum length in Edit Profile")
    public void edit_User_Profile_Validate_Maximum_Character_Length_Of_Country() throws Exception {
        MyProfile myProfile = new MyProfile(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(myProfile.EditProfileButton));
        myProfile.EditProfileButton.click();
        EditProfile editProfile = new EditProfile(driver);
        TouchAction scroll = new TouchAction(driver);
        scroll.longPress(editProfile.MobileNumber).moveTo(50,50).release().perform();
        editProfile.Country.clear();
        editProfile.Country.setValue("ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDE" +
                "FGHI ABCDEFGHI ABCDEFGHI ABCDEFGHIJ");
        Assert.assertTrue(editProfile.Country.getText().length()==100,"Country filed accepts 100 characters.");
        editProfile.BackButton.click();
        editProfile.AlertYesButton.click();
    }

    @Test(description="Check validation of Country for minimum length in Edit Profile")
    public void edit_User_Profile_Validate_Minimum_Character_Length_Of_Country() throws Exception {
        MyProfile myProfile = new MyProfile(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(myProfile.EditProfileButton));
        myProfile.EditProfileButton.click();
        EditProfile editProfile = new EditProfile(driver);
        TouchAction scroll = new TouchAction(driver);
        scroll.longPress(editProfile.MobileNumber).moveTo(50,50).release().perform();
        editProfile.Country.clear();
        editProfile.Country.setValue("AB");
        editProfile.SubmitButton.click();
        Assert.assertTrue(myProfile.AddCardButton.isDisplayed() == TRUE,"Country filed accepts minimum 2 characters.");
    }

    @Test(description="Check validation of Country for less than minimum length in Edit Profile")
    public void edit_User_Profile_Validate_Less_Than_Minimum_Character_Length_Of_Country() throws Exception {
        MyProfile myProfile = new MyProfile(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(myProfile.EditProfileButton));
        myProfile.EditProfileButton.click();
        EditProfile editProfile = new EditProfile(driver);
        TouchAction scroll = new TouchAction(driver);
        scroll.longPress(editProfile.MobileNumber).moveTo(50,50).release().perform();
        editProfile.Country.clear();
        editProfile.Country.setValue("A");
        editProfile.SubmitButton.click();
        Assert.assertTrue(editProfile.ErrorMessage.isDisplayed() == TRUE,"Country filed does not accepts less than 2 characters.");
        editProfile.BackButton.click();
        editProfile.AlertYesButton.click();
    }

    @Test(description="Check validation of Country for less than minimum length in Edit Profile")
    public void edit_User_Profile_Validate_More_Than_Maximum_Character_Length_Of_Country() throws Exception {
        MyProfile myProfile = new MyProfile(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(myProfile.EditProfileButton));
        myProfile.EditProfileButton.click();
        EditProfile editProfile = new EditProfile(driver);
        TouchAction scroll = new TouchAction(driver);
        scroll.longPress(editProfile.MobileNumber).moveTo(50,50).release().perform();
        editProfile.Country.clear();
        editProfile.Country.setValue("ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDE" +
                "FGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI J");
        Assert.assertTrue(editProfile.Country.getText().length()==100,"Country filed does not accepts more than 100 characters.");
        editProfile.BackButton.click();
        editProfile.AlertYesButton.click();
    }

    @Test(description="Check validation of Country for less than minimum length in Edit Profile")
    public void edit_User_Profile_Validate_Less_Than_Maximum_Character_Length_Of_Country() throws Exception {
        MyProfile myProfile = new MyProfile(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(myProfile.EditProfileButton));
        myProfile.EditProfileButton.click();
        EditProfile editProfile = new EditProfile(driver);
        TouchAction scroll = new TouchAction(driver);
        scroll.longPress(editProfile.MobileNumber).moveTo(50,50).release().perform();
        editProfile.Country.clear();
        editProfile.Country.setValue("ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDE" +
                "FGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI");
        Assert.assertTrue(editProfile.Country.getText().length()<=100,"Country filed does not accepts more than 100 characters.");
        editProfile.BackButton.click();
        editProfile.AlertYesButton.click();
    }
@Test(description="Check validation of State for maximum length in Edit Profile")
    public void edit_User_Profile_Validate_Maximum_Character_Length_Of_State() throws Exception {
        MyProfile myProfile = new MyProfile(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(myProfile.EditProfileButton));
        myProfile.EditProfileButton.click();
        EditProfile editProfile = new EditProfile(driver);
        TouchAction scroll = new TouchAction(driver);
        scroll.longPress(editProfile.MobileNumber).moveTo(50,50).release().perform();
        editProfile.State.clear();
        editProfile.State.setValue("ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDE" +
                "FGHI ABCDEFGHI ABCDEFGHI ABCDEFGHIJ");
        Assert.assertTrue(editProfile.State.getText().length()==100,"State filed accepts 100 characters.");
        editProfile.BackButton.click();
        editProfile.AlertYesButton.click();
    }

    @Test(description="Check validation of State for minimum length in Edit Profile")
    public void edit_User_Profile_Validate_Minimum_Character_Length_Of_State() throws Exception {
        MyProfile myProfile = new MyProfile(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(myProfile.EditProfileButton));
        myProfile.EditProfileButton.click();
        EditProfile editProfile = new EditProfile(driver);
        TouchAction scroll = new TouchAction(driver);
        scroll.longPress(editProfile.MobileNumber).moveTo(50,50).release().perform();
        editProfile.State.clear();
        editProfile.State.setValue("AB");
        editProfile.SubmitButton.click();
        Assert.assertTrue(myProfile.AddCardButton.isDisplayed() == TRUE,"State filed accepts minimum 2 characters.");
    }

    @Test(description="Check validation of State for less than minimum length in Edit Profile")
    public void edit_User_Profile_Validate_Less_Than_Minimum_Character_Length_Of_State() throws Exception {
        MyProfile myProfile = new MyProfile(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(myProfile.EditProfileButton));
        myProfile.EditProfileButton.click();
        EditProfile editProfile = new EditProfile(driver);
        TouchAction scroll = new TouchAction(driver);
        scroll.longPress(editProfile.MobileNumber).moveTo(50,50).release().perform();
        editProfile.State.clear();
        editProfile.State.setValue("A");
        editProfile.SubmitButton.click();
        Assert.assertTrue(editProfile.ErrorMessage.isDisplayed() == TRUE,"State filed does not accepts less than 2 characters.");
        editProfile.BackButton.click();
        editProfile.AlertYesButton.click();
    }

    @Test(description="Check validation of State for less than minimum length in Edit Profile")
    public void edit_User_Profile_Validate_More_Than_Maximum_Character_Length_Of_State() throws Exception {
        MyProfile myProfile = new MyProfile(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(myProfile.EditProfileButton));
        myProfile.EditProfileButton.click();
        EditProfile editProfile = new EditProfile(driver);
        TouchAction scroll = new TouchAction(driver);
        scroll.longPress(editProfile.MobileNumber).moveTo(50,50).release().perform();
        editProfile.State.clear();
        editProfile.State.setValue("ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDE" +
                "FGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI J");
        Assert.assertTrue(editProfile.State.getText().length()==100,"State filed does not accepts more than 100 characters.");
        editProfile.BackButton.click();
        editProfile.AlertYesButton.click();
    }

    @Test(description="Check validation of State for less than minimum length in Edit Profile")
    public void edit_User_Profile_Validate_Less_Than_Maximum_Character_Length_Of_State() throws Exception {
        MyProfile myProfile = new MyProfile(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(myProfile.EditProfileButton));
        myProfile.EditProfileButton.click();
        EditProfile editProfile = new EditProfile(driver);
        TouchAction scroll = new TouchAction(driver);
        scroll.longPress(editProfile.MobileNumber).moveTo(50,50).release().perform();
        editProfile.State.clear();
        editProfile.State.setValue("ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDE" +
                "FGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI");
        Assert.assertTrue(editProfile.State.getText().length()<=100,"State filed does not accepts more than 100 characters.");
        editProfile.BackButton.click();
        editProfile.AlertYesButton.click();
    }
    @Test(description="Check validation of City for maximum length in Edit Profile")
    public void edit_User_Profile_Validate_Maximum_Character_Length_Of_City() throws Exception {
        MyProfile myProfile = new MyProfile(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(myProfile.EditProfileButton));
        myProfile.EditProfileButton.click();
        EditProfile editProfile = new EditProfile(driver);
        TouchAction scroll = new TouchAction(driver);
        scroll.longPress(editProfile.MobileNumber).moveTo(50,50).release().perform();
        editProfile.City.clear();
        editProfile.City.setValue("ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDE" +
                "FGHI ABCDEFGHI ABCDEFGHI ABCDEFGHIJ");
        Assert.assertTrue(editProfile.City.getText().length()==100,"City filed accepts 100 characters.");
        editProfile.BackButton.click();
        editProfile.AlertYesButton.click();
    }

    @Test(description="Check validation of City for minimum length in Edit Profile")
    public void edit_User_Profile_Validate_Minimum_Character_Length_Of_City() throws Exception {
        MyProfile myProfile = new MyProfile(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(myProfile.EditProfileButton));
        myProfile.EditProfileButton.click();
        EditProfile editProfile = new EditProfile(driver);
        TouchAction scroll = new TouchAction(driver);
        scroll.longPress(editProfile.MobileNumber).moveTo(50,50).release().perform();
        editProfile.City.clear();
        editProfile.City.setValue("AB");
        editProfile.SubmitButton.click();
        Assert.assertTrue(myProfile.AddCardButton.isDisplayed() == TRUE,"City filed accepts minimum 2 characters.");
    }

    @Test(description="Check validation of City for less than minimum length in Edit Profile")
    public void edit_User_Profile_Validate_Less_Than_Minimum_Character_Length_Of_City() throws Exception {
        MyProfile myProfile = new MyProfile(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(myProfile.EditProfileButton));
        myProfile.EditProfileButton.click();
        EditProfile editProfile = new EditProfile(driver);
        TouchAction scroll = new TouchAction(driver);
        scroll.longPress(editProfile.MobileNumber).moveTo(50,50).release().perform();
        editProfile.City.clear();
        editProfile.City.setValue("A");
        editProfile.SubmitButton.click();
        Assert.assertFalse(editProfile.ErrorMessage.isDisplayed() == FALSE,"City filed does not accepts less than 2 characters.");
        editProfile.BackButton.click();
        editProfile.AlertYesButton.click();
    }

    @Test(description="Check validation of City for less than minimum length in Edit Profile")
    public void edit_User_Profile_Validate_More_Than_Maximum_Character_Length_Of_City() throws Exception {
        MyProfile myProfile = new MyProfile(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(myProfile.EditProfileButton));
        myProfile.EditProfileButton.click();
        EditProfile editProfile = new EditProfile(driver);
        TouchAction scroll = new TouchAction(driver);
        scroll.longPress(editProfile.MobileNumber).moveTo(50,50).release().perform();
        editProfile.City.clear();
        editProfile.City.setValue("ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDE" +
                "FGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI J");
        Assert.assertTrue(editProfile.City.getText().length()==100,"City filed does not accepts more than 100 characters.");
        editProfile.BackButton.click();
        editProfile.AlertYesButton.click();
    }

    @Test(description="Check validation of City for less than minimum length in Edit Profile")
    public void edit_User_Profile_Validate_Less_Than_Maximum_Character_Length_Of_City() throws Exception {
        MyProfile myProfile = new MyProfile(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(myProfile.EditProfileButton));
        myProfile.EditProfileButton.click();
        EditProfile editProfile = new EditProfile(driver);
        TouchAction scroll = new TouchAction(driver);
        scroll.longPress(editProfile.MobileNumber).moveTo(50,50).release().perform();
        editProfile.City.clear();
        editProfile.City.setValue("ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI ABCDE" +
                "FGHI ABCDEFGHI ABCDEFGHI ABCDEFGHI");
        Assert.assertTrue(editProfile.City.getText().length()<=100,"City filed does not accepts more than 100 characters.");
        editProfile.BackButton.click();
        editProfile.AlertYesButton.click();
    }


    @SuppressWarnings("unchecked")
    @BeforeTest
    public void setUp() throws Exception {

        /*Initialize Driver*/
        driver =  (AppiumDriver<AndroidElement>) DriverInit.getInstance().getDriver();

        LaunchScreen launch = new LaunchScreen(driver);
        Thread.sleep(10000);
        launch.SignInButton.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        SinginScreen signin = new SinginScreen(driver);
        Thread.sleep(10000);
        signin.SignInWithEmail("tatsgaurav@gmail.com", "123456");
        Dashboard dash = new Dashboard(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(dash.PostsButton));
        dash.MyProfileButton.click();
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.closeApp();
        DriverInit.getInstance().appiumService.stop();
    }

}
