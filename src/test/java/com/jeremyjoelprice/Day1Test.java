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
		@Test
		@DisplayName("concatenates first and last worded digits in a given string")
		void concatenatesFirstAndLastWordedDigitsInAGivenString() {
			assertAll(
					() -> assertEquals("12", solution.second("onetwo"))
					, () -> assertEquals("32", solution.second("threetwo"))
					, () -> assertEquals("32", solution.second("athreetwo"))
					, () -> assertEquals("32", solution.second("threetwoa"))
					, () -> assertEquals("32", solution.second("threeatwo"))
					, () -> assertEquals("32", solution.second("threeonetwo"))
					, () -> assertEquals("83", solution.second("eightwothree"))
					, () -> assertEquals("83", solution.second("eightwothree"))
					, () -> assertEquals("29", solution.second("two1nine"))
			);
		}
		
		@Test
		@DisplayName("concatenates first and last numerical digits in a given string")
		void concatenatesFirstAndLastNumericalDigitsInAGivenString() {
			assertAll(
					() -> assertEquals("12", solution.second("1abc2"))
					, () -> assertEquals("34", solution.first("3abc4"))
					, () -> assertEquals("34", solution.first("a3bc4d"))
			);
		}
		
		@Test
		@DisplayName("concatenates a mixture of worded and numerical digits in a given string")
		void concanatesAMixtureOfWordedAndNumericalDigitsInAGivenString() {
			assertAll(
					() -> assertEquals("72", solution.second("75ntphbdbpgktwo"))
			);
		}
		
		@Test
		@DisplayName("counts overlapping worded digits")
		void ignoresOverlappingWordedDigits() {
			assertAll(
					() -> assertEquals("18", solution.second("zoneight"))
			);
		}
		
		@Test
		@DisplayName("concatenate and sum first and last digits of a given multi-line string")
		void concatenateAndSumFirstAndLastDigitsOfAGivenMultiLineString() {
			String multiLine = """
					two1nine
					eightwothree
					abcone2threexyz
					xtwone3four
					4nineeightseven2
					zoneight234
					7pqrstsixteen""";
			
			assertAll(
					() -> assertEquals("281", solution.second(multiLine))
			);
		}
	}
}
