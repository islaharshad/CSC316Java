package edu.ncsu.csc316.security_log.manager;


import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;


/**
 * Used for local interfarence to check the program
 * @author Islahuddin Arshad
 *
 */
public class SecurityLogManagerUI {


	/**Option of the input*/
	private static String inputOption;
	/**The start time to be inputted*/
	private static String startTime;
	/**The end time to be inputted*/
	private static String endTime;
	/**the user name of the user*/
	private static String userName;

	
	
	/**
	 * The main UI to check
	 * @param args the argument to be thrown
	 * @throws FileNotFoundException 
	 * @throws ParseException if the date cannot be parsed
	 *@throw FileNotFoundException if the file cannot be found
	 */
	public static void main(String[] args) throws FileNotFoundException, ParseException {
		
		run();
		
	}
	
	
	/**
	 * Runs the program
	 * @throws ParseException
	 */
	public static void run() throws ParseException, FileNotFoundException {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the file name you wish to read from:");
		String path = input.nextLine();
		SecurityLogManager slm = null;
		slm = new SecurityLogManager(path);
		String userReport = "";
		String operationalReport = "";
		System.out.println("Press 'p' to generate operational file. Press 'u' to generate user file. Press 'q' to quit.");
		inputOption = input.next();
		if (inputOption.equalsIgnoreCase("p")) {
			Scanner newInput = new Scanner(System.in);
			System.out.println("Please enter the start time:");
			startTime = newInput.nextLine();
			System.out.println("Please enter the end time:");
			endTime = newInput.nextLine();
			operationalReport = slm.generateOperationalProfile(startTime, endTime);
			System.out.println(operationalReport);
		}
		else if (inputOption.equalsIgnoreCase("u")) {
			System.out.println("Please enter the name of the user:");
			input.nextLine(); 
			userName = input.nextLine();
			userReport = slm.getUserReport(userName);
			System.out.println(userReport); //////////////////////////user report needs to be written to a new file
		}
		else if (inputOption.equalsIgnoreCase("q")) {
			System.exit(0);
		}
		input.close();
	}
		

		
	
	
	
		
	
	
}
