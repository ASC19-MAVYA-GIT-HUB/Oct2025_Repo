package pac1;
 
import java.util.List;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class Lab5 {
 
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?");
		driver.manage().window().maximize();
		String title=driver.getTitle();
		if(title.equals("Your Store"))
		{
			System.out.println("Title is matched");
			
		}
		else
		{
			System.out.println("Title not matched");
		}
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.xpath("//input[@type='submit' and @value='Continue']")).click();
		String warning=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		System.out.println("Warning message is:"+warning);
		if(warning.equals("You must agree to the Privacy Policy!"))
		{
			System.out.println("warning is matched");
		}
		
		else
		{
			System.out.println("warning is not matched");
		}
		WebElement subs = driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']"));
		
		if (subs.isSelected()) {
			System.out.println("yes is selected");
		} else {
			System.out.println("yes is not selected");
		
		
		String longFirstName = "Mavya";
		driver.findElement(By.name("firstname")).sendKeys(longFirstName);
		driver.findElement(By.xpath("//input[@type='submit' and @value='Continue']")).click();
 
		List<WebElement> firstNameErrors = driver.findElements(By.xpath("//div[contains(@class,'text-danger') and contains(text(),'First Name')]"));
		if (!firstNameErrors.isEmpty()) {
		    System.out.println("First Name error: " + firstNameErrors.get(0).getText());
		} else {
		    System.out.println("First Name accepted 33 characters.");
		}
 
		String longLastName = "S";
		driver.findElement(By.name("lastname")).sendKeys(longLastName);
		driver.findElement(By.xpath("//input[@type='submit' and @value='Continue']")).click();
 
		List<WebElement> lastNameErrors = driver.findElements(By.xpath("//div[contains(@class,'text-danger') and contains(text(),'Last Name')]"));
		if (!lastNameErrors.isEmpty()) {
		    System.out.println("Last Name error: " + lastNameErrors.get(0).getText());
		} else {
		    System.out.println("Last Name accepted 33 characters.");
		}
		
		driver.findElement(By.id("input-email")).sendKeys("mavya@gmail.com");
 
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
 
		driver.findElement(By.xpath("//input[@type='submit' and @value='Continue']")).click();
		
		driver.findElement(By.id("input-password")).sendKeys("sample@123");
		
		driver.findElement(By.id("input-confirm")).sendKeys("sample@123");
	
		driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']")).click();
 
		driver.findElement(By.name("agree")).click();
 
		driver.findElement(By.xpath("//input[@type='submit' and @value='Continue']")).click();
 
		List<WebElement> successMessages = driver.findElements(By.xpath("//h1[text()='Your Account Has Been Created!']"));
		if (successMessages.size() > 0) {
		    System.out.println("Registration successful: " + successMessages.get(0).getText());
		} else {
		    System.out.println("Registration failed or success message not found.");
		}
 
		List<WebElement> continueButtons = driver.findElements(By.xpath("//a[text()='Continue']"));
		if (continueButtons.size() > 0) {
		    continueButtons.get(0).click();
		    System.out.println("Navigated to My Account page.");
		} else {
		    System.out.println("Could not click final Continue button.");
		}
 
		List<WebElement> orderHistoryLinks = driver.findElements(By.linkText("View your order history"));
		if (orderHistoryLinks.size() > 0) {
		    orderHistoryLinks.get(0).click();
		    System.out.println("Opened Order History page.");
		} else {
		    System.out.println("Could not find 'View your order history' link.");
		}
 
		
		
		
	}
 
}
}
 