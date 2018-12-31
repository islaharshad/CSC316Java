package edu.ncsu.csc316.hr.io;
import java.io.File;

import java.io.FileNotFoundException;
import java.util.Scanner;
import edu.ncsu.csc316.hr.resource.Resume;
import edu.ncsu.csc316.hr.util.MyArrayList;
import edu.ncsu.csc316.hr.util.MySplayer;


/**
 * Parses the resume file from resume
 * @author Islahuddin Arshad
 *
 */
public class ResumeReader {

	/**A resume object*/
	private Resume r;
	/**A string object to read off file from textfile*/
	private MyArrayList<String> stringResume;
	/**A splay tree to add resume objects in*/
	private MySplayer splayTree;
	/**File path to resume file*/
	public String filePathToResume;
	/**The resume file*/
	public File resumeFile;
	/**The resume scanner*/
	public Scanner resumeReader;
	 
	/**
	 * Constructor for the resumReader that takes in a file path to resume
	 * @param filePathToResume the file path to resume file
	 */
	public ResumeReader(String filePathToResume) {
		this.filePathToResume = filePathToResume;

	
	}
	/**
	 * Parses the resume and adds into the resume object
	 * @param filePathToResume the file path to the resume file
	 * @return SplayTree return the splay tree
	 * @throws FileNotFoundException if file not found
	 */
	public MySplayer readResume(String filePathToResume) {
		///create new resume string list
		stringResume = new MyArrayList<String>();
		//create new splay tree instance
		splayTree = new MySplayer();
		
		///Create new resume object
		r = new Resume(0, "");
		
		///convert filepath to a file
		resumeFile = new File(filePathToResume);
		
		
		
	
		try {
			resumeReader = new Scanner(resumeFile);
		}
		catch (FileNotFoundException e) {
			throw new IllegalArgumentException("File not found");
		}
		
		
		
		
		String resumeLine = "";
		while (resumeReader.hasNextLine()) {
			resumeLine = resumeReader.nextLine();
			stringResume.insert(resumeLine);
		}
		String resumeID = "";
		String resumeSplitterString = "";
		String[] resumeSplit;
		for (int i = 1; i < stringResume.getSize(); i++) {
			resumeSplitterString = (String) stringResume.get(i);
			resumeSplit = resumeSplitterString.split(",");
//			if(resumeSplit.length < 3) {
//				System.out.println("Err with Resume " + resumeSplitterString);
//				continue;
//			}
			
			resumeID = resumeSplit[0].trim();
			r = (Resume) new Resume(Integer.parseInt(resumeSplit[1].trim()), resumeSplit[2].trim());
			splayTree.insert(resumeID, r);
		}
		
//		
//		Resume r1 = new Resume(2, "N");
//		Resume r2 = new Resume(3, "P");
//		String id1 = "R121212121";
//		String id2 = "R";		
//		splayTree.insert(id1, r1);
//		splayTree.insert(id2, r2);
		
		
		
		resumeReader.close();
		return splayTree;
	}
}
