package com.jeremyjoelprice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day1 extends Solution {
	
	@Override
	String first(String input) {
		return solve(input, "^[0-9]");
	}
	
	Map<String, Integer> numberWordMap = new HashMap<>();
	
	@Override
	String second(String input) {
		numberWordMap.put("zero", 0);
		numberWordMap.put("one", 1);
		numberWordMap.put("two", 2);
		numberWordMap.put("three", 3);
		numberWordMap.put("four", 4);
		numberWordMap.put("five", 5);
		numberWordMap.put("six", 6);
		numberWordMap.put("seven", 7);
		numberWordMap.put("eight", 8);
		numberWordMap.put("nine", 9);
		
		return solve(input, "^(zero|one|two|three|four|five|six|seven|eight|nine|[0-9])");
	}
	
	private String solve(String input, String regex) {
		return String.valueOf(Arrays.stream(input.split("\n"))
				.map((row) -> getFirstAndLastDigitsAndWordedDigitsInString(row, regex))
				.mapToInt(Integer::parseInt)
				.sum());
	}
	
	private String getFirstAndLastDigitsAndWordedDigitsInString(String input, String regex) {
		Pattern pattern = Pattern.compile(regex);
		String first = null;
		String last = null;
		
		while (input.length() > 0) {
			Matcher matcher = pattern.matcher(input);
			if (matcher.find()) {
				String digit = input.substring(0, matcher.end());
				first = first == null ? digit : first;
				last = digit;
				input = input.substring(1);
			} else {
				input = input.substring(1);
			}
		}
		
		String a = numberWordMap.get(first) != null ? String.valueOf(numberWordMap.get(first)) : first;
		String b = numberWordMap.get(last) != null ? String.valueOf(numberWordMap.get(last)) : last;
		
		return a + b;
	}
}
