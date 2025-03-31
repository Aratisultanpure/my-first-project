package com.nixonex.ecommerce_automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private WebDriver driver;
    
    private By productLink = By.xpath("//a[text()='Product']");
    private By addToCartButton = By.xpath("//a[@id='add-to-cart']");
    
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void addProductToCart() {
        driver.findElement(addToCartButton).click();
    }
}