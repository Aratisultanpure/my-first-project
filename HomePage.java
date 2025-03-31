package com.nixonex.ecommerce_automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    
    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    
    // Method to navigate to the Login page
    public void goToLoginPage() {
        driver.findElement(By.linkText("Log in")).click();  // Update the locator as per your page
    }
}
