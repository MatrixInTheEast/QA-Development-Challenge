package TestAuto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class OpenWebsite2 {
	
	public  WebDriver driver;
	public  String EnteredAmount = "1";
	public  String id = "Bank-Admin";
	public  String pw = "Demo-Access1";
	
	
	
	@BeforeTest
	public  void SetUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Duy Tu\\Documents\\Chromedriver\\ChromeDriver 106.0.5249.61\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://demo.ebanq.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}
	
	@Test
	public  void Login() throws Exception {
   //WebElement target
        WebElement username = driver.findElement(By.cssSelector("input[placeholder='Enter username or email address']"));
        username.sendKeys(id);
        Thread.sleep(1000);
        
        WebElement password = driver.findElement(By.cssSelector("input[placeholder='Enter password']"));
        password.sendKeys(pw);
        Thread.sleep(1000);
        
        WebElement button_SignIn = driver.findElement(By.cssSelector("button[type='submit']"));
        button_SignIn.click();
        Thread.sleep(5000);
	}
	
	@Test
	public  void TransferFund() throws Exception {
	
        WebElement button_Transfer = driver.findElement(By.xpath("//label[normalize-space()='Transfers']"));
        button_Transfer.click();
        Thread.sleep(2000);
        
        WebElement button_TransferBetweenAccounts = driver.findElement(By.xpath("(//div[@class='section main_color'])[1]"));
        button_TransferBetweenAccounts.click();
        Thread.sleep(2000);
        
        WebElement dropdown_SelectUser = driver.findElement(By.xpath("(//input[@role='combobox'])[1]"));
        dropdown_SelectUser.click();
        Thread.sleep(2000);
        
        WebElement SelectUser = driver.findElement(By.xpath("(//span[normalize-space()='Mary Johnson (mjohnson)'])[1]"));
        SelectUser.click();
        Thread.sleep(2000);
        
        WebElement dropdown_SelectDebit = driver.findElement(By.xpath("(//span[@class='ng-arrow-wrapper'])[2]"));
        dropdown_SelectDebit.click();
        Thread.sleep(2000);
        
        WebElement SelectDebit = driver.findElement(By.xpath("(//span[normalize-space()='EBQ12123423456'])[1]"));
        SelectDebit.click();
        Thread.sleep(2000);
        
        WebElement dropdown_SelectCredit = driver.findElement(By.xpath("(//span[@class='ng-arrow-wrapper'])[3]"));
        dropdown_SelectCredit.click();
        Thread.sleep(2000);
        
        WebElement SelectCredit = driver.findElement(By.xpath("(//span[normalize-space()='EBQ11123412345'])[1]"));
        SelectCredit.click();
        Thread.sleep(2000);
        
        
        WebElement EnteredTransferAmt = driver.findElement(By.cssSelector("input[placeholder='0,000.00']"));
        EnteredTransferAmt.sendKeys(EnteredAmount);
        Thread.sleep(1000);
        
        
        WebElement Description = driver.findElement(By.xpath("(//textarea[@id='description'])[1]"));
        Description.sendKeys("Admin user triggered auto transfer with amount of $"+ EnteredAmount);
        Thread.sleep(2000);
        
        
        WebElement button_Continue = driver.findElement(By.xpath("(//button[normalize-space()='Continue'])[1]"));
        button_Continue.click();
        Thread.sleep(2000);
        
        
        WebElement button_Confirm = driver.findElement(By.cssSelector("button[type='submit']"));
        button_Confirm.click();
        Thread.sleep(2000);
        
        
    
      
	}
	
	@Test
	public void TransferResult()throws Exception {
    	
		  WebElement expectedResult = driver.findElement(By.cssSelector(".success-popup"));
		  Assert.assertTrue(expectedResult.isDisplayed());
		  
		
	
	     Thread.sleep(5000);
	     
      	
}
	
	
	@AfterTest
	public void Close()throws Exception {
		
		Thread.sleep(5000);
		driver.close();
	}
        
 
	
	

}
