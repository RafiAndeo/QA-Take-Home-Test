package login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.edge.EdgeDriver; // use this if you want to use edge driver
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class login_success {

	public static void main(String[] args) {
		
	   	// Set chromedriver path (change the path based on your own directory)
        System.setProperty("webdriver.chrome.driver", "D:/eclipse/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        
        // Set msedgedriver path (optional, if you want to use edge instead of chrome)
		// System.setProperty("webdriver.edge.driver","D:/eclipse/edgedriver_win64/msedgedriver.exe"); 
		// WebDriver driver = new EdgeDriver();

        
        // Set driver variable
        WebDriver driver = new ChromeDriver();
		
		try {

	        // Set web site URL
	        driver.get("https://www.paper.id/webappv1/login");
	        
	        // Set the browser to open on maximize view
	        driver.manage().window().maximize();
	        
	        // Set explicit wait for 10 seconds
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        
	        // Set email field as variable
	        WebElement email_field = driver.findElement(By.id("login-identifier"));
	        
	        // Fill email field with correct email
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-identifier")));
	        
	        email_field.sendKeys("kandidat@paper.id");
	        
	        // Set button Selanjutnya as variable
	        WebElement next_button = driver.findElement(By.cssSelector("[data-cy='submit']"));
	        
	        // Click button Selanjutnya
	        next_button.click();
	        
	        // Set password field as variable
	        WebElement password_field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-cy='password']")));
	        
	        // Fill password field after password pop up shows with correct password
	        password_field.sendKeys("paper.id");
	        
	        // Set button Masuk as variable
	        WebElement login_button = driver.findElement(By.cssSelector("[class='au-btn au-btn--default au-btn--primary']"));
	        
	        // Click button Masuk
	        login_button.click();
	        
	        // Set Thread Sleep for 5000 miliseconds to show dashboard after login
	        try { Thread.sleep(5000); } catch (InterruptedException e) {}
	        
		} finally {
			
            // Close browser
            driver.quit();
            
		}
	}
}
