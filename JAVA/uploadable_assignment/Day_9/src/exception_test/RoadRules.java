package exception_test;

public class RoadRules {
	public static final int MAX_SPEED;
	public static final int MIN_SPEED;
	static {
		MAX_SPEED = 80;
		MIN_SPEED = 40;
	}

	public static void CheckSpeed(int speed) throws SpeedOutOfBoundException {
		if (speed < 40) {
			throw new SpeedOutOfBoundException("Too Slow!!");
		}
		if (speed > 80) {
			throw new SpeedOutOfBoundException("Too Fast!!");
		} else {
			System.out.println("Valid Speed for the lane.");
		}
	}
}
