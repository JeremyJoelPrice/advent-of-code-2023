package com.jeremyjoelprice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 extends Solution {
	MutableInt sum;
	String[] rows;
	
	@Override
	String first(String input) {
		rows = input.split("\n");
		sum = new MutableInt();
		
		forEachMatch("(\\d+)", (coordinates) -> {
			if (isPartNumber(coordinates)) {
				sum.add(Integer.valueOf(rows[coordinates.y].substring(coordinates.xStart, coordinates.xEnd)));
			}
		});
		
		return String.valueOf(sum.getValue());
	}
	
	@Override
	String second(String input) {
		rows = input.split("\n");
		sum = new MutableInt();
		forEachMatch("\\*", (coordinates) -> {
			// check if there's a number before and after it
			String[] neighouringNumbers = getNeighbouringNumbers(coordinates);
			// multiply them together to get the gear ratio
			int gearRatio = Arrays.stream(neighouringNumbers)
					.mapToInt(Integer::parseInt)
					.reduce(0, (int total, int currentNum) ->
							total == 0 ? currentNum : total * currentNum
					);
			sum.add(gearRatio);
		});
		return String.valueOf(sum.getValue());
	}
	
	private void forEachMatch(String pattern, Callback callback) {
		for (int i = 0; i < rows.length; i++) {
			Matcher matcher = Pattern.compile(pattern).matcher(rows[i]);
			while (matcher.find()) {
				callback.execute(new MatchCoordinates(i, matcher.start(), matcher.end()));
			}
		}
	}
	
	private boolean isPartNumber(MatchCoordinates coordinates) {
		int y = coordinates.y;
		int row = Math.max(y - 1, 0);
		for (; row <= Math.min(y + 1, rows.length - 1); row++) {
			
			int column = Math.max(coordinates.xStart - 1, 0);
			int endChar = Math.min(coordinates.xEnd + 1, rows[y].length());
			for (; column < endChar; column++) {
				
				if (Pattern.compile("[^\\d.]").matcher(String.valueOf(rows[row].charAt(column))).find()) {
					return true;
				}
			}
		}
		return false;
	}
	
	private String[] getNeighbouringNumbers(MatchCoordinates coordinates) {
		Pattern pattern = Pattern.compile("(\\d+)");
		ArrayList<String> neighbours = new ArrayList<>();
		
		for (int i = Math.max(0, coordinates.y - 1); i <= Math.min(rows.length - 1, coordinates.y + 1); i++) {
			Matcher matcher = pattern.matcher(rows[i]);
			while (matcher.find()) {
				if (
						matcher.start() == coordinates.xStart ||
								matcher.start() == coordinates.xEnd ||
								matcher.end() == coordinates.xStart ||
								(matcher.start() <= coordinates.xStart &&
										matcher.end() >= coordinates.xEnd)
				
				) {
					neighbours.add(matcher.group());
				}
			}
		}
		return neighbours.size() == 2 ? neighbours.toArray(new String[0]) : new String[]{};
	}
	
	private class MutableInt {
		private int value;
		
		public MutableInt() {
			value = 0;
		}
		
		public void add(int n) {
			value += n;
		}
		
		public void multiply(int n) {
			value *= n;
		}
		
		public int getValue() {
			return value;
		}
		
		public void setValue(int value) {
			this.value = value;
		}
	}
	
	@FunctionalInterface
	private interface Callback {
		void execute(MatchCoordinates coordinates);
	}
	
	private class MatchCoordinates {
		public MatchCoordinates(int y, int xStart, int xEnd) {
			this.y = y;
			this.xStart = xStart;
			this.xEnd = xEnd;
		}
		
		int y;
		int xStart;
		int xEnd;
	}
}
