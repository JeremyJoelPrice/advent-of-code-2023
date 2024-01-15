package com.jeremyjoelprice;

import java.util.Arrays;
import java.util.List;

public class Day4 extends Solution {
	@Override
	String first(String input) {
		Card[] cards = Arrays.stream(input.split("\n"))
				.map(row -> parseAsCard(row))
				.toArray(Card[]::new);
		int value = 0;
		for (int i = 0; i < cards.length; i++) {
			value += cards[i].getValue();
		}
		return String.valueOf(value);
	}
	
	@Override
	String second(String input) {
		return null;
	}
	
	private Card parseAsCard(String input) {
		String[] cardSplit = input.substring(input.indexOf(": ") + 2).split(" \\| +");
		return new Card(Arrays.asList(cardSplit[0].split(" +")), Arrays.asList(cardSplit[1].split(" +")));
	}
	
	private class Card {
		List<String> winningNumbers;
		List<String> revealedNumbers;
		
		public Card(List<String> winningNumbers, List<String> revealedNumbers) {
			this.winningNumbers = winningNumbers;
			this.revealedNumbers = revealedNumbers;
		}
		
		private int value = 0;
		
		int getValue() {
			revealedNumbers.stream().forEach((num) -> {
				if (winningNumbers.contains(num)) incrementValue();
			});
			return value;
		}
		
		void incrementValue() {
			value = value == 0 ? 1 : value * 2;
		}
	}
}
