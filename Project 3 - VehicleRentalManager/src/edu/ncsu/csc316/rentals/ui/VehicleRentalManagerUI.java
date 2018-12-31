package edu.ncsu.csc316.rentals.ui;

import java.io.File;
import java.util.Scanner;

import edu.ncsu.csc316.rentals.manager.VehicleRentalManager;

/**
 * This is the ui class that tests the overall program
 * @author Islahuddin Arshad
 *
 */
public class VehicleRentalManagerUI {
	
	
	/**
	 * Runs the vehicle rental manager 
	 * @param args the argruments to input
	 */
	public static void main(String[] args) {
		
		VehicleRentalManager manager = null;
		String filePath = "";
		String queryProfile = "";
		String graphProfile = "";
		
		Scanner input = new Scanner(System.in);
		
		filePath = "ex1.txt";
		File file = new File(filePath);
		
		while (!file.exists()) {
			System.out.println("Please enter the file path");
			System.out.println("Filepath: ");
			filePath = input.nextLine();
			
			file = new File(filePath);
		}
		
		manager = new VehicleRentalManager(filePath);
		
		System.out.println("Success!");
		System.out.println("Press 1 to generate query profile.");
		System.out.println("Press 2 to generate graph prfile");
		System.out.println("Press 3 to quit");
		int inputAnswer = input.nextInt();
		
		if (inputAnswer == 1) {
			System.out.println("Please enter the start day to generate rental query: ");
			int sD = input.nextInt();
			queryProfile = manager.getRentalsForDay(sD);
			System.out.println(queryProfile); 
		}
		else if (inputAnswer == 2) {
			System.out.println("Please enter the start day of graph profile");
			int startDay = input.nextInt();
			System.out.println("Please enter the end day of graph profile");
			int endDay = input.nextInt();
			graphProfile = manager.getRentals(startDay, endDay); 
			System.out.println(graphProfile);
		}
		else if (inputAnswer == 3) {
			System.exit(0);
		}
		input.close();
		
	}

}
