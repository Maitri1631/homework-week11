package testsuiteProject3;

import Project1.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class LoginTest  extends BaseTest {
    String baseurl="http://the-internet.herokuapp.com/login";
    @Before
    public void setup(){

        openBrowser(baseurl);
    }
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
        //Enter username
        WebElement username=driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");

        //Enter Password
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");

        //click on login
        WebElement login=driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        login.click();

        //verify secure area text
        WebElement secure=driver.findElement(By.xpath("//*[@id=\"content\"]/div/h2"));
        String actualText=secure.getText();
        String expectedText="Secure Area";
        assertEquals(expectedText,actualText);


    }

    @Test
    public void verifyTheUsernameErrorMessage(){
        WebElement username=driver.findElement(By.id("username"));
        username.sendKeys("tomsmith1");

        //Enter Password
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");

        //click on login
        WebElement login=driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        login.click();

       //Verify the error message username is invalid
        WebElement usernameerror=driver.findElement(By.xpath("//*[@id=\"flash\"]"));
        String actualText=usernameerror.getText();
        String expectedText="Your username is invalid!" +
                "\n×";
        assertEquals(expectedText,actualText);




    }
    @Test
    public void verifyThePasswordErrorMessage(){
        WebElement username=driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");

        //Enter Password
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("tomsmitherjnj");

        //click on login
        WebElement login=driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        login.click();

        //Verify password error message
        WebElement usernameerror=driver.findElement(By.xpath("//*[@id=\"flash\"]"));
        String actualText=usernameerror.getText();
        String expectedText="Your password is invalid!" +
                "\n×";
        assertEquals(expectedText,actualText);

    }
    @After
    public void teardown(){
        //closeBrowser();
    }
}
