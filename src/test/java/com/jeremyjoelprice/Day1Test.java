package com.jeremyjoelprice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day1Test {
	Solution solution = new Day1();
	
	@Nested
	@DisplayName("Solution 1")
	class Solution1 {
		@Test
		@DisplayName("concatenates first and last digits of a given string")
		void concatenatesFirstAndLastDigitsOfAGivenString() {
			assertAll(
					() -> assertEquals("12", solution.first("1abc2"))
					, () -> assertEquals("34", solution.first("3abc4"))
					, () -> assertEquals("34", solution.first("a3bc4d"))
			);
		}
		
		@Test
		@DisplayName("duplicates only digit in a given string")
		void duplicatesOnlyDigitInAGivenString() {
			assertAll(
					() -> assertEquals("11", solution.first("1abc"))
					, () -> assertEquals("22", solution.first("abd2"))
					, () -> assertEquals("77", solution.first("treb7uchet"))
			);
		}
		
		@Test
		@DisplayName("concatenate and sum first and last digits of a given multi-line string")
		void concatenateAndSumFirstAndLastDigitsOfAGivenMultiLineString() {
			String multiLine = """
					1abc2
					pqr3stu8vwx
					a1b2c3d4e5f
					treb7uchet""";
			
			assertAll(
					() -> assertEquals("142", solution.first(multiLine))
			);
		}
	}
	
	@Nested
	@DisplayName("Solution 2")
	class Solution2 {
	
	}
}
