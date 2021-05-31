package com.demoblazestore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	WebDriver ldriver;
	
	public ProductPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Add to cart')]")
	WebElement btnAddToCart;	
	
	@FindBy(xpath="//h2[contains(text(),'Iphone 6 32gb')]")
	WebElement txtProductIphone632gb;
	
	public void clickAddToCart()
	{
		btnAddToCart.click();
	}
	
	@FindBy(id="cartur")
	WebElement lnCart;	
	
	public void clickLnCart()
	{
		lnCart.click();
	}
	
	public String getProductName()
	{
		return txtProductIphone632gb.getText();
	}
	
}
