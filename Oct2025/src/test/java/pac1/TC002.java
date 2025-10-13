package pac1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");

		List<WebElement> amazonlinks = driver.findElements(By.tagName("a"));

		System.out.println("Totle no of links:" + amazonlinks.size());

		for (WebElement link : amazonlinks) {
			System.out.println("link is:" + link.getText());
		}

		// The following code was outside the main method — moved it inside
		driver.findElement(By.partialLinkText("Account")).click();
		driver.findElement(By.linkText("Register")).click();

		driver.findElement(By.xpath("//input[@type='submit' and @value='Continue']")).click();

		String warning = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();

		System.out.println("Warning message is:" + warning);

		if (warning.equals("You must agree to the Privacy Policy!")) {
			System.out.println("warning is matched");
		} else {
			System.out.println("warning is not matched"); // Removed stray character 'x'
		}

		WebElement subs = driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']"));

		if (subs.isSelected()) {
			System.out.println("yes is selected");
		} else {
			System.out.println("yes is not selected");
		}
	}
}