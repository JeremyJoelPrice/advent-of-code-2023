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
			value += cards[i].value;
		}
		return String.valueOf(value);
	}
	
	CardCount[] cardCounts;
	
	@Override
	String second(String input) {
		cardCounts = Arrays.stream(input.split("\n"))
				.map(row -> new CardCount(parseAsCard(row)))
				.toArray(CardCount[]::new);
		
		for (int i = 0; i < cardCounts.length; i++) {
			CardCount current = cardCounts[i];
			for (int count = 0; count < current.count; count++) {
				for (int wins = 0; wins < current.card.numOfWins; wins++) {
					cardCounts[wins + i + 1].count++;
				}
			}
		}
		
		return String.valueOf(Arrays.stream(cardCounts).reduce(0, (sum, cardCount) -> sum + cardCount.count, Integer::sum));
	}
	
	private Card parseAsCard(String input) {
		String[] cardSplit = input.substring(input.indexOf(": ") + 2).split(" \\| +");
		return new Card(Arrays.asList(cardSplit[0].split(" +")), Arrays.asList(cardSplit[1].split(" +")));
	}
	
	private class Card {
		List<String> winningNumbers;
		List<String> revealedNumbers;
		int value = 0;
		private int numOfWins = 0;
		
		public Card(List<String> winningNumbers, List<String> revealedNumbers) {
			this.winningNumbers = winningNumbers;
			this.revealedNumbers = revealedNumbers;
			
			revealedNumbers.stream().forEach((num) -> {
				if (winningNumbers.contains(num)) numOfWins++;
			});
			
			for (int i = 0; i < numOfWins; i++) {
				incrementValue();
			}
		}
		
		void incrementValue() {
			value = value == 0 ? 1 : value * 2;
		}
	}
	
	private class CardCount {
		Card card;
		int count = 1;
		
		public CardCount(Card card) {
			this.card = card;
		}
	}
}
