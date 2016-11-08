package ca.cmpt213.as1content;

import java.io.File;
import java.util.ArrayList;

public class DemoAs1Content {

	public static void main(String[] args) {
		demoPrintf();
//		demoShuffle();
//		demoFile();
	}

	private static void demoPrintf() {
		// Demo newline. Normally done with \n, but %n is correct on all platforms.
		// (Some systems need \n, some need \n\r, %n does the right thing).
		System.out.printf(
				"*****************************%n" +
				"Printf() demo!%n" +
				"*****************************%n");
		
		System.out.printf("Hex: %x and %X%n", 0xDEADC0DE, 0xDEADC0DE);
		
		int height = 15765;
		double weight_g = 155233.025;
		System.out.printf("Hello %s, are you %,d cm tall and weigh %,2f too?%n", 
				"World",
				height,
				weight_g);
		
	
		// Demonstrate spacing
		// Just a space
		System.out.printf("%nTake 1:%n");
		System.out.printf("Value first:  %d %d%n", 9, 1111);
		System.out.printf("Value second: %d %d%n", 15465100, 1);
		System.out.printf("Value third:  %d %d%n", 574, 45);
		
		// Tabs (HOW DOES THIS GO WRONG?)
		System.out.printf("%nTake 2:%n");
		System.out.printf("Value first:  %d\t%d%n", 9, 1111);
		System.out.printf("Value second: %d\t%d%n", 15465100, 1);
		System.out.printf("Value third:  %d\t%d%n", 574, 45);

		// Column width specifier
		System.out.printf("%nTake 3:%n");
		System.out.printf("Value first:  %9d %7d%n", 9, 1111);
		System.out.printf("Value second: %9d %7d%n", 15465100, 1);
		System.out.printf("Value third:  %9d %7d%n", 574, 45);

		// From Notes
//		System.out.printf("%s! Is it %b that you're %d?%n",	"Waldo", true, 42);
//		double a = 154.7599;
//		int b = 98765431;
//		System.out.printf("Values: %,15.2f, %,5d%n", a, b);

	}

	private static void demoShuffle() {
		// Populate the ArrayList.
		final int SIZE = 5;

		// Cannot create ArrayList out of primitive types.
		//ArrayList<int> bogus;

		ArrayList<Double> values = new ArrayList<>();
		for (double i = 0; i < SIZE; i++) {
			// Create a Double wrapper object from the double value.
//			values.add(new Double(i * SIZE));
			
			// Also works without explicitly creating a Double:
			// Autoboxing: Java automatically wraps the double into a Double. 
			values.add(i * SIZE);
		}
		
		// Shuffle
		java.util.Collections.shuffle(values);
		
		// Display
		for (double value : values) {
			System.out.printf("Next value is %,8.3f%n", value);
		}
		
	}
	
	private static void demoFile() {
		String path = "C:\\t\\file.txt";
		
		// File exists?
		File file = new File(path);
		System.out.println("Exists? " + file.exists());
		
		// File size
		long fileSize = file.length();
		System.out.println("File size: " + fileSize);
		
		// Files in a folder:
		File folder = new File("C:\\");
		if (folder.isDirectory()) {
			File[] fileList = folder.listFiles();
			
			System.out.println("Listing files in " + folder.getAbsolutePath());
			for (File subFile : fileList) {
				System.out.println("  sub file: " + subFile.getAbsolutePath());
			}
		}	
	}
	

	
	
	
	
}
