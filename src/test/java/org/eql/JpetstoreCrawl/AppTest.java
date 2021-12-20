package org.eql.JpetstoreCrawl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	
	WebDriver driver;
	WebDriverWait wait;
	Logger LOGGER = LoggerFactory.getLogger(AppTest.class);
	
	

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver","src/main/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver,20);
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void jpetstoreTest() {
		
		LOGGER.info("****Step 1 : connect to jps url****");
		driver.get("http://localhost:8080/jpetstore");

		LOGGER.info("****Step 2 : accessing jpetstore mainpage****");
		WebElement enterstore = driver.findElement(By.xpath("//a[@href='actions/Catalog.action']"));
		wait.until(ExpectedConditions.elementToBeClickable(enterstore));
		enterstore.click();
		
		LOGGER.info("****Step 3 : accessing jpetstore sign in page****");
		WebElement signinlink = driver.findElement(By.xpath("//a[contains(@href,'signon')]"));
		wait.until(ExpectedConditions.elementToBeClickable(signinlink));
		signinlink.click();
		
		LOGGER.info("****Step 4 : entering login info****");
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement loginbutton = driver.findElement(By.xpath("//input[@name='signon']"));
		username.clear();
		username.sendKeys("ACID");
		password.clear();
		password.sendKeys("ACID");
		loginbutton.click();
		

		WebElement welcome = driver.findElement(By.xpath("//div[@id='WelcomeContent']"));
		String welcometext = welcome.getText();
		String expectedwelcometext = "Welcome ABC!";
		assertEquals("ERREUR : il y a eu une erreur",expectedwelcometext,welcometext);
		LOGGER.info("****Step 4 Assert : connection succesful****");
		

		LOGGER.info("****Step 5 : buying a shark****");
		WebElement fishbutton = driver.findElement(By.xpath("//area[@alt=\"Fish\"]"));
		fishbutton.click();
		WebElement sharklink = driver.findElement(By.xpath("//a[contains(@href,'FI-SW-02')]"));
		sharklink.click();
		WebElement addtocart = driver.findElement(By.xpath("//a[contains(@href,'addItemToCart')]"));
		addtocart.click();
		WebElement returntomm = driver.findElement(By.xpath("//a[contains(text(),'Main Menu')]"));
		returntomm.click();

		LOGGER.info("****Step 6 : buying a rattleless rattlesnake****");
		WebElement reptilebutton = driver.findElement(By.xpath("//area[@alt='Reptiles']"));
		reptilebutton.click();
		WebElement snakelink = driver.findElement(By.xpath("//a[contains(@href,'RP-SN-01')]"));
		snakelink.click();
		addtocart = driver.findElement(By.xpath("//a[contains(@href,'addItemToCart=&workingItemId=EST-12')]"));
		addtocart.click();
		returntomm = driver.findElement(By.xpath("//a[contains(text(),'Main Menu')]"));
		returntomm.click();

		LOGGER.info("****Step 7 : buying a parrot****");
		WebElement birdsbutton = driver.findElement(By.xpath("//area[@alt='Birds'][1]"));
		birdsbutton.click();
		WebElement parrotlink = driver.findElement(By.xpath("//a[contains(@href,'AV-CB-01')]"));
		parrotlink.click();
		addtocart = driver.findElement(By.xpath("//a[contains(@href,'addItemToCart=&workingItemId=EST-18')]"));
		addtocart.click();
		returntomm = driver.findElement(By.xpath("//a[contains(text(),'Main Menu')]"));
		returntomm.click();
		
		LOGGER.info("****Step 8 : checkouta****");
		WebElement cartbutton = driver.findElement(By.xpath("//img[@name='img_cart']/parent::a"));
		cartbutton.click();
		WebElement proceed = driver.findElement(By.xpath("//a[contains(text(),'Proceed')]"));
		proceed.click();
		WebElement nextpage = driver.findElement(By.xpath("//input[@value='Continue']"));
		nextpage.click();
		WebElement confirm = driver.findElement(By.xpath("//a[contains(text(),'Confirm')]"));
		confirm.click();
		WebElement signout = driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]"));
		signout.click();
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
	
	
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
