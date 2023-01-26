package testsuiteProject4;

import Project1.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTest {
    String baseurl= "https://www.saucedemo.com/";
    @Before
    public void setup(){

        openBrowser(baseurl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValid(){
        //Enter username
        WebElement username=driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        //Enter Password
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        //Click on login button
        WebElement login =driver.findElement(By.id("login-button"));
        login.click();

        //verify the product
        WebElement product= driver.findElement(By.xpath("//span[text()='Products']"));
        String actualText=product.getText();
        String expectedText="Products";
        assertEquals(expectedText,actualText);


    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        WebElement username=driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        //Enter Password
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        //Click on login button
        WebElement login =driver.findElement(By.id("login-button"));
        login.click();

        //verify first item
        WebElement product1=driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        String actualText=product1.getText();
        String expectedText="Sauce Labs Backpack";
        assertEquals(expectedText,actualText);

        WebElement product2=driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']"));
        String actualTxt=product2.getText();
        String expectedtxt="Sauce Labs Bike Light";
        assertEquals(expectedtxt,actualTxt);

        WebElement product3=driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']"));
        String actualTx=product3.getText();
        String expectedtx="Sauce Labs Bolt T-Shirt";
        assertEquals(expectedtx,actualTx);


        WebElement product4=driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']"));
        String actualproduct=product4.getText();
        String expectedproduct="Sauce Labs Fleece Jacket";
        assertEquals(expectedproduct,actualproduct);

        WebElement product5=driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']"));
        String actualproduct2=product5.getText();
        String expectedproduct2="Sauce Labs Onesie";
        assertEquals(expectedproduct2,actualproduct2);

        WebElement product6=driver.findElement(By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']"));
        String actualproduct3=product6.getText();
        String expectedproduct3="Test.allTheThings() T-Shirt (Red)";
        assertEquals(expectedproduct3,actualproduct3);





    }

    @After
    public void teardown(){
        //closeBrowser();
    }
}
