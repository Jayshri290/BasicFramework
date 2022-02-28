package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	/*WebElement email= driver.findElement(By.id("usernameInput-input"));
	WebElement password = driver.findElement(By.id("password-input"));
	WebElement signInButton = driver.findElement(By.id("signIn"));
	WebElement globalErr = driver.findElement(By.id("globalError"));
	WebElement generalErr = driver.findElement(By.className("Error__text"));*/
	
	//pagefactory
	@FindBy(id = "usernameInput-input")
    public WebElement email;
	
	@FindBy(name = "password")
    public WebElement password;
	
	@FindBy(id = "signIn")
    public WebElement signInButton;
	
	@FindBy(id = "globalError")
    public WebElement globalError;
	
	@FindBy(className = "Error__text")
    public WebElement generalError;

	
	public void openBrowser() throws IOException {
		FileInputStream f = new FileInputStream("C:\\testing\\prop.properties");
		Properties prop = new Properties();
		prop.load(f);
		System.out.println(prop.getProperty("browser"));		
		String browser = prop.getProperty("browser"); //Chrome, Safari //Code will read this value from data file such as Excel. properties file
	
		if(browser.equals("Firefox")) {
		System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
		driver = new FirefoxDriver();  
		} else if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();  
		}else {
			System.setProperty("webdriver.safari.driver", "C:\\SeleniumJars\\safaridriver.exe");
			driver = new SafariDriver();  
		}
		 PageFactory.initElements(driver, this);
	}

    public void openLoginPage() {
    	driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=e9WfVK8HUWM&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5IjoiZTlXZlZLOEhVV00iLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTYzNjMyMzY4MSwiaWF0IjoxNjM2MzIyNDgxLCJqdGkiOiI0M2E5MTQ1ZC1jOGFkLTQ5YTctOTFjNS0zZTUxZTUwNWNlZDYiLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.EJ1xv5FS-bAY_R3nEIknaORrkGWF9FoadC82xeP0UxPao1MaxSG6b9sIhwERplc1cYvrgIIAshK41HMbxTWyqRU7lmcmFGzM7G9xaVK7RTRk_wWkWapSa0kXEiZdG3Oc_e-_HhxUbLyVeLnv5B_dDaJLgG1-7-ZlPsBEvRfv-81i4sAqPkPt136xzVfA1DPIP8T--JG8Kx5pxIiwtW2TUyZrEoFxH3fVmLm4VWFTuTEpX8WinRLksSsUi_7PXZUrG8I_o7JeM6e4PPBabb3fCfh-saSivYeDDNkZ-mPwu6ZO1MBU5QGKevCM4sCs2Vuwkr7eSGKe6a7c0SW7SZZFiw&preferred_environment=");
  	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
    
    public void closeBrowser() {
    	driver.quit();
	}
    
    
    public void login(String a, String b) throws InterruptedException {
    	email.sendKeys(a);
    	password.sendKeys(b);
    	signInButton.click();
		
		Thread.sleep(4000);
}

    public String readGlobalErr() {
    	String actualErr= globalError.getText();
		System.out.println(actualErr);
		return actualErr;
	
}


    public String readErr() {
    	String actualErr= generalError.getText();
  	    System.out.println(actualErr);
  	    return actualErr;
}

}
