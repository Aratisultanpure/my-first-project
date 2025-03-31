package com.nixonex.ecommerce_automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;

public class LoginPage {

    private WebDriver driver;

    // Constructor to initialize the WebDriver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to perform the login action
    public void login(String username, String password) {
        // Find username and password fields and input the credentials
        driver.findElement(By.id("loginusername")).sendKeys(username);
        driver.findElement(By.id("loginpassword")).sendKeys(password);

        // Find and click the login button
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
    }

    // Method to check if the login was successful
    public boolean isLoginSuccessful() {
        try {
            // Example: Check if a user-specific element (like a profile icon or username) appears after successful login
            WebElement userProfile = driver.findElement(By.id("user-profile"));  // Example element for user profile
            return userProfile.isDisplayed();  // Return true if the user profile element is visible
        } catch (NoSuchElementException e) {
            return false;  // Return false if the element is not found (i.e., login failed)
        }
    }

    // Method to check if an error message is displayed (for failed login)
    public boolean isErrorMessageDisplayed() {
        try {
            // Example: Check if an error message appears when login fails
            WebElement errorMessage = driver.findElement(By.id("error-message"));  // Example error message element
            return errorMessage.isDisplayed();  // Return true if the error message is displayed
        } catch (NoSuchElementException e) {
            return false;  // Return false if no error message is found
        }
    }

    // Method to check if the user is logged in (alternative to isLoginSuccessful)
    public boolean isUserLoggedIn() {
        try {
            // Example: Check if the user is logged in by verifying a specific element's presence
            WebElement userProfile = driver.findElement(By.id("user-profile"));  // Example element for logged-in user profile
            return userProfile.isDisplayed();  // Return true if the user profile is visible
        } catch (NoSuchElementException e) {
            return false;  // Return false if the user profile element is not found
        }
    }
}
