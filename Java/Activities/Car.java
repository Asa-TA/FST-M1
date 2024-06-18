package Activities;

public class Car {
	String color ="Balck";
	String Transmission ="Manual";
	int make = 2014;
	int tyre;
	int door;
	
public Car(int tyre, int door) {
		this.tyre= 4;
		this.door= 4;
	}
	
//public Car() {
	//	this.tyre = 4;
		//this.door= 4;
	//}
	

	public void displaychar()
	{
	System.out.println("The color of the car " + color);
	System.out.println("The transmission type of the car " + Transmission);
	System.out.println("The make of the car " + make);
	System.out.println("The number of tyres " + tyre);
	System.out.println("The number of doors " + door);

	}
	public void Acc()
	{
		System.out.println("The car is moving forward ");
		}
	public void Break()
	{
		System.out.println("The car has stopped ");
		}
	}

