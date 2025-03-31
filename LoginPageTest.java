package com.nixonex.ecommerce_automation.tests;

import com.nixonex.ecommerce_automation.pages.HomePage;
import com.nixonex.ecommerce_automation.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageTest {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;

    // Initialize WebDriverManager for automatic driver setup
    @BeforeClass
    public void setup() {
        // Ensure WebDriverManager downloads the correct driver version automatically for Chrome 114
        WebDriverManager.chromedriver().setup();  // No need to specify the browser version explicitly

        // Initialize WebDriver (ChromeDriver in this case)
        driver = new ChromeDriver();
        
        // Navigate to the target site
        driver.get("https://www.demoblaze.com/");

        // Initialize Page Objects
        homePage = new HomePage(driver);
        homePage.goToLoginPage();
        loginPage = new LoginPage(driver);
    }

    // Test method for valid login with parameters
    @Test(dataProvider = "loginCredentials")
    public void testLogin(String username, String password, boolean isValid) {
        // Perform login with the provided credentials
        loginPage.login(username, password);

        // Assert that login result matches the expected outcome
        if (isValid) {
            Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed with valid credentials.");
            Assert.assertTrue(loginPage.isUserLoggedIn(), "User should be logged in after valid credentials.");
        } else {
            Assert.assertFalse(loginPage.isLoginSuccessful(), "Login should fail with invalid credentials.");
            Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed for invalid login.");
        }
    }

    // DataProvider to pass different sets of credentials to the test
    @DataProvider(name = "loginCredentials")
    public Object[][] credentialsProvider() {
        return new Object[][] {
            { "valid_username1", "valid_password1", true },  // Valid credentials
            { "valid_username2", "valid_password2", true },  // Another valid credentials
            { "invalid_username1", "invalid_password1", false }, // Invalid credentials
            { "invalid_username2", "invalid_password2", false }, // Another invalid credentials
        };
    }

    // Clean up after the tests are run
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Close the browser
        }
    }
}
