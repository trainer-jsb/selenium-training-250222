package com.example;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValidateISBNTest {
	ValidateISBN validator;
	
	@BeforeMethod
	public void preReq() {
		validator = new ValidateISBN();
	}

	@DataProvider(name = "valid-isbn")
	public Object[][] validISBN() {
		return new Object[][] {
			{"9390166268"},
			{"1612680194"},
			{"0143442295"}
		};
	}

	@Test(dataProvider = "valid-isbn")
	public void validISBNTest(String isbnNum) {
		boolean result = validator.checkISBN(isbnNum);
		Assert.assertTrue(result);
	}

	@Test
	public void InValidISBNTest() {
		boolean result = validator.checkISBN("9390166269");
		Assert.assertFalse(result);
	}
	
	@DataProvider(name ="isbn-not-equals-to-ten-digits")
	public Object[][] isbnNotEqualToTenDigits(){
		return new Object[][] {
			{"12345678987"},
			{"123456789"},
			{"12345678"}
		};
	}
	
	@Test (dataProvider = "isbn-not-equals-to-ten-digits" )
	public void isbnNumShouldBeTenDigits(String isbnNum) {
		Assert.assertThrows(NumberFormatException.class, ()  -> {validator.checkISBN(isbnNum); });
	}

}
