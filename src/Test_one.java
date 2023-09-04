import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_one {
	WebDriver driver = new ChromeDriver();
	
@BeforeTest
public void myBeforeTest() {
	driver.get("https://www.saucedemo.com/");
}
@Test
public void myTest() {
	//Login
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	driver.findElement(By.name("password")).sendKeys("secret_sauce");
	driver.findElement(By.cssSelector("[data-test='login-button']")).click();
	
	//Add all items to cart
	List<WebElement> AddToCartButtons = driver.findElements(By.className("btn_primary"));
	for (int i = 0 ; i < AddToCartButtons.size(); i++) {
		AddToCartButtons.get(i).click();
	}
	
	//Remove items from cart
	List<WebElement> RemoveButtons = driver.findElements(By.className("btn_secondary"));
	for (int i = 0 ; i < RemoveButtons.size(); i++) {
		RemoveButtons.get(i).click();
	}
	
}

@AfterTest
public void myAfterTest() {
	
}
}
