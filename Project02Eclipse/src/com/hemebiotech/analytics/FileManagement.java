package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 *
 */
public class FileManagement implements IFileManagement {

	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public FileManagement(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public List<String> getFileIn() {
		ArrayList<String> result = new ArrayList<String>();

		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	@Override
	public Map<String, Integer> getFileOccurence(ArrayList<String> result) {
		TreeMap<String, Integer> data = new TreeMap<String, Integer>();

		for (String s : result) {
			int count = data.containsKey(s) ? data.get(s) : 0;
			data.put(s, count + 1);
		}
		return data;
	}

	@Override
	public FileWriter getFileOut(Map<String, Integer> data) {

		try {
			FileWriter fileOut = new FileWriter("results.out");
			BufferedWriter out = new BufferedWriter(fileOut);
			for (Map.Entry<String, Integer> entry : data.entrySet()) {
				out.write(entry.getKey() + " = " + entry.getValue() + "\n");
			}
			out.flush();
			out.close();
			return fileOut;

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erreur : le fichier n'a pas été généré");
		}
		return null;
	}

}
