package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Main {

	public static void main(String args[]) {

		FileManagement file = new FileManagement("C:\\Users\\sleca\\symptoms.txt");

		ArrayList<String> result = new ArrayList<String>();
		result = (ArrayList<String>) file.getFileIn();

		Map<String, Integer> data = new TreeMap<String, Integer>();
		data = file.getFileOccurence(result);

		System.out.println(data);
		/*
		 * Données de l'ArrayList result transférées dans la TreeMap data qui compte le
		 * nombre d'occurence pour chaque symptôme et les classe par ordre alphabétique
		 */
	}
}
