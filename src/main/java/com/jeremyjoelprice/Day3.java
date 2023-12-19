package com.jeremyjoelprice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 extends Solution {
	
	@Override
	String first(String input) {
		String[] rows = input.split("\n");
		int sum = 0;
		for (int i = 0; i < rows.length; i++) {
			Matcher numberMatcher = Pattern.compile("(\\d+)").matcher(rows[i]);
			while (numberMatcher.find()) {
				if (isPartNumber(rows, numberMatcher.start(), numberMatcher.end(), i)) {
					sum += Integer.valueOf(numberMatcher.group());
				}
			}
		}
		return String.valueOf(sum);
	}
	
	@Override
	String second(String input) {
		return null;
	}
	
	private boolean isPartNumber(String[] rows, int start, int end, int rowIndex) {
		
		int row = Math.max(rowIndex - 1, 0);
		int endRow = Math.min(rowIndex + 2, rows.length);
		for (; row < endRow; row++) {
			
			int column = Math.max(start - 1, 0);
			int endChar = Math.min(end + 1, rows[rowIndex].length());
			for (; column < endChar; column++) {
				
				if (isSymbol(
						String.valueOf(rows[row].charAt(column))
				)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean isSymbol(String str) {
		Matcher symbolMatcher = Pattern.compile("[^\\d.]").matcher(str);
		boolean result = symbolMatcher.find();
		return result;
	}
}
