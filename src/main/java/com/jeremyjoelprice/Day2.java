package com.jeremyjoelprice;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day2 extends Solution {
	
	private DiceBag diceBag;
	
	public Day2() {
	}
	
	public Day2(int red, int green, int blue) {
		diceBag = new DiceBag(red, green, blue);
	}
	
	@Override
	String first(String input) {
		diceBag = diceBag == null ? new DiceBag(12, 13, 14) : diceBag;
		int sum = Arrays.stream(input.split("\n"))
				.map(Game::new)
				.filter(this::isGamePossible)
				.mapToInt(game -> game.id).sum();
		
		return String.valueOf(sum);
	}
	
	@Override
	String second(String input) {
		return String.valueOf(Arrays.stream(input.split("\n"))
				.map(Game::new)
				.mapToInt(game -> getRequiredDice(game).power())
				.sum());
	}
	
	private DiceBag getRequiredDice(Game game) {
		DiceBag diceBag = new DiceBag(0, 0, 0);
		for (int i = 0; i < game.rounds.length; i++) {
			Round round = game.rounds[i];
			diceBag.red = round.red > diceBag.red ? round.red : diceBag.red;
			diceBag.green = round.green > diceBag.green ? round.green : diceBag.green;
			diceBag.blue = round.blue > diceBag.blue ? round.blue : diceBag.blue;
		}
		return diceBag;
	}
	
	private boolean isGamePossible(Game game) {
		for (int i = 0; i < game.rounds.length; i++) {
			Round round = game.rounds[i];
			if (round.red > diceBag.red || round.green > diceBag.green || round.blue > diceBag.blue) return false;
		}
		return true;
	}
	
	private class Game {
		int id;
		Round[] rounds;
		
		Game(String gameString) {
			Matcher matcher = Pattern.compile("Game\s(\\d+)").matcher(gameString);
			matcher.find();
			this.id = Integer.parseInt(matcher.group(1));
			
			this.rounds = Arrays.stream(gameString.split(";"))
					.map(Round::new)
					.toArray(Round[]::new);
		}
	}
	
	private class Round {
		int red;
		int green;
		int blue;
		
		Round(String roundString) {
			Matcher matcher;
			// extract red
			matcher = Pattern.compile("(\\d+)\sred").matcher(roundString);
			if (matcher.find()) {
				this.red = Integer.parseInt(matcher.group(1));
			}
			
			// extract green
			matcher = Pattern.compile("(\\d+)\sgreen").matcher(roundString);
			if (matcher.find()) {
				this.green = Integer.parseInt(matcher.group(1));
			}
			
			// extract blue
			matcher = Pattern.compile("(\\d+)\sblue").matcher(roundString);
			if (matcher.find()) {
				this.blue = Integer.parseInt(matcher.group(1));
			}
		}
	}
	
	private class DiceBag {
		int red;
		int green;
		int blue;
		
		DiceBag(int red, int green, int blue) {
			this.red = red;
			this.green = green;
			this.blue = blue;
		}
		
		int power() {
			if (red == 0 && green == 0 && blue == 0) return 0;
			int power = red == 0 ? 1 : red;
			power *= green == 0 ? 1 : green;
			power *= blue == 0 ? 1 : blue;
			return power;
		}
	}
}
