package com.demoblazestore.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
WebDriver ldriver;
public String name = "tempname1";
public String country = "India";
public String city = "Bangalore";
public String paymentType = "Success Credit Card Payment";
public String cardNumber = "4811 1111 1111 1114";
public String month = "December";
public String year = "2024";
public String cvvNumber = "123";
WebDriverWait wait;
JavascriptExecutor javascript;

	public CartPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//button[contains(text(),'Place Order')]")
	WebElement btnPlaceOrder;	
	
	@FindBy(id="orderModalLabel")
	WebElement lblPlaceOrder;	
	
	@FindBy(id="name")
	WebElement tbName;
	
	@FindBy(id="country")
	WebElement tbCountry;
	
	@FindBy(id="city")
	WebElement tbCity;
	
	@FindBy(id="card")
	WebElement tbCreditCard;
	
	@FindBy(id="month")
	WebElement tbMonth;
	
	@FindBy(id="year")
	WebElement tbYear;
	
	@FindBy(xpath="//button[@onclick='purchaseOrder()']")
	WebElement btnPurchase;
	
	@FindBy(xpath="//h2[contains(text(),'Thank you for your purchase!')]")
	WebElement msgSuccess;
	
	@FindBy(xpath="//p[@class='lead text-muted ']/br[2]")
	WebElement purchaseDetails;
	
	@FindBy(xpath="//button[contains(text(),'OK')]")
	WebElement btnOK;
	
	public void clickPlaceOrder()
	{
		btnPlaceOrder.sendKeys(Keys.ENTER);
	}
	
	public boolean displayPlaceOrder()
	{
		return lblPlaceOrder.isDisplayed();
	}
	
	public void setName(String name)
	{
		tbName.sendKeys(name);
	}
	
	public void setCountry(String country)
	{
		tbCountry.sendKeys(country);
	}
	
	public void setCity(String city)
	{
		tbCity.sendKeys(city);
	}
	
	public void setCard(String card)
	{
		tbCreditCard.sendKeys(card);
	}
	
	public void setMonth(String month)
	{
		tbMonth.sendKeys(month);
	}
	
	public void clickPurchase()
	{
		btnPurchase.sendKeys(Keys.ENTER);
	}
	public void setYear(String year)
	{
		tbYear.sendKeys(year);
	}
	
	public boolean displaySuccessMessage() {
		return msgSuccess.isDisplayed();
	}
	
	public String getPurchaseDetails()
	{
		return purchaseDetails.getText();
	}
	
	public void clickOK(WebDriver rdriver) 
	{
		javascript = (JavascriptExecutor) rdriver;
		javascript.executeScript("arguments[0].click();", btnOK);	
		
	}
}

