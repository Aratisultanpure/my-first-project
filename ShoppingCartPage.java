package com.nixonex.ecommerce_automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {
    private WebDriver driver;
    
    private By checkoutButton = By.xpath("//button[text()='Proceed to checkout']");
    
    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }
    
    // Method to proceed to checkout
    public void checkout() {
        driver.findElement(checkoutButton).click();
    }
}