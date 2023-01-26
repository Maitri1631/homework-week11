package testsuiteProject5;

import Project1.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTest {

    String baseurl= "https://courses.ultimateqa.com/";
    @Before
    public void setup(){

        openBrowser(baseurl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //Click on login
        WebElement signin=driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']"));
        signin.click();

        //verify the welcome back
        WebElement welcome=driver.findElement(By.xpath("//h2[@class='page__heading']"));
        String actualText=welcome.getText();
        String expectedText="Welcome Back!";
        assertEquals(expectedText,actualText);
    }
    @Test
    public void verifyTheErrorMessage(){
        //Click on login
        WebElement signin=driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']"));
        signin.click();

        //Enter invalid username
        WebElement username=driver.findElement(By.id("user[email]"));
        username.sendKeys("maitryp");
        //Enter invalid password
        WebElement password=driver.findElement(By.id("user[password]"));
        password.sendKeys("4654");
        //Click on login button
        WebElement login=driver.findElement(By.xpath("//button[@class='button button-primary g-recaptcha']"));
        login.click();
        //Verify the error message
        WebElement errormsg=driver.findElement(By.xpath("//ul[@class='form-error__list']"));
        String actualText=errormsg.getText();
        String expectedText="Invalid email or password.";
        assertEquals(expectedText,actualText);
    }
    @After
    public void teardown(){
        //closeBrowser();
    }
}
