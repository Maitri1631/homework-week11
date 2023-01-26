package testsuiteProject2;

import Project1.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.StringReader;

public class LoginTest extends BaseTest {
    String baseurl= "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    @Before
    public void setup(){
        openBrowser(baseurl);
    }
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
        //Enter username
        WebElement username=driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        WebElement password= driver.findElement(By.name("password"));
        password.sendKeys("admin123");
        //Enter password

        //Click on Login button
        WebElement login=driver.findElement(By.xpath("//div[@class='oxd-form-actions orangehrm-login-action']"));
        login.click();

    }

    @After
    public void teardown(){
        //closeBrowser();
    }
}
