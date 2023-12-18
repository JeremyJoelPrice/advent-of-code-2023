package com.jeremyjoelprice;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day2 extends Solution {
	private int red;
	private int green;
	private int blue;
	
	public Day2(int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	@Override
	String first(String input) {
		int sum = Arrays.stream(input.split("\n"))
				.map(this::parseGame)
				.filter(this::isGamePossible)
				.mapToInt(game -> game.id).sum();
		
		return String.valueOf(sum);
	}
	
	@Override
	String second(String input) {
		return null;
	}
	
	private boolean isGamePossible(Game game) {
		for (int i = 0; i < game.rounds.length; i++) {
			Round round = game.rounds[i];
			if (round.red > this.red || round.green > this.green || round.blue > this.blue) return false;
		}
		return true;
	}
	
	private Game parseGame(String gameString) {
		Matcher matcher = Pattern.compile("Game\s(\\d+)").matcher(gameString);
		matcher.find();
		int id = Integer.parseInt(matcher.group(1));
		
		Round[] rounds = Arrays.stream(gameString.split(";"))
				.map(this::parseRound)
				.toArray(Round[]::new);
		return new Game(id, rounds);
	}
	
	private Round parseRound(String roundString) {
		Round round = new Round(0, 0, 0);
		Matcher matcher;
		// extract red
		matcher = Pattern.compile("(\\d+)\sred").matcher(roundString);
		if (matcher.find()) {
			round.red = Integer.parseInt(matcher.group(1));
		}
		
		// extract green
		matcher = Pattern.compile("(\\d+)\sgreen").matcher(roundString);
		if (matcher.find()) {
			round.green = Integer.parseInt(matcher.group(1));
		}
		
		// extract blue
		matcher = Pattern.compile("(\\d+)\sblue").matcher(roundString);
		if (matcher.find()) {
			round.blue = Integer.parseInt(matcher.group(1));
		}
		
		return round;
	}
	
	private class Game {
		int id;
		Round[] rounds;
		
		public Game(int id, Round[] rounds) {
			this.id = id;
			this.rounds = rounds;
		}
	}
	
	private class Round {
		int red;
		int green;
		int blue;
		
		public Round(int red, int green, int blue) {
			this.red = red;
			this.green = green;
			this.blue = blue;
		}
	}
}
