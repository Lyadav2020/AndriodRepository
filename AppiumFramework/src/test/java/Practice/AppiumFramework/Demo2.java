package Practice.AppiumFramework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Demo2 extends Capability 
{

	AndroidDriver<AndroidElement>driver;
		
	@BeforeTest
	public void bt() throws IOException, IOException, InterruptedException
	{
		//appiumserver.startAppiumServer();
		//driver=capabilities(appPackage,appActivity,deviceName,chromeDriver);
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(5000);
	}
	
	@Test(enabled=false)
	public void TC01() throws IOException
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //i am passing data to the name field using id and sendkeys
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Niharika");
        //i want to select the radio button which is female // i want to use xpath
        driver.findElement(By.xpath("//*[@text='Female']")).click();
        // i have to work with drop down
        //i will click on the value which is by default 
        driver.findElement(By.id("android:id/text1")).click();
        //then scroll and select india
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))").click();
        //i want to verify(assert) to check the country is selected
        String country = driver.findElement(By.xpath("//*[@text='India']")).getText();
        String Expected = "India";
        Assert.assertEquals(country, Expected);
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click(); 
	}
	
	// I want to fill the form with negative data( i mean to say without the Name) and click on let's shop? will it throw an error message if yes assert the error message and comapre with the expected.

	@Test(enabled=false)
	public void TC02() throws IOException
	{
		//driver=capabilities(appActivity,appPackage,chromeDriver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //i am passing data to the name field using id and sendkeys
       // driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Niharika");
        //i want to select the radio button which is female // i want to use xpath
        driver.findElement(By.xpath("//*[@text='Female']")).click();
        // i have to work with drop down
        //i will click on the value which is by default 
        driver.findElement(By.id("android:id/text1")).click();
        //then scroll and select india
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))").click();
        //i want to verify(assert) to check the country is selected
        String country = driver.findElement(By.xpath("//*[@text='India']")).getText();
        String Expected = "India";
        Assert.assertEquals(country, Expected);
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click(); 
        String errormsg = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
        System.out.println(errormsg);
        String expected = "Please enter your name";
        Assert.assertEquals(errormsg, expected);
	}

	@Test
	public void TC03() throws IOException, InterruptedException
	{
		
		service=startserver();
		
		driver=capabilities(appPackage,appActivity,deviceName,chromeDriver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//select product and add to cart //checkout 
		//compare the product which we selected is the same in the checkout page
		//driver=capabilities(appActivity,appPackage,chromeDriver);
		
        //i am passing data to the name field using id and sendkeys
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Latika");
        //i want to select the radio button which is female // i want to use xpath
        driver.findElement(By.xpath("//*[@text='Female']")).click();
        // i have to work with drop down
        //i will click on the value which is by default 
        driver.findElement(By.id("android:id/text1")).click();
        //then scroll and select india
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))").click();
        //i want to verify(assert) to check the country is selected
        String country = driver.findElement(By.xpath("//*[@text='Australia']")).getText();
        String Expected = "Australia";
        Assert.assertEquals(country, Expected);
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click(); 
        //click on add to cart for the product whatever it is displaying 
        driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
        driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        
        //get price and add , compare with total cost 
        
        //String P1=driver.findElements(By.className("android.widget.TextView")).get(0).getText();
        //String P2=driver.findElements(By.className("android.widget.TextView")).get(0).getText();
        //System.out.println(P1);
        //System.out.println(P2);
        //appiumserver.stopServer();
	}

}

