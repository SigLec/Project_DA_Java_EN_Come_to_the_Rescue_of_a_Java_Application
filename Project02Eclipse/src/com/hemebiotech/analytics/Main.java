package com.hemebiotech.analytics;

import java.util.ArrayList;

public class Main {

	public static void main(String args[]) {

		FileManagement file = new FileManagement("C:\\Users\\sleca\\symptoms.txt");

		ArrayList<String> result = new ArrayList<String>();
		result = (ArrayList<String>) file.getFileIn();

		System.out.println(result); // Lecture des données de file dans l'ArrayList result
	}
}
