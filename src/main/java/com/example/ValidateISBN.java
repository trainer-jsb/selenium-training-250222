package com.example;

public class ValidateISBN {

	public boolean checkISBN_old(String string) {
		if (string.equalsIgnoreCase("9390166268") || string.equalsIgnoreCase("1612680194"))
			return true;
		else
			return false;
	}

	public boolean checkISBN(String isbnNum) {
		int total = 0;
		if(isbnNum.length() != 10) throw new NumberFormatException("ISBN Number should be 10 digits");
		
		for (int i = 0; i < 10; i++) {
			total += isbnNum.charAt(i) * (10 - i);
		}
		if (total % 11 == 0)
			return true;
		else
			return false;
	}
}
