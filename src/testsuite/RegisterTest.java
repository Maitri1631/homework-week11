package testsuite;

import Project1.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import javax.xml.ws.RequestWrapper;

import static org.junit.Assert.assertEquals;

public class RegisterTest extends BaseTest {
    String baseurl="https://demo.nopcommerce.com/";
    @Before
    public void setup(){
        openBrowser(baseurl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully(){
        //Click on Register link
        WebElement register=driver.findElement(By.xpath("//div[@class='header-links']//a[text()='Register']"));
        register.click();

        //verify the text register
        WebElement registerLink=driver.findElement(By.xpath("//div[@class='header-links']//a[text()='Register']"));
        String actualText=registerLink.getText();
        String expectedText="Register";
        assertEquals(expectedText,actualText);
    }
    @Test
    public void userSholdRegisterAccountSuccessfully(){
        //click on the ‘Register’ link
        WebElement register=driver.findElement(By.xpath("//div[@class='header-links']//a[text()='Register']"));
        register.click();

        //Select gender radio button
        WebElement gender=driver.findElement(By.xpath("//div[@id='gender']//span[@class='female']"));
        gender.click();

        //Enter First name
        WebElement firstn=driver.findElement(By.id("FirstName"));
        firstn.sendKeys("Darshit");

        //Enter Last name
        WebElement lastn=driver.findElement(By.id("LastName"));
        lastn.sendKeys("Patel");

        //Select Day
        WebElement day=driver.findElement(By.name("DateOfBirthDay"));
        Select select=new Select(day);
        select.selectByVisibleText("10"); // select by visible text

        //select month
        WebElement month=driver.findElement(By.xpath("//div[@class='date-picker-wrapper']//select[@name='DateOfBirthMonth']"));
        Select select1=new Select(month);
        select1.selectByVisibleText("March");


        //Select year
        WebElement year=driver.findElement(By.name("DateOfBirthYear"));
        Select select2=new Select(year);
        select2.selectByVisibleText("1996");

        //Enter Email address
        WebElement email=driver.findElement(By.id("Email"));
        email.sendKeys("darshitpatel@gmail.com");


        //Enter Password
        WebElement password=driver.findElement(By.id("Password"));
        password.sendKeys("123456");

        //Enter Confirm password
        WebElement confirmp=driver.findElement(By.id("ConfirmPassword"));
        confirmp.sendKeys("123456");

        //Click on REGISTER button
        WebElement RegisterButton=driver.findElement(By.id("register-button"));
        RegisterButton.click();

        // Verify the text Your registration completed
        WebElement registerCompleted=driver.findElement(By.xpath("//div[@class='result']"));
        String actualText=registerCompleted.getText();
        String expectedText="Your registration completed";
        assertEquals(expectedText,actualText);
    }
    @After
    public void teardown(){
        //closeBrowser();
    }

}
