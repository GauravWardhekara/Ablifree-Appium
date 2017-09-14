package tests;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.TouchAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import repository.*;

public class Demo {
    public AppiumDriver<AndroidElement> driver;


    @Test(description="Check")
    public void demo() throws Exception {
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
        editProfile.select_Marital_Status("Married");
        editProfile.Country.clear();
        editProfile.Country.setValue("India");
        editProfile.State.clear();
        editProfile.State.setValue("Maharashtra");
        editProfile.City.clear();
        editProfile.City.setValue("Pune");
        editProfile.SubmitButton.click();
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

/*
@DataProvider(name = "DP2")

public Object[] InvalidEmail() throws Exception{

ExcelReader userData = new ExcelReader(Contants.TestData, "Sheet1");

ArrayList<Object> dataList = new ArrayList<>();

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
*/

    @AfterTest
    public void tearDown() throws Exception {
        driver.closeApp();
        DriverInit.getInstance().appiumService.stop();
    }

}
