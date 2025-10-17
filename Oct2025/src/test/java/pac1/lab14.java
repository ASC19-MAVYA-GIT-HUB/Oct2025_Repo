import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;

public class lab14 {

    // Utility method to read Excel data
    public static String[][] getExcelData(String filePath, String sheetName) throws Exception {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheet(sheetName);

        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(0).getLastCellNum();

        String[][] data = new String[rows - 1][cols];

        for (int i = 1; i < rows; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < cols; j++) {
                data[i - 1][j] = row.getCell(j).toString();
            }
        }
        wb.close();
        return data;
    }

    public static void main(String[] args) throws Exception {
        // Load test data from Excel
        String[][] userData = getExcelData("UserDetails.xlsx", "Sheet1");

        for (String[] user : userData) {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();

            // Step 1: Open URL
            driver.get("http://demo.opencart.com/");

            // Step 2: Verify URL
            if (driver.getTitle().contains("Your Store")) {
                System.out.println("Application launched successfully");
            }

            // Step 3: Click My Account -> Register
            driver.findElement(By.xpath("//span[text()='My Account']")).click();
            driver.findElement(By.linkText("Register")).click();

            // Step 4: Verify Register Page
            WebElement heading = driver.findElement(By.xpath("//h1[text()='Register Account']"));
            if (heading.isDisplayed()) {
                System.out.println("Register page opened");
            }

            // Step 5: Fill details from Excel
            driver.findElement(By.id("input-firstname")).sendKeys(user[0]);
            driver.findElement(By.id("input-lastname")).sendKeys(user[1]);
            driver.findElement(By.id("input-email")).sendKeys(user[2]);
            driver.findElement(By.id("input-telephone")).sendKeys(user[3]);
            driver.findElement(By.id("input-password")).sendKeys(user[4]);
            driver.findElement(By.id("input-confirm")).sendKeys(user[5]);

            // Step 6: Agree to Privacy Policy
            driver.findElement(By.name("agree")).click();

            // Step 7: Click Continue
            driver.findElement(By.xpath("//input[@value='Continue']")).click();

            // Step 8: Verify Success Message
            WebElement successMsg = driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']"));
            if (successMsg.isDisplayed()) {
                System.out.println("Account created successfully for: " + user[2]);
            }

            driver.quit();
        }
    }
}
