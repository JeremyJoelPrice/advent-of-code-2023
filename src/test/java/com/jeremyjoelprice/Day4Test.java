package com.jeremyjoelprice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day4Test {
	
	@Nested
	@DisplayName(("Solution 1"))
	class Solution1 {
		@Test
		@DisplayName("returns value of a given card")
		void returnsValueOfAGivenCard() {
			assertAll(
					() -> assertEquals("8", new Day4().first("Card 1: 0 1 2 3 4 | 2 3 99 99 4 9 1 99"))
					, () -> assertEquals("2", new Day4().first("Card 2: 0 2 0 0 1 | 1 99 99 99 2 99"))
					, () -> assertEquals("4", new Day4().first("Card 2: 1 2 3 | 99 99 99 99  1  2  3 99 99"))
					, () -> assertEquals("0", new Day4().first("Card 2: 0 | 1"))
					, () -> assertEquals("4", new Day4().first("Card 2: 1 | 1 1 1"))
					, () -> assertEquals("1", new Day4().first("Card 1: 1 0 0 0 0 0 0 | 99 1"))
			);
		}
		
		@Test
		@DisplayName("sums the value of all given cards")
		void sumsTheValueOfAllGivenCards() {
			assertAll(
					() -> assertEquals("13", new Day4().first("""
							Card 1: 0 1 2 3 4 | 2 3 99 99 4 99 1 99
							Card 2: 0 1 0 0 2 | 2 99 99 1 99 99
							Card 3:  1 2 0 0 0 | 99 2 99 1
							Card 4: 0 0 0 1 0 | 99 1 99 99
							Card 5: 0 0 0 0 0 | 99 99 99 99 99 99 99 99
							Card 6: 0 0 0 0 0 | 74 77 10 23 35 67 36 11"""))
					, () -> assertEquals("18", new Day4().first("""
							Card 1: 0 1 2 3 4 | 2 3 99 99 4 99 1 99"
							Card 2: 0 1 0 0 2 | 2 99 99 1 99 99"
							Card 3: 1 2 3 | 99 99 99 99  1  2  3 99 99"
							Card 4: 0 | 99 99 99 99 99 99 99 99"
							Card 5: 1 | 1 1 1"""))
			);
			
		}
	}
}
