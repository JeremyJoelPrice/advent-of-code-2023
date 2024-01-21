package com.jeremyjoelprice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day5 extends Solution {
	
	@Override
	String first(String input) {
		List<String> almanacSections = new ArrayList<>(Arrays.asList(input.split("\n\n")));
		
		// parse seeds
		long[] seeds = Arrays.stream(almanacSections.get(0)
						.split(": ")[1]
						.split(" "))
				.mapToLong(Long::parseLong)
				.toArray();
		almanacSections.remove(0);
		
		
		// parse each map and apply it to the seeds
		for (String mapString : almanacSections) {
			AlmanacMap map = getMapFromString(mapString);
			
			// pass each seed through all maps to get final results
			for (int i = 0; i < seeds.length; i++) {
				seeds[i] = map.transform(seeds[i]);
			}
		}
		
		// return lowest element of transformed seeds
		long lowestNum = Arrays.stream(seeds).reduce(Long.MAX_VALUE, (a, b) -> Math.min(a, b));
		return String.valueOf(lowestNum);
	}
	
	@Override
	String second(String input) {
		return null;
	}
	
	private AlmanacMap getMapFromString(String input) {
		AdjustedRange[] ranges = Arrays.stream(input.split("\n"))
				.skip(1)
				.map((s) -> {
					long[] rangeNums = Arrays.stream(s
									.split(" "))
							.mapToLong(Long::parseLong)
							.toArray();
					return new AdjustedRange(
							rangeNums[0],
							rangeNums[1],
							rangeNums[2]);
				}).toArray(size -> new AdjustedRange[size]);
		
		return new AlmanacMap(ranges);
	}
	
	private class AdjustedRange {
		long sourceStart;
		long destinationStart;
		long rangeSize;
		
		public AdjustedRange(long destinationStart, long sourceStart, long rangeSize) {
			this.sourceStart = sourceStart;
			this.destinationStart = destinationStart;
			this.rangeSize = rangeSize;
		}
		
		boolean isValid(long num) {
			return num >= sourceStart && num < sourceStart + rangeSize;
		}
		
		long transform(long num) {
			// is num in range?
			return num - (sourceStart - destinationStart);
		}
	}
	
	private class AlmanacMap {
		AdjustedRange[] ranges;
		
		public AlmanacMap(AdjustedRange[] ranges) {
			this.ranges = ranges;
		}
		
		long transform(long num) {
			for (AdjustedRange range : ranges) {
				if (range.isValid(num)) {
					return range.transform(num);
				}
			}
			return num;
		}
	}
}
