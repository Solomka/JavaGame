package ua.training.javaGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {

	private int minValue;
	private int maxValue;
	private int secretValue;

	private List<Integer> prevAttempts = new ArrayList<>();

	public void setValuesRange(int minValue, int maxValue) {
		this.minValue = minValue;
		this.maxValue = maxValue;
	}

	public void generateSecretValue() {
		this.secretValue = rand(minValue, maxValue);
	}
	
	public int rand(int minValue, int maxValue){
		return new Random().nextInt((maxValue - minValue) + 1) + minValue;
		
	}
	
	public int rand(){
		return new Random().nextInt(maxValue);
	}

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

	public void setSecretValue(int secretValue) {
		this.secretValue = secretValue;
	}

	public List<Integer> getPrevAttempts() {
		return prevAttempts;
	}

	public void setPrevAttempts(List<Integer> prevAttempts) {
		this.prevAttempts = prevAttempts;
	}

	@Override
	public String toString() {
		return "Model [minValue=" + minValue + ", maxValue=" + maxValue + ", secretValue=" + secretValue
				+ ", prevAttempts=" + prevAttempts + "]";
	}

}
