package com.electrogeeks;

import java.util.Scanner;

import com.electrogeeks.models.Electronic;
import com.electrogeeks.storage.TempStorage;
import com.electrogeeks.util.Logger;
import com.electrogeeks.util.Logger.LogLevel;

public class driver {
	private static Logger logger = Logger.getLogger();
	public static void main(String[] args) {
		logger.log(LogLevel.info, "Application Start");
		mockData();
		Scanner scanner = new Scanner(System.in);
		String userInput = "";
		do {
			System.out.println("Welcome from the ElectroGeeks! How can we help you?");
			System.out.println("[1] Electronics"); // show a list of electronic 
			System.out.println("[2] Give rating"); // 
			System.out.println("[x] Exit");

			userInput = scanner.nextLine();

			switch (userInput) {
			case "1":
				electronics();
				break;
				
			case "2":
				giveRating(scanner);
				break;
				
			case "x":
				break;
				
			default:
				System.out.println("Please choose a valid number.");
				break;
			}
		} while (!userInput.equals("x"));
		scanner.close();
		logger.log(LogLevel.info, "Application End");

	}

	public static void electronics() {	
		for(int i =0; i<TempStorage.electronicList.getLastIndex();i++) {
			System.out.println(TempStorage.electronicList.get()[i]);
			System.out.println("");
		}
	}
	
	public static void giveRating(Scanner scanner) {
		System.out.println("Which electronic you want to rate?");
		//print all the electronic with index 
		for(int i =0; i<TempStorage.electronicList.getLastIndex();i++) {
			String output = "["+(i+1)+"] "+TempStorage.electronicList.get()[i].getName() +" "+TempStorage.electronicList.get()[i].getModel();
			System.out.println(output);
		}
		System.out.print("Please choose the number: ");
		int electronicIndex = scanner.nextInt();
		String output = TempStorage.electronicList.get()[electronicIndex-1].getName() +" "+TempStorage.electronicList.get()[electronicIndex-1].getModel();
		System.out.println(output);
		System.out.print("Give rating(1-5): ");
		TempStorage.electronicList.get()[electronicIndex-1].setRating(scanner.nextInt());
		scanner.nextLine();
		logger.log(LogLevel.info, "Set rating: "+TempStorage.electronicList.get()[electronicIndex-1].getRating());
		System.out.println("");
		
	}
	
	public static void mockData() {
		logger.log(LogLevel.info, "Adding the electronic to tempory storage");
		String[] recommendedStore = {"Bestbuy","Amazon","Walmart"};
		Electronic iPhone = new Electronic("iPhone", "13 Pro Max", 1299.99, recommendedStore,"iPhone 13 Pro takes a huge leap forward, bringing incredible speed to everything you do and dramatic new photo and video capabilities — all in two great sizes.");
		TempStorage.electronicList.add(iPhone);
		
		Electronic iPad = new Electronic("iPad", "Mini", 799.99, recommendedStore,"iPad mini is meticulously designed to be absolutely beautiful. An all-new enclosure features a new, larger edge-to-edge screen, along with narrow borders and elegant rounded corners.");
		TempStorage.electronicList.add(iPad);
		
		Electronic airPod = new Electronic("airPod", "Pro", 199.99, recommendedStore,"A super-efficient high dynamic range amplifier produces pure, incredibly clear sound while also extending battery life.");
		TempStorage.electronicList.add(airPod);
		
		Electronic appleWatch = new Electronic("Apple Watch", "Series 7 - regular band", 399.99, recommendedStore,"Apple Watch can do what your other devices can’t because it’s on your wrist. When you wear it, you get a fitness partner that measures all the ways you move, meaningful health insights, and a connection to the people and things you care about most. And it’s always just a glance away.");
		TempStorage.electronicList.add(appleWatch);
	}

}
