package com.jeremyjoelprice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Day2Test {
	@Nested
	@DisplayName("Solution 1")
	class Solution1 {
		
		@Test
		@DisplayName("returns 0 when given one impossible single-round game")
		void returns0WhenGivenOnlyImpossibleGames() {
			assertAll(
					() -> assertEquals("0", new Day2(0, 0, 0).first("Game 1: 300 red"))
					, () -> assertEquals("0", new Day2(0, 0, 0).first("Game 1: 300 green"))
					, () -> assertEquals("0", new Day2(0, 0, 0).first("Game 1: 300 blue"))
			);
		}
		
		@Test
		@DisplayName("returns game number when given one possible single-round game")
		void returnsGameNumberWhenGivenAPossibleSingleDiceGame() {
			assertAll(
					() -> assertEquals("1", new Day2(1, 0, 0).first("Game 1: 1 red"))
					, () -> assertEquals("2", new Day2(0, 1, 0).first("Game 2: 1 green"))
					, () -> assertEquals("3", new Day2(0, 0, 1).first("Game 3: 1 blue"))
			);
		}
		
		@Test
		@DisplayName("returns 0 when given one impossible multi-round game")
		void returns0WhenGivenOneImpossibleMultiRoundGame() {
			assertAll(
					() -> assertEquals("0", new Day2(0, 0, 0).first("Game 1: 0 blue, 0 red; 0 green; 4 green"))
					, () -> assertEquals("0", new Day2(0, 0, 0).first("Game 1: 0 blue, 1 red; 0 green; 0 green"))
			);
		}
		
		@Test
		@DisplayName("returns the id sum of all games when given possible games")
		void returnsTheIdSumOfAllGamesWhenGivenPossibleGames() {
			assertEquals("6", new Day2(1, 1, 1).first("Game 1: 1 red\nGame 2: 1 green\nGame 3: 1 blue"));
		}
		
		@Test
		@DisplayName("returns the id sum of possible games only")
		void returnsTheIdSumOfPossibleGamesOnly() {
			String games = """
					Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
					Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
					Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
					Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
					Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green""";
			assertEquals("8", new Day2(12, 13, 14).first(games));
		}
	}
	
	@Nested
	@DisplayName("Solution 2")
	class Solution2 {
		
		@Test
		@DisplayName("return the power of a single-dice game")
		void returnThePowerOfASingleDiceGame() {
			assertAll(
					() -> assertEquals("0", new Day2().second("Game 1: 0 red"))
					, () -> assertEquals("1", new Day2().second("Game 1: 1 red"))
					, () -> assertEquals("2", new Day2().second("Game 1: 2 green"))
					, () -> assertEquals("3", new Day2().second("Game 1: 3 blue"))
			);
		}
		
		@Test
		@DisplayName("return the power of a given game")
		void returnThePowerOfAGivenGame() {
			assertAll(
					() -> assertEquals("6", new Day2().second("Game 1: 1 red, 2 green, 3 blue"))
					, () -> assertEquals("12", new Day2().second("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue"))
			);
		}
		
		@Test
		@DisplayName("returns the summed powers of all games")
		void returnsTheSummedPowersOfAllGames() {
			String gameString = """
					Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
					Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
					Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
					Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
					Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green""";
			
			assertEquals("2286", new Day2().second(gameString));
		}
	}
}
