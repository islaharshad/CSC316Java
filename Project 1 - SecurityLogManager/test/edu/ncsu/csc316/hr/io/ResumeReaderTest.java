package edu.ncsu.csc316.hr.io;

import static org.junit.Assert.*;




import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStreamWriter;
//import java.io.Writer;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.hr.util.MySplayer;

/**
 * Tests thre resume reader class
 * @author Islahuddin Arshad
 *
 */
public class ResumeReaderTest {

	/**Created an instance resumeReader to test*/
	public ResumeReader rR;
	/**The file path resume file*/
	public String resumeFilePath;
	/**List of objects returned from resumeString*/
	public MySplayer mS;
	
	/**
	 * Creates the resumeReader object to test
	 */
	@Before
	public void setUp() {
		//resumeFilePath = "C:\\Users\\Islahuddin Arshad\\git\\csc316-001-P2-35\\HumanResourcesManager\\input\\resume.txt";
		resumeFilePath = "resumeFilePath1.txt";
		
		
//		String inputStr = new String(
//				"RESUME_ID, YEARS_OF_SERVICE, HIGHEST_DEGREE\r\n" +
//		"R228401745, 1, M\r\n" +
//		"R123582991, 1, B\r\n" +
//		"R040123346, 18, B\r\n" +
//		"R891429182, 9, P\r\n" +
//		"R200581294, 7, N\r\n" +
//		"R000634703, 4, M\r\n" +
//		"R829476581, 8, A\r\n");
//
//		
//		try(FileOutputStream fos = new FileOutputStream("resumeFilePath1.txt");
//			    Writer w = new OutputStreamWriter(fos, "UTF8"))
//			{
//			    w.write(inputStr);
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		String resumeFilePath = "resumeFilePath1.txt";
//		
		
		
		rR = new ResumeReader(resumeFilePath);
		mS = new MySplayer(); 
		
	}

	/**
	 * Checks the return string list of object for the resume reader
	 * @throws FileNotFoundException thrown if file not found
	 */
	@Test
	public void testReadResume() throws FileNotFoundException {
		mS = rR.readResume(resumeFilePath);
		assertEquals("P", mS.getDictObject("R891429182").getDegree());
	}

}
