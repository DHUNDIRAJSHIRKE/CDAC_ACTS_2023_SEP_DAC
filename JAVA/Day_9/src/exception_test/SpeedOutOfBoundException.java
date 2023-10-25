package exception_test;
import exception_handling.RoadRules;
public class SpeedOutOfBoundException extends Exception {
	public SpeedOutOfBoundException(int speed) {
		CheckSpeed(speed);
	}
}
