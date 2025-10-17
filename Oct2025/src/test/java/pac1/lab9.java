package pac1;
 
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
 
import java.time.Duration;
 
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class lab9 {
 
    private WebDriver driver;
    private WebDriverWait wait;
 
    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println("✅ Browser launched and navigated to TutorialsNinja.");
    }
 
    @Test
    @Order(1)
    public void testLab3Flow() {
        System.out.println("---- Starting Lab 3 Flow ----");
        driver.findElement(By.linkText("Desktops")).click();
        System.out.println("➡ Clicked on 'Desktops'.");
 
        WebElement macLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Mac (1)")));
        macLink.click();
        System.out.println("➡ Clicked on 'Mac'.");
 
        Select sortBy = new Select(driver.findElement(By.id("input-sort")));
        sortBy.selectByVisibleText("Name (A - Z)");
        System.out.println("➡ Selected 'Name (A - Z)'.");
 
        driver.findElement(By.xpath("//button[@onclick=\"cart.add('41', '1');\"]")).click();
        System.out.println("➡ Clicked 'Add to Cart'.");
 
        WebElement successAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-success")));
        Assertions.assertTrue(successAlert.getText().contains("Success: You have added iMac to your shopping cart!"));
        System.out.println("✅ Verified success message for iMac added to cart.");
    }
 
    @Test
    @Order(2)
    public void testLab4Flow() {
        System.out.println("---- Starting Lab 4 Flow ----");
 
        // Verify title
        String expectedTitle = "Your Store";
        String actualTitle = driver.getTitle();
        Assertions.assertEquals(expectedTitle, actualTitle);
        System.out.println("✅ Verified page title: " + expectedTitle);
 
        // Click on Desktops > Mac
        driver.findElement(By.linkText("Desktops")).click();
        System.out.println("➡ Clicked on 'Desktops'.");
        WebElement macLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Mac (1)")));
        macLink.click();
        System.out.println("➡ Clicked on 'Mac'.");
 
        // Verify heading
        String macHeading = driver.findElement(By.tagName("h2")).getText();
        Assertions.assertEquals("Mac", macHeading);
        System.out.println("✅ Verified heading 'Mac'.");
 
        // Add to Cart
        Select sortBy = new Select(driver.findElement(By.id("input-sort")));
        sortBy.selectByVisibleText("Name (A - Z)");
        System.out.println("➡ Selected 'Name (A - Z)'.");
        driver.findElement(By.xpath("//button[@onclick=\"cart.add('41', '1');\"]")).click();
        System.out.println("➡ Clicked 'Add to Cart'.");
 
        WebElement successAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-success")));
        Assertions.assertTrue(successAlert.getText().contains("Success: You have added iMac to your shopping cart!"));
        System.out.println("✅ Verified success message for iMac added to cart.");
 
        // Perform search
        driver.findElement(By.name("search")).sendKeys("Mobile");
        driver.findElement(By.cssSelector("#search button")).click();
        System.out.println("➡ Searched for 'Mobile'.");
 
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(), 'Search - Mobile')]")));
        WebElement searchCriteriaInput = driver.findElement(By.id("input-search"));
        searchCriteriaInput.clear();
        searchCriteriaInput.sendKeys("Monitors");
        System.out.println("➡ Entered 'Monitors' in search field.");
 
        driver.findElement(By.id("description")).click();
        System.out.println("➡ Selected 'Search in product descriptions'.");
 
        driver.findElement(By.id("button-search")).click();
        System.out.println("➡ Clicked 'Search'.");
 
        WebElement newSearchHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(), 'Search - Monitors')]")));
        Assertions.assertTrue(newSearchHeading.isDisplayed());
        System.out.println("✅ Verified 'Search - Monitors' results displayed.");
    }
 
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("🛑 Browser closed successfully.");
        }
    }
}