package com.jeremyjoelprice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Day3Test {
	Solution solution = new Day3();
	
	@Nested
	@DisplayName("Solution 1")
	class Solution1 {
		@Test
		@DisplayName("returns 0 when given no part numbers")
		void returns0WhenGivenNoPartNumbers() {
			assertAll(
					() -> assertEquals("0", solution.first(""))
					, () -> assertEquals("0", solution.first("..."))
					, () -> assertEquals("0", solution.first(".1."))
					, () -> assertEquals("0", solution.first("1"))
					, () -> assertEquals("0", solution.first("1.*"))
			);
		}
		
		@Test
		@DisplayName("returns number when given a horizontal part number")
		void returnsNumberWhenGivenAHorizontalPartNumber() {
			assertAll(
					() -> assertEquals("1", solution.first(".*1."))
					, () -> assertEquals("1", solution.first(".1*."))
					, () -> assertEquals("1", solution.first("1*"))
			);
		}
		
		@Test
		@DisplayName("returns sum of all part numbers in a give single-line string")
		void returnsSumOfAllPartNumbersInAGiveSingleLineString() {
			assertAll(
					() -> assertEquals("3", solution.first(".*1.2*"))
					, () -> assertEquals("7", solution.first("*3**4*"))
					, () -> assertEquals("2", solution.first("*1**1*"))
			);
		}
		
		@Test
		@DisplayName("recognises all symbol characters")
		void recognisesAllSymbolCharacters() {
			assertEquals("10", solution.first("&1.*1.#1.%1.$1.-1.@1.=1.+1./1."));
		}
		
		@Test
		@DisplayName("returns number when given a vertical part number")
		void returnsNumberWhenGivenAVerticalPartNumber() {
			assertAll(
					() -> assertEquals("1", solution.first("""
							.*.
							.1."""))
					, () -> assertEquals("1", solution.first("""
							*..
							.1."""))
					, () -> assertEquals("1", solution.first("""
							.1.
							*.."""))
			);
		}
	}
}
