package com.jeremyjoelprice;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day1 extends Solution {
	
	@Override
	String first(String input) {
		String sum = String.valueOf(Arrays.stream(input.split("\n"))
				.map(this::getFirstAndLastDigitsInString)
				.mapToInt(Integer::parseInt)
				.sum());
		return sum;
	}
	
	@Override
	String second(String input) {
		return null;
	}
	
	private String getFirstAndLastDigitsInString(String input) {
		Pattern pattern = Pattern.compile("[0-9]");
		String first = null;
		String last = null;
		for (int i = 0; i < input.length(); i++) {
			String currentChar = String.valueOf(input.charAt(i));
			Matcher matcher = pattern.matcher(currentChar);
			if (matcher.find()) {
				first = first == null ? currentChar : first;
				last = currentChar;
			}
		}
		return first + last;
	}
}
