package ua.training.javaGame;

/**
 * Represents test user secretValue predictions
 * 
 * @author Solomka
 *
 */
public enum Prediction {

	TWENTY_FIVE(25), THIRTY_TWO(32), SIXTY_FOUR(64), SEVENTY_TWO(72), FOURTY_SIX(46), FOURTY_FIVE(45), EIGHTY_ONE(81);

	private final int value;

	Prediction(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	/**
	 * Provides Prediction for a given int value
	 * 
	 * @param value
	 *            value describing Prediction
	 * @return Prediction or null if appropriate prediction wasn't found
	 */
	public static Prediction getPredicitonByValue(int value) {
		for (final Prediction pred : Prediction.values()) {
			if (pred.getValue() == value) {
				return pred;
			}
		}
		return null;
	}

}
