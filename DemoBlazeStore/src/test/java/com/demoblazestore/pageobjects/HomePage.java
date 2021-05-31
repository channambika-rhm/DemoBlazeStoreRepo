package com.demoblazestore.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver ldriver;
	WebDriverWait wait;
	
	public HomePage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Welcome')]")
	WebElement lnWelcomeUser;
	
	@FindBy(xpath="//a[contains(text(),'Iphone 6 32gb')]")
	WebElement lnProductIphone632gb;
	
	@FindBy(id="logout2")
	WebElement lnLogout;
	
	public boolean displayWelcomeUser(WebDriver rdriver)
	{
		wait=new WebDriverWait(rdriver, 20);
		wait.until(ExpectedConditions.visibilityOf(lnWelcomeUser));
		return lnWelcomeUser.isDisplayed();
	}
	
	public void clicklnProduct()
	{
		lnProductIphone632gb.click();
	}
	
	public void clickLogoutLn(WebDriver rdriver)
	{
		wait=new WebDriverWait(rdriver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(lnLogout));
		lnLogout.sendKeys(Keys.ENTER);;
	}
}
