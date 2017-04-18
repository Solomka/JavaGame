package ua.training.javaGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * <p>
 * Class that represents Model and contains information about guessing value range, secretValue and
 * provides methods for their determination and obtaining
 * </p>
 * 
 * @author Solomka
 *
 */
public class Model {

	private int minValue;
	private int maxValue;
	private int secretValue;

	/** the List of all the user's predictions */
	private List<Integer> prevAttempts = new ArrayList<>();

	public void setValuesRange(int minValue, int maxValue) {
		if ((minValue < Constants.MIN_VALUE) || (maxValue > Constants.MAX_VALUE) || (minValue >= maxValue)) {
			throw new IllegalArgumentException("wrong maxValue or/and minValue");
		}

		this.minValue = minValue;
		this.maxValue = maxValue;
	}

	public void setSecretValue() {
		this.secretValue = rand(minValue, maxValue);
	}
	
	/**
	 * Sets secretValue from Enum 
	 */
	public void setEnumSecretValue(){
		this.secretValue = Prediction.EIGHTY_ONE.getValue();
	}	

	public void setPseudoSecretValue() {
		this.secretValue = rand();
	}

	/**
	 * Generates random int value between minValue (inclusive) and maxValue
	 * (inclusive)
	 * 
	 * @param minValue
	 *            lower range value
	 * @param maxValue
	 *            higher range value
	 * @return random int value within determined bounds
	 */
	private int rand(int minValue, int maxValue) {
		return new Random().nextInt((maxValue - minValue) + 1) + minValue;
	}

	/**
	 * Generates pseudorandom int value between 0 (inclusive) and MAX_VALUE
	 * (exclusive)
	 * 
	 * @return pseudorandom int value within 0 and MAX_VALUE (exclusive)
	 */
	private int rand() {
		return new Random().nextInt(Constants.MAX_VALUE);
	}

	/**
	 * Adds user's guess to the user's predictions List
	 * 
	 * @param attempt
	 *            user's int value guess
	 */
	public void addPrevAttempt(Integer attempt) {
		this.prevAttempts.add(attempt);
	}

	public int getMinValue() {
		return minValue;
	}

	public void setMinValue(int minValue) {
		this.minValue = minValue;
	}

	public int getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}

	public int getSecretValue() {
		return secretValue;
	}

	public List<Integer> getPrevAttempts() {
		return prevAttempts;
	}

	@Override
	public String toString() {
		return "Model [minValue=" + minValue + ", maxValue=" + maxValue + ", secretValue=" + secretValue
				+ ", prevAttempts=" + prevAttempts + "]";
	}

}
