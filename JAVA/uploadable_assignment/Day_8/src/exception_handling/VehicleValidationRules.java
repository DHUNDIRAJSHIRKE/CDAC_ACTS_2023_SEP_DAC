package exception_handling;
//package utils;
import java.util.Date;
import exception_handling.SpeedOutOfRangeException;

public class VehicleValidationRules {
	// declare static constants : speed range
	public static final int MIN_SPEED;
	public static final int MAX_SPEED;
	static {
		MIN_SPEED=40;
		MAX_SPEED=80;
	}

//add a static method for speed validation
	public static void validateSpeed(int speed) throws SpeedOutOfRangeException{
		if(speed < MIN_SPEED)
			throw new SpeedOutOfRangeException("Speed too slow");
		if(speed > MAX_SPEED)
			throw new SpeedOutOfRangeException("Speed too fast , FATAL!!!!!!");
		System.out.println("speed within range....");
	}
	/*
	 * public static void DrivingLicenseExpiry(Date DOI) {
	 * 
	 * }
	 */
}
