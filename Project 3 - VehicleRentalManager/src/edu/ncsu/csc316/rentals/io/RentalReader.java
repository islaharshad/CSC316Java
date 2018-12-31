package edu.ncsu.csc316.rentals.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc316.rentals.resource.EdgeEntry;
import edu.ncsu.csc316.rentals.util.MyArrayList;


/**
 * Reads the file for rentals
 * @author Islahuddin Arshad
 *
 */
public class RentalReader {

	
	/**Each entry from file*/
	public EdgeEntry entry;
	/**The input from scanner*/
	public Scanner input;
	/**The entryString*/
	public MyArrayList<String> entryString;
	/**The edge string*/
	public MyArrayList<EdgeEntry> edgeList;
	/**The filePath*/
	public String filePath;
	
	
	/**
	 * Constructs a rental reader for the filepath
	 * @param filePath the path to file
	 */
	public RentalReader(String filePath) {
		
		this.filePath = filePath;
	}
	
	
	
	/**
	 * Reads the rental file and returns an edgelist full of edges 
	 * @param filePath the path of file read
	 * @return MyArrayList<EdgeEntry> the list full of edges
	 */
	public MyArrayList<EdgeEntry> readRental(String filePath) {
		edgeList = new MyArrayList<EdgeEntry>();
		entryString = new MyArrayList<String>();
		entry = new EdgeEntry(0, 0, 0, "", "");

		File file = new File(filePath);
		
		int max = 0;
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new IllegalArgumentException("File not found");
		}
		
		String entryLine = "";
		while (input.hasNextLine()) {
			entryLine = input.nextLine();
			entryString.insert(entryLine);
		}
		String entrySplitterString = "";
		String[] entrySplit;
		for (int i = 1; i < entryString.getSize(); i++) {
			entrySplitterString = (String) entryString.get(i);
			entrySplit = entrySplitterString.split(",");
			///Subtract 1 from startDay and endDay when parsing
			entry = new EdgeEntry(Integer.parseInt(entrySplit[0].trim()) - 1, Integer.parseInt(entrySplit[1].trim()) - 1, 
					Integer.parseInt(entrySplit[2].trim()), entrySplit[3].trim(), entrySplit[4].trim());
			
			//get the max of end day to build graph size
			if (max < entry.getEndDay()) {
				max = entry.getEndDay();
			}
			
			edgeList.insert(entry);
		}
		
		//last element of edgelist will have max endDay in endDay place
		edgeList.insert(new EdgeEntry(0, max, 0, "", ""));
		
		return edgeList;
	}
	
}

