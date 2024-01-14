package com.jeremyjoelprice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Day3Test {
	@Nested
	@DisplayName("Solution 1")
	class Solution1 {
		@Test
		@DisplayName("returns 0 when given no part numbers")
		void returns0WhenGivenNoPartNumbers() {
			assertAll(
					() -> assertEquals("0", new Day3().first(""))
					, () -> assertEquals("0", new Day3().first("..."))
					, () -> assertEquals("0", new Day3().first(".1."))
					, () -> assertEquals("0", new Day3().first("1"))
					, () -> assertEquals("0", new Day3().first("1.*"))
			);
		}
		
		@Test
		@DisplayName("returns number when given a horizontal part number")
		void returnsNumberWhenGivenAHorizontalPartNumber() {
			assertAll(
					() -> assertEquals("1", new Day3().first(".*1."))
					, () -> assertEquals("1", new Day3().first(".1*."))
					, () -> assertEquals("1", new Day3().first("1*"))
			);
		}
		
		@Test
		@DisplayName("returns sum of all part numbers in a give single-line string")
		void returnsSumOfAllPartNumbersInAGiveSingleLineString() {
			assertAll(
					() -> assertEquals("3", new Day3().first(".*1.2*"))
					, () -> assertEquals("7", new Day3().first("*3**4*"))
					, () -> assertEquals("2", new Day3().first("*1**1*"))
			);
		}
		
		@Test
		@DisplayName("recognises all symbol characters")
		void recognisesAllSymbolCharacters() {
			assertEquals("10", new Day3().first("&1.*1.#1.%1.$1.-1.@1.=1.+1./1."));
		}
		
		@Test
		@DisplayName("returns number when given a vertical part number")
		void returnsNumberWhenGivenAVerticalPartNumber() {
			assertAll(
					() -> assertEquals("1", new Day3().first("""
							.*.
							.1."""))
					, () -> assertEquals("1", new Day3().first("""
							*..
							.1."""))
					, () -> assertEquals("1", new Day3().first("""
							..*
							.1."""))
					, () -> assertEquals("1", new Day3().first("""
							.1.
							*.."""))
			);
		}
	}
	
	@Nested
	@DisplayName("Solution 2")
	class Solution2 {
		
		@Test
		@DisplayName("returns 0 given a non-gear *")
		void returns0GivenANonGearSymbol() {
			assertAll(
					() -> assertEquals("0", new Day3().second("*"))
					, () -> assertEquals("0", new Day3().second("10*"))
					, () -> assertEquals("0", new Day3().second("10*.10"))
					, () -> assertEquals("0", new Day3().second("10.*10"))
					, () -> assertEquals("0", new Day3().second("10.*.10"))
			);
		}
		
		@Test
		@DisplayName("returns the gear ratio given a single gear")
		void returnsTheGearRatioGivenASingleGear() {
			assertAll(
					() -> assertEquals("200", new Day3().second("10*20"))
					, () -> assertEquals("400", new Day3().second("20*20"))
			);
		}
		
		@Test
		@DisplayName("returns the gear ratio with vertical neighbouring numbers")
		void returnsTheGearRatioWithVerticalNeighbouringNumbers() {
			assertAll(
					() -> assertEquals("4", new Day3().second("""
							.2.
							.*.
							.2."""))
					, () -> assertEquals("4", new Day3().second("""
							2..
							.*.
							.2."""))
					, () -> assertEquals("4", new Day3().second("""
							..2
							.*.
							2.."""))
					, () -> assertEquals("246", new Day3().second("""
							123
							.*.
							2.."""))
					, () -> assertEquals("46", new Day3().second("""
							.23
							.*.
							2.."""))
			);
		}
		
		@Test
		@DisplayName("returns 0 when given a * with more than 2 neighbouring numbers")
		void returnsTheGearRatioWithMoreThan2NeighbouringNumbers() {
			assertAll(
					() -> assertEquals("0", new Day3().second("""
							.....755.
							....*....
							.664.598."""))
			);
		}
		
		
		@Test
		@DisplayName("returns the sum of mutliple gear ratios")
		void returnsTheSumOfAllGearRatios() {
			assertAll(
					() -> assertEquals("467835", new Day3().second("""
							467..114..
							...*......
							..35..633.
							......#...
							617*......
							.....+.58.
							..592.....
							......755.
							...$.*....
							.664.598.."""))
			);
			
		}
		
	}
}
