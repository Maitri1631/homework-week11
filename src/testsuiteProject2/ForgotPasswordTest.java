package testsuiteProject2;

import Project1.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class ForgotPasswordTest extends BaseTest {
    String baseurl= "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    @Before
    public void setup(){
        openBrowser(baseurl);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully(){

        //Verify the forgot your password
        WebElement forgorpassword= driver.findElement(By.xpath("//div[@class='orangehrm-login-forgot']"));
        String actualText=forgorpassword.getText();
        String expectedText="Forgot your password?";
        assertEquals(expectedText,actualText);


        //Click on forgot password link
        WebElement forgotLink = driver.findElement(By.xpath("//div[@class='orangehrm-login-forgot']//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']"));
        forgotLink.click();


    }


    @After
    public void teardown(){
        //closeBrowser();
    }
}
