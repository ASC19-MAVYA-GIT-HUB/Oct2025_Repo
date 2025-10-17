package pac1;
 
import org.testng.annotations.Test;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
 
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
 
import java.io.File;
import java.io.IOException;
import java.time.Duration;
 
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite; 
 
public class TC008_TestNG2_Excel {
	WebDriver driver;
	@Test
	public void test2()
	{
		System.out.println("this is test2");
	}
	public void test3()
	{
		System.out.println("This is test3");
	}

  @Test(dataProvider = "logindata")
  public void f(String uname, String pword) {
	  System.out.println("This is the Test");
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  login_pageobjects obj=new login_pageobjects(driver);
	  obj.enterusername(uname);
	  obj.enterpassword(pword);
	  obj.clickonsubmit();
	 if( obj.dashboarddisplayed())
	 {
			assertTrue(true,"dashboard is dispalyed");
			}
			else
			{
				assertFalse(true,"dashboard is not dispalyed");
			}

	}

  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("This is before method");
	  WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
  }

 
  @AfterMethod
  public void afterMethod() {
	  System.out.println("This is after method");
	  driver.quit();
  }

 
 
  @DataProvider
  public Object[][] logindata() throws InvalidFormatException, IOException {
	  String[][] data=new String[3][2];
	  String projectpath=System.getProperty("user.dir");
	  File file1=new File(projectpath+"\\inputdata.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file1);
		XSSFSheet worksheet=workbook.getSheetAt(0);
		int rowcount=worksheet.getPhysicalNumberOfRows();
		System.out.println("rows:"+rowcount);

		for(int i=0;i<rowcount;i++)
		{
			data[i][0]=worksheet.getRow(i).getCell(0).getStringCellValue();
			data[i][1]=worksheet.getRow(i).getCell(1).getStringCellValue();
		}

    return data;
    }


 
}