package ua.training.javaGame;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestModel {

	@Test(expected = IllegalArgumentException.class)
	public void testSetValuesRangeMinValueIllegalArgumentException() {
		int wrongMinValue = -1;

		Model model = new Model();
		model.setValuesRange(wrongMinValue, Constants.MAX_VALUE);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetValuesRangeMaxValueIllegalArgumentException() {
		int wrongMaxValue = 101;

		Model model = new Model();
		model.setValuesRange(Constants.MIN_VALUE, wrongMaxValue);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetValuesRangeMinMaxIllegalArgumentException() {
		int wrongMinValue = -1;
		int wrongMaxValue = 101;

		Model model = new Model();
		model.setValuesRange(wrongMinValue, wrongMaxValue);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetValuesRangeMinMaxExchIllegalArgumentException() {
		Model model = new Model();

		model.setValuesRange(Constants.MAX_VALUE, Constants.MIN_VALUE);
	}

	@Test
	public void testSetValuesRange() {
		Model model = new Model();

		model.setValuesRange(Constants.MIN_VALUE, Constants.MAX_VALUE);

		assertTrue("values range setting",
				(model.getMinValue() == Constants.MIN_VALUE) && (model.getMaxValue() == Constants.MAX_VALUE));
	}

	@Test
	public void testSetSecretValueRanchMatching() {
		Model model = new Model();

		model.setValuesRange(Constants.MIN_VALUE, Constants.MAX_VALUE);
		model.setSecretValue();

		assertTrue("Bounds matching",
				(model.getSecretValue() >= Constants.MIN_VALUE) && (model.getSecretValue() <= Constants.MAX_VALUE));
	}

	@Test
	public void testSetPseudoSecretValue() {
		Model model = new Model();

		model.setValuesRange(Constants.MIN_VALUE, Constants.MAX_VALUE);
		model.setPseudoSecretValue();

		assertTrue("Bounds matching", (model.getSecretValue() >= 0) && (model.getSecretValue() < Constants.RAND_MAX));
	}

}
