package com.demoblazestore.testcases;

import java.sql.DriverManager;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoblazestore.pageobjects.CartPage;
import com.demoblazestore.pageobjects.HomePage;
import com.demoblazestore.pageobjects.LoginPage;
import com.demoblazestore.pageobjects.ProductPage;

public class TC_SystemTest_001 extends BaseClass{

	@Test
	public void validSystemTest()
	{
		driver.get(baseURL);
		driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);
		ProductPage pp = new ProductPage(driver);
		HomePage hp = new HomePage(driver);
		CartPage cp = new CartPage(driver);
		String productName = null;
		
		try 
		{
			lp.clickLogInLn();
			lp.setUserName(username);
			lp.setPassword(password);
			lp.clickLogIn();
			
			//driver.navigate().refresh();
			
			if((hp.displayWelcomeUser(driver))==true)
			{
				hp.clicklnProduct();
			}
			else
			{
				lp.clickLogInLn();
				lp.setUserName(username);
				lp.setPassword(password);
				lp.clickLogIn();
				hp.clicklnProduct();
			}	
			
			productName = pp.getProductName();
			pp.clickAddToCart();	
			pp.clickLnCart();
			Thread.sleep(1000);
			
			cp = new CartPage(driver);
			cp.clickPlaceOrder();
			cp.setName(cp.name);
			cp.setCountry(cp.country);
			cp.setCity(cp.city);
			cp.setCard(cp.cardNumber);
			cp.setMonth(cp.month);
			cp.setYear(cp.year);
			cp.clickPurchase();
			Thread.sleep(1000);
		
			if(cp.displaySuccessMessage()==true)
			{
				
				System.out.println(productName + " is purchased successfully");
				System.out.println(cp.getPurchaseDetails());
				cp.clickOK(driver);
				hp.clickLogoutLn(driver);
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
				System.out.println(productName + " is not purchased");
			}				
			
		}
		catch(UnhandledAlertException uae)
		{
		    try
		    {
		        Alert alert = driver.switchTo().alert();
		        String alertText = alert.getText();
		        System.out.println("Alert data: " + alertText);
		        alert.accept();     
		    } 
		    catch (NoAlertPresentException nae) 
		    {
		        nae.printStackTrace();
		    } 
		    catch (NullPointerException npe) 
		    {
		        npe.printStackTrace();
		    } 
		} 
		catch(NoSuchElementException nse)
		{
			nse.printStackTrace();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
			
		
	}
}

