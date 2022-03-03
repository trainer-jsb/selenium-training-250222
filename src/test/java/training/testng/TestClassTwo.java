package training.testng;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClassTwo {
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("This is beforeClass of TestClassTwo");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is beforeMethod of TestClassTwo");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("This is afterMethod of TestClassTwo");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("This is afterClass of TestClassTwo");
	}
	
	@Test(priority = 1)
	  public void createOperation() {
		  System.out.println("This is testOne of TestClassTwo");
		  Assert.fail("FAIL | Failing the test to show failure and skipping in report");
	  }
	  
	  @Test (priority = 2, dependsOnMethods = "createOperation" )
	  public void updateOperation() {
		  System.out.println("This is testTwo of TestClassTwo");
	  }
	  
	  @Test (priority = 3, dependsOnMethods = "createOperation")
	  public void deleteOperation() {
		  System.out.println("This is testThird of TestClassTwo");
	  }

}
