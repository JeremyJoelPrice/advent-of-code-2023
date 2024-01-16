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
			assertAll(() -> assertEquals("8", new Day4().first("Card 1: 0 1 2 3 4 | 2 3 99 99 4 9 1 99")), () -> assertEquals("2", new Day4().first("Card 2: 0 2 0 0 1 | 1 99 99 99 2 99")), () -> assertEquals("4", new Day4().first("Card 2: 1 2 3 | 99 99 99 99  1  2  3 99 99")), () -> assertEquals("0", new Day4().first("Card 2: 0 | 1")), () -> assertEquals("4", new Day4().first("Card 2: 1 | 1 1 1")), () -> assertEquals("1", new Day4().first("Card 1: 1 0 0 0 0 0 0 | 99 1")));
		}
		
		@Test
		@DisplayName("sums the value of all given cards")
		void sumsTheValueOfAllGivenCards() {
			assertAll(() -> assertEquals("13", new Day4().first("""
					Card 1: 0 1 2 3 4 | 2 3 99 99 4 99 1 99
					Card 2: 0 1 0 0 2 | 2 99 99 1 99 99
					Card 3:  1 2 0 0 0 | 99 2 99 1
					Card 4: 0 0 0 1 0 | 99 1 99 99
					Card 5: 0 0 0 0 0 | 99 99 99 99 99 99 99 99
					Card 6: 0 0 0 0 0 | 74 77 10 23 35 67 36 11""")), () -> assertEquals("18", new Day4().first("""
					Card 1: 0 1 2 3 4 | 2 3 99 99 4 99 1 99"
					Card 2: 0 1 0 0 2 | 2 99 99 1 99 99"
					Card 3: 1 2 3 | 99 99 99 99  1  2  3 99 99"
					Card 4: 0 | 99 99 99 99 99 99 99 99"
					Card 5: 1 | 1 1 1""")));
			
		}
	}
	
	@Nested
	@DisplayName(("Solution 2"))
	class Solution2 {
		@Test
		@DisplayName("returns number of cards given no winning cards")
		void returnsNumberOfCardsGivenNoWinningCards() {
			assertAll(
					() -> assertEquals("1", new Day4().second("Card 1: 0 | 1"))
					, () -> assertEquals("2", new Day4().second("""
							Card 1: 0 | 1
							Card 2: 0 | 1"""))
			);
		}
		
		@Test
		@DisplayName("returns number of cards when a winning number creates a copy of the subsequent card")
		void returnsNumberOfCardsWhenAWinningNumberCreatesACopyOfTheSubsequentCard() {
			assertAll(
					() -> assertEquals("3", new Day4().second("""
							Card 1: 1 | 1
							Card 2: 0 | 99"""))
					, () -> assertEquals("6", new Day4().second("""
							Card 1: 1 | 1
							Card 2: 1 | 1
							Card 3: 0 | 99"""))
					, () -> assertEquals("6", new Day4().second("""
							Card 1: 1 | 1
							Card 2: 0 | 99
							Card 3: 1 | 1
							Card 4: 0 | 99"""))
			);
		}
		
		@Test
		@DisplayName("card counts compound given consecutive winning cards")
		void cardCountsCompoundGivenConsecutiveWinningCards() {
			assertAll(
					() -> assertEquals("7", new Day4().second("""
							Card 1: 1 | 1 1
							Card 2: 1 | 1
							Card 3: 0 | 99"""))
					, () -> assertEquals("30", new Day4().second("""
							Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
							Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19
							Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1
							Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83
							Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36
							Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11"""))
			);
		}
		
	}
}
