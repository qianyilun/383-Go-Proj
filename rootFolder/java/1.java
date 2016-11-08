package ca.cmpt213.as1content;

public class Car {
	String make;
	int year;
	
	public Car(String make, int year) {
		this.make = make;
		this.year = year;
	}
	
	String getMake() {
		return make;
	}
	
	int getYear() {
		return year;
	}
	
	public String toString() {
		return "A " + year + ", " + make + "!";
	}
}