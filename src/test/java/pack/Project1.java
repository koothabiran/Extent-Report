package pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pack.ExtentManager;

public class Project1 {
	
	
	public ExtentReports eReport = ExtentManager.getInstance();
	public ExtentTest eTest = null;
	
	
	
	public WebDriver driver=null;
	String URL = "http://210.18.176.95:8081/bilim/v1.0/editors/BlmCourseEditor/build/";
	
	
	@Test(priority=1)
	public void LaunchBrowser() throws InterruptedException {
		
		  eTest = eReport.startTest("LaunchBrowser");
		
		System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		eTest.log(LogStatus.INFO, "Browser got maximized");
		
		driver.get(URL);
		
		eTest.log(LogStatus.INFO, "URL is opened in the Chrome browser");
	}
	
	
	
	@Test(priority=2)
	public void structure() throws InterruptedException {
		
		driver.findElement(By.xpath("(//span[@class=\"MuiIconButton-label\"])[1]")).click();
		
		Thread.sleep(2000);
		
		eTest.log(LogStatus.INFO, "Clicked on dropdown button");
		
		
		driver.findElement(By.xpath("(//*[@id=\"structure-ctx\"]/div[3]/ul/div[1]")).click();;
		Thread.sleep(2000);
		
		eTest.log(LogStatus.INFO, "Clicked on Landing page");

		driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/aside/div/div/div[2]/div/div/div/div/div/div[2]/div[1]")).click();
		Thread.sleep(2000);

		eTest.log(LogStatus.INFO, "Clicked on Structure page");
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/aside/div/div/div[2]/div/div/div/div/div/div[3]/div[1]/div/div[2]")).click();
		Thread.sleep(2000);
		
		Actions actions = new Actions(driver);
		
		WebElement target1 = driver.findElement(By.cssSelector("div[class^='MuiButtonBase-root MuiIconButton-root jss115']"));
		
		actions.moveToElement(target1).perform();
		
		target1.click();

		Thread.sleep(4000);
	}
		
		@Test(priority=3)
		public void structure1() throws InterruptedException {
			
			driver.findElement(By.xpath("//*[@id=\"structure-ctx\"]/div[3]/ul/div[1]")).click();
			Thread.sleep(2000);
		Actions actions = new Actions(driver);
		
		WebElement target2 = driver.findElement(By.xpath("(//span[@class=\"MuiIconButton-label\"])[position()=5]"));
		
		actions.moveToElement(target2).perform();
		
		target2.click();

		
		
		
		
		Thread.sleep(4000);
		
		



		
	}
	
	
@AfterClass
	public void testClosure() {
		
		if(eReport!=null) {
			
			eReport.endTest(eTest);
			eReport.flush();
		}
		
		if(driver!=null) {
			
			driver.quit();
			
	}
	
	}


}
