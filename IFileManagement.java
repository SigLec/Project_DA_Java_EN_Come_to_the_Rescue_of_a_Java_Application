package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Read data file in a list, count duplications, put in natural order and write
 * them in a new file.
 */
public interface IFileManagement {
	/**
	 *
	 * @return a raw listing of all data obtained from source. If no data is
	 *         available, return an empty List
	 */
	List<String> getFileIn();

	/**
	 * @return a map counting all symptoms duplications and classifying in natural
	 *         order.
	 */
	Map<String, Integer> getFileOccurence(ArrayList<String> result);

	/**
	 * @return a new file containing the data of the TreeMap.
	 */
	FileWriter getFileOut(Map<String, Integer> data);
}
