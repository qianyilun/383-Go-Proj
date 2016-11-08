//package ca.cmpt213.as1content;

/**
 * Demonstrate how to use command line arguments.
 * Execute with:
 * 	java ca.cmpt213.as1content Put your arguments here.
 * @author Brian Fraser
 *
 */
public class DemoArguments {
	public static void main(String[] args) {
		// Print all arguments
		for (String arg : args) {
			System.out.println("Argument: " + arg);
		}
		
//		// String to int:
//		int firstArgValue = Integer.parseInt(args[0]);
//		System.out.println("Arg 0 value: " + firstArgValue);
	}
}
