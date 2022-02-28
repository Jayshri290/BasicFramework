package tests;
import org.testng.annotations.Test;
import data.DataFile;
import pages.LoginPage;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	
	
	
	LoginPage lp= new LoginPage();
	DataFile df= new DataFile();
	
	 
  
  @BeforeMethod
  public void beforeMethod() throws InterruptedException, IOException {
	 
	  lp.openBrowser();
	  lp.openLoginPage();
	  
 }

  @AfterMethod
  public void afterMethod() {
	  lp.closeBrowser();
	  
  }
 
  @Test (priority= 1)
  public void loginwithWrongEmailAndPasswordTest() throws InterruptedException {
	  
	  lp.login(df.wrongEmail, df.wrongpassword);
	  String expectedErr= df.globalErr;
	  String actualErr= lp.readGlobalErr();
	  Assert.assertEquals(actualErr, expectedErr);
  }
		
  @Test (priority= 2)
  public void loginWithEmptyEmailTest() throws InterruptedException {
	  
	  lp.login("",df.wrongpassword);
	  String expectedErr= df.emptyEmailErr;
	  String actualErr= lp.readErr();
	  Assert.assertEquals(actualErr, expectedErr);
	   
  }
  
  @Test (priority= 3)
  public void loginWithEmptyPasswordTest() throws InterruptedException {
	 
	  lp.login(df.wrongEmail,"");
	  String expectedErr=df.emptypasswordErr;
	  String actualErr= lp.readErr();
	  Assert.assertEquals(actualErr, expectedErr);
	  
	  
	  
  }
  
  
  @Test (priority= 4)
  public void loginEmailWithSpecialCharTest() throws InterruptedException {
	  
	  lp.login(df.emailwithspecialchar,df.wrongpassword);
	  String expectedErr= df.emailwithspecialcharErr;
	  String actualErr= lp.readErr();
	  Assert.assertEquals(actualErr, expectedErr);
	  
	
	  
  }
	
}
  

