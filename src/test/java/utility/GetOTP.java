package utility;

import java.sql.*;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class GetOTP {

    public GetOTP() {
    }

   /* public String getOTP(String mobile){
        String OTP = "";
        HtmlUnitDriver unitDriver = new HtmlUnitDriver();
        WebDriverWait wait = new WebDriverWait(unitDriver, 60);

        // open Database Values
        unitDriver.get("http://staging-ablifree.cloudapp.net/DatabaseValues.aspx");
        WebElement username = unitDriver.findElementById("txtUserName");
        WebElement password = unitDriver.findElementById("txtPassword");
        WebElement login = unitDriver.findElementById("btnSubmit");
        wait.until(ExpectedConditions.elementToBeClickable(username)).sendKeys("Administrator");
        wait.until(ExpectedConditions.elementToBeClickable(password)).sendKeys("Bluem@rkAz#reAb!ifree");
        wait.until(ExpectedConditions.elementToBeClickable(login)).click();
        WebElement OTPButton = unitDriver.findElementById("btnShowOTP");
        wait.until(ExpectedConditions.elementToBeClickable(OTPButton)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='gvOTP']/tbody/tr[1]/th[1]")));
        List<WebElement> otptable = unitDriver.findElementsByXPath(".//*[@id='gvOTP']/tbody/tr");
        String S;
        for(int i=2; i<= otptable.size(); i++){
            S = unitDriver.findElementByXPath(".//*[@id='gvOTP']/tbody/tr["+i+"]/td[2]").getText();
            if(mobile.contentEquals(S))
                OTP = unitDriver.findElementByXPath(".//*[@id='gvOTP']/tbody/tr["+i+"]/td[3]").getText();

        }
        unitDriver.close();
        System.out.println(OTP);

        return OTP;
    }*/
   public String getOTP(String mobile) throws Exception{
       String URL = "jdbc:sqlserver://staging-ablifree.database.windows.net;"
               + "database=new_staging_ablifree;"
               + "user=UserName@ablifreeuser;"
               + "password=Reset@123";
       try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

       }
       catch (Exception e){
           e.printStackTrace();
       }
       Connection con = DriverManager.getConnection(URL);
       Statement stmt = con.createStatement();
       ResultSet res = stmt.executeQuery("SELECT [otp_number] FROM [dbo].[OTP]");
       System.out.println(res.getString("otp_number"));
       con.close();
       return res.getString("otp_number");
   }

}
