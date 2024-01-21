package com.jeremyjoelprice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day5Test {
	
	@Nested
	@DisplayName("Solution 1")
	class Solution1 {
		@Test
		@DisplayName("returns lowest seed when not filtered through any maps")
		void returnsLowestSeedWhenNotFilteredThroughAnyMaps() {
			assertAll(
					() -> assertEquals("1", new Day5().first("seeds: 1 2 3"))
					, () -> assertEquals("13", new Day5().first("seeds: 79 14 55 13"))
			);
		}
		
		@Test
		@DisplayName("returns lowest number when passed through one map which lowers the value of a certain range")
		void returnsLowestNumberWhenPassedThroughOneMapWhichLowersTheValueOfACertainRange() {
			assertAll(
					() -> assertEquals("10", new Day5().first("""
							seeds: 10 20
							
							sample map:
							50 90 1"""))
					, () -> assertEquals("1", new Day5().first("""
							seeds: 10 20
							
							sample map:
							1 20 1"""))
					, () -> assertEquals("2", new Day5().first("""
							seeds: 10 20 30
							
							sample map:
							1 29 3"""))
			);
		}
		
		@Test
		@DisplayName("returns lowest number when passed through one map which raises the value of a certain range")
		void returnsLowestNumberWhenPassedThroughOneMapWhichRaisesTheValueOfACertainRange() {
			assertAll(
					() -> assertEquals("20", new Day5().first("""
							seeds: 10 20
							
							sample map:
							50 10 1"""))
					, () -> assertEquals("10", new Day5().first("""
							seeds: 10 20
							
							sample map:
							22 20 1"""))
					, () -> assertEquals("20", new Day5().first("""
							seeds: 10 20 30
							
							sample map:
							50 9 3"""))
			);
		}
		
		@Test
		@DisplayName("returns lowest number when passed through one map with multiple ranges")
		void returnsLowestNumberWhenPassedThroughOneMapWithMultipleRanges() {
			assertAll(
					() -> assertEquals("1", new Day5().first("""
							seeds: 10 20 30
							
							sample map:
							50 10 1
							1 30 1"""))
					, () -> assertEquals("20", new Day5().first("""
							seeds: 10 20 30
							
							sample map:
							50 10 1
							60 20 1
							20 30 1
							1 60 1"""))
			);
		}
		
		@Test
		@DisplayName("returns lowest number when passed through multiple maps")
		void returnsLowestNumberWhenPassedThroughMultipleMaps() {
			assertAll(
					() -> assertEquals("1", new Day5().first("""
							seeds: 10 20 30
							
							map:
							2 20 1
							
							map:
							1 30 1
							"""))
					, () -> assertEquals("49", new Day5().first("""
							seeds: 53
							
							fertilizer-to-water map:
							49 53 8
							0 11 42
							"""))
					, () -> assertEquals("43", new Day5().first("""
							seeds: 14
							
							seed-to-soil map:
							50 98 2
							52 50 48
							
							soil-to-fertilizer map:
							0 15 37
							37 52 2
							39 0 15
							
							fertilizer-to-water map:
							49 53 8
							0 11 42
							42 0 7
							57 7 4
							
							water-to-light map:
							88 18 7
							18 25 70
							
							light-to-temperature map:
							45 77 23
							81 45 19
							68 64 13
							
							temperature-to-humidity map:
							0 69 1
							1 0 69
							
							humidity-to-location map:
							60 56 37
							56 93 4
							"""))
			);
		}
		
	}
	
	@Nested
	@DisplayName("Solution 2")
	class Solution2 {
	}
}
