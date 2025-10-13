package pac1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class tc001 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		System.out.println("The title is:"+driver.getTitle());
		System.out.println("The title is:" +driver.getCurrentUrl());
		
		System.out.println("The title is:" +driver.getPageSource());
		//driver.findElement(By.id("APjFqb")).sendKeys("Software Testing Tools");
		WebElement search=driver.findElement(By.id("APjFqb"));
		search.sendKeys("Software Testing Tools");
		search.submit();
		//driver.findElement(By.name("btnk")).click();
		
		driver.navigate().to("http://www.amazon.in/");
		System.out.println("The title is:"+driver.getTitle());
		System.out.println("The title is:" +driver.getCurrentUrl());
		
		driver.navigate().back();
		System.out.println("The title is:"+driver.getTitle());
		System.out.println("The title is:" +driver.getCurrentUrl());
		
		driver.navigate().forward();
		System.out.println("The title is:"+driver.getTitle());
		System.out.println("The title is:" +driver.getCurrentUrl());
		
		//driver.quit();
	}
}
