package com.demoblazestore.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="login2")
	WebElement lnLogin;
	
	@FindBy(id="loginusername")
	WebElement tbUserName;
	
	@FindBy(id="loginpassword")
	WebElement tbPassword;
	
	@FindBy(xpath="//button[@onclick='logIn()']")
	WebElement btnLogin;
	
	public void clickLogInLn()
	{
		lnLogin.click();
	}
	
	public void setUserName(String uname)
	{
		tbUserName.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		tbPassword.sendKeys(pwd);
	}
	
	public void clickLogIn()
	{
		btnLogin.click();
	}
}
