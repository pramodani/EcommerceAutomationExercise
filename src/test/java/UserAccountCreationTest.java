import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

@Test
public class UserAccountCreationTest {

    @Test
    public void createNewUser(){

        // Configuring the system properties of chrome driver
        System.setProperty("webdriver.chrome.driver","C:\\Users\\PramodaniJ\\Desktop\\Selenium\\EcommerceAutomationExercise\\src\\test\\resources\\chromedriver.exe");

        // Initializing the browser driver
        WebDriver driver = new ChromeDriver();

        // Maximizing the browser window
        driver.manage().window().maximize();

        // Navigating to the provided link
        driver.get("http://automationpractice.com/index.php");

        // Locating the WebElement and clicking on it
        WebElement signInButton = driver.findElement(By.xpath("//div[@class=\"header_user_info\"]//a[@class=\"login\"]"));
        signInButton.click();

        WebElement emailField = driver.findElement(By.xpath("//input[@id=\"email_create\"]"));
        // Generating a random number to get a unique email
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(10000);
        emailField.sendKeys("ruby" + randomNumber + "@gmail.com");

        WebElement createAccountButton = driver.findElement(By.xpath("//i[@class=\"icon-user left\"]"));
        createAccountButton.click();

        // explicit wait - to wait for the compose button to be click-able
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer_firstname")));

        WebElement firstNameField = driver.findElement(By.id("customer_firstname"));
        firstNameField.sendKeys("Promodani");

        WebElement lastNameField = driver.findElement(By.id("customer_lastname"));
        lastNameField.sendKeys("Jayakodi");

        WebElement passwordField = driver.findElement(By.id("passwd"));
        passwordField.sendKeys("testpw");

        WebElement addressField = driver.findElement(By.id("address1"));
        addressField.sendKeys("addressline3");

        WebElement cityField = driver.findElement(By.id("city"));
        cityField.sendKeys("Miami");

        // Identifying the dropdown
        Select stateDropdown = new Select(driver.findElement(By.id("id_state")));
        stateDropdown.selectByVisibleText("Florida");

        WebElement zipcodeField = driver.findElement(By.id("postcode"));
        zipcodeField.sendKeys("60000");

        WebElement mobileNumberField = driver.findElement(By.id("phone_mobile"));
        mobileNumberField.sendKeys("014589564");

        WebElement aliasAddressField = driver.findElement(By.id("alias"));
        aliasAddressField.sendKeys("addressalias");

        WebElement registerButton = driver.findElement(By.xpath("//span[text()=\"Register\"]"));
        registerButton.click();

        WebElement myAccountTitle = driver.findElement(By.xpath("//h1[text()=\"My account\"]"));
        // Check if my account title is displayed
        boolean isTitleDisplayed = myAccountTitle.isDisplayed();
        String titleName = myAccountTitle.getText();

        Assert.assertEquals(titleName, "MY ACCOUNT");
        // Checks if Passing value is true, if so test pass
        Assert.assertTrue(isTitleDisplayed);

        driver.quit();
    }


}
