import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignoutPage {
WebDriver driver;
	
	//Constructor that will be automatically called as soon as the object of the class is created
	public SignoutPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//Locators for the page title and the logout button
	By heading = By.id("//*[@id=\"header\"]/div[2]");
	
	By signoutBtn = By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(2) > a");
	
	//Method to capture the page heading
	public String getHeading() {
		String head = driver.findElement(heading).getText();
		return head;
	}
	
	//Method to click on Logout button
	public void clickLogout() {
		driver.findElement(signoutBtn).click();
	}

}
