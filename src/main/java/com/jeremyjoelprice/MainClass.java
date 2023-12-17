package com.jeremyjoelprice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MainClass {
	public static void main(String[] args) {
		printSolution(new Day1(), "src/main/resources/puzzle-input/1-1.txt", "src/main/resources/puzzle-input/1-1.txt");
		printSolution(new Day2(), "src/main/resources/puzzle-input/2-1.txt", null);
	}
	
	private static void printSolution(Solution solution, String inputFilePathOne, String inputFilePathTwo) {
		Path path = Path.of(inputFilePathOne);
		try {
			String contents = Files.readString(Path.of(inputFilePathOne));
			System.out.println(solution.first(contents));
			if (inputFilePathTwo != null) {
				contents = Files.readString(Path.of(inputFilePathTwo));
				System.out.println(solution.second(contents));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
