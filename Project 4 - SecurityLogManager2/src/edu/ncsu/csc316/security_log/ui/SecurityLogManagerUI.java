package edu.ncsu.csc316.security_log.ui;

import java.io.File;

import java.util.Scanner;

import edu.ncsu.csc316.security_log.manager.SecurityLogManager;



/**
 * Runs the UI for security log manager and its two methods
 * @author Islahuddin Arshad
 *
 */
public class SecurityLogManagerUI {

	
	/**
	 * Runs the main file for security log manager
	 * @param args the arguments in the main method
	 */
	public static void main(String args[]) {
		String filePath = "sampleInput.txt";
		Scanner input = new Scanner(System.in);
		
		
		String userName = "";
		SecurityLogManager m = null;
		
		File file = new File(filePath);
		
		while (!file.exists()) {
			System.out.print("Please enter file path: ");
			filePath = input.nextLine();
			
			file = new File(filePath);
		}
		
		m = new SecurityLogManager(filePath);
		
		System.out.println("Press 1 to generate operational profile:");
		System.out.println("Press 2 to get user report:");
		System.out.println("Press 3 to quit");
		int choice = input.nextInt();
		
		if (choice == 1) {
			System.out.println("Enter the start time stamp, in format MM/DD/YYYY");
			String startTimeMMDDYY = input.next();
			System.out.println("Enter the start time stamp, in format HH:MM:SSXM");
			String startTimeHHMMSSXM = input.next();
			String start = startTimeMMDDYY + " " + startTimeHHMMSSXM;
			System.out.println("Enter the end time stamp, in format MM/DD/YYYY");
			String endTimeMMDDYY = input.next();
			System.out.println("Enter the start time stamp, in format HH:MM:SSXM");
			String endTimeHHMMSSXM = input.next();
			String end = endTimeMMDDYY + " " + endTimeHHMMSSXM;
			
			System.out.println(m.generateOperationalProfile(start, end));
		}
		else if (choice == 2) {
			System.out.println("Enter the name of the user to generate user report: ");
			userName = input.next();
			System.out.println(m.getUserReport(userName));
		}
		else if (choice == 3) {
			System.exit(0);
		}
		input.close();
	}
}
