import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import graphql.Assert;


public class AutomationTask {
	
	Actions action;
	
	public AutomationTask(WebDriver driver) {
		action = new Actions(driver);
	}
	
	public void performMouseHover(WebElement element) {
		action.moveToElement(element).build().perform();
	}
	
	public void cliclUsingJavascriptExecutor(WebElement element, WebDriver driver) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\BrowserDriver\\chromedriver.exe" );
		ChromeDriver driver = new ChromeDriver();
		AutomationTask objdemo = new AutomationTask(driver);
		driver.get("http://automationpractice.com/index.php");
		
		driver.manage().window().maximize();
		
		driver.get("http://automationpractice.com/index.php?controller=my-account");
		driver.findElement(By.id("email")).sendKeys("afrin.nubcse@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("abcde12345");
		driver.findElement(By.id("SubmitLogin")).click();
		
		//wait = new WebDriverWait(driver,2);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("DRESSES")));
		
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.linkText("DRESSES"));

		action.moveToElement(element).build().perform();
		
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("CASUAL DRESSES")));
		
		WebElement element2 = driver.findElement(By.linkText("CASUAL DRESSES"));
		action.moveToElement(element2);
		action.click().build().perform();
		
		Assert.assertTrue(driver.getTitle().equals("Casual Dresses - My Store"));
		
	    WebElement searchImage = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img"));
	    objdemo.performMouseHover(searchImage);
	    
	    WebElement btnAddToCart = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span"));
	    objdemo.cliclUsingJavascriptExecutor(btnAddToCart, driver);
	    
	    Thread.sleep(1000);
	    
	    WebElement btnContinue = driver.findElement(By.cssSelector("div#layer_cart a > span"));
	    objdemo.cliclUsingJavascriptExecutor(btnContinue, driver);
	    
	    //Assert.assertTrue(driver.getTitle().equals("Order - My Store"));
	    
	    driver.get("http://automationpractice.com/index.php?id_category=9&controller=category");
	    //driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[2]")).click();
	    
	    Thread.sleep(2000);
	    
	    //shirt
	    WebElement element3 = driver.findElement(By.linkText("T-SHIRTS"));
		action.moveToElement(element3);
		action.click().build().perform();
		
		Assert.assertTrue(driver.getTitle().equals("T-shirts - My Store"));
		
		WebElement showImage = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img"));
	    objdemo.performMouseHover(showImage);
	    
	    WebElement btnMore = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[2]/span"));
	    objdemo.cliclUsingJavascriptExecutor(btnMore, driver);
	    
	    WebElement selectColor = driver.findElement(By.xpath("//*[@id=\"color_14\"]"));
		objdemo.cliclUsingJavascriptExecutor(selectColor, driver);
		
		WebElement btnAddToCart2 = driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span"));
	    objdemo.cliclUsingJavascriptExecutor(btnAddToCart2, driver);
	    
	    WebElement btnCheck = driver.findElement(By.cssSelector("div#layer_cart a > span"));
	    objdemo.cliclUsingJavascriptExecutor(btnCheck, driver);
	    
	    WebElement summary = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span"));
	    objdemo.cliclUsingJavascriptExecutor(summary, driver);
	    Thread.sleep(1000);
	    
	    WebElement address = driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button/span"));
	    objdemo.cliclUsingJavascriptExecutor(address, driver);
	    Thread.sleep(1000);
	    
	    //driver.findElement(By.id("order")).click();
	    //Thread.sleep(1000);
	    
	    driver.findElement(By.id("cgv")).click();
	    WebElement shipping = driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span"));
	    objdemo.cliclUsingJavascriptExecutor(shipping, driver);
	    Thread.sleep(1000);
	    
	    driver.get("http://automationpractice.com/index.php?fc=module&module=cheque&controller=payment");
	    Thread.sleep(1000);
	    
	    WebElement confirm = driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span"));
	    objdemo.cliclUsingJavascriptExecutor(confirm, driver);
	    
	    SignoutPage signout = new SignoutPage(driver);
	    signout.clickLogout();
	    
	    Thread.sleep(1500);

        //Close browser instance
        driver.quit();

	}

}
