package com.jeremyjoelprice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MainClass {
	public static void main(String[] args) {
		printSolution(new Day1(), "1");
		printSolution(new Day2(), "2");
		printSolution(new Day3(), "3");
		printSolution(new Day4(), "4");
	}
	
	private static void printSolution(Solution solution, String inputFileName) {
		try {
			String puzzleInput = Files.readString(Path.of(String.format("src/main/resources/puzzle-input/%s.txt", inputFileName)));
			System.out.printf("Day %s\n", inputFileName);
			System.out.println("	Puzzle 1: " + solution.first(puzzleInput));
			System.out.println("	Puzzle 2: " + solution.second(puzzleInput));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
