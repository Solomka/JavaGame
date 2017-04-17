package ua.training.javaGame;

import java.util.Scanner;

/**
 * <p>
 * Class that represents Controller and serves user's interaction process
 * </p>
 * 
 * @author Solomka
 *
 */
public class Controller {

	private Model model;
	private View view;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	/**
	 * Handles main user's interaction. Sets model's values rang and random
	 * generated secretValue. Provides user with the possibility to type his
	 * guesses until success with user's informing about it
	 * 
	 */
	public void processUser() {
		Scanner scanner = new Scanner(System.in);

		model.setValuesRange(Constants.MIN_VALUE, Constants.MAX_VALUE);
		model.setSecretValue();

		System.out.println("Secret Value: " + model.getSecretValue());

		view.printMessage(View.WELCOME);

		int val = processIntValueWithScanner(scanner);

		while (!checkUserGuess(val)) {
			saveShowGuessingHistory(val);
			val = processIntValueWithScanner(scanner);
		}

		saveShowGuessingHistory(val);
		view.printMessage(View.WIN);
	}

	/**
	 * Ensures user's int value typing
	 * 
	 * @param sc
	 *            a simple text scanner
	 * @return user's int value
	 */
	private int processIntValueWithScanner(Scanner sc) {
		view.printGameRules(model.getMinValue(), model.getMaxValue());

		while (!sc.hasNextInt()) {
			view.printMessage(View.WRONG_INT_VALUE, View.TRY_AGAIN);
			view.printGameRules(model.getMinValue(), model.getMaxValue());
			sc.next();
		}
		return sc.nextInt();
	}

	/**
	 * Adds user's int value guess to the model prevAttempts List and show the
	 * List to the user
	 * 
	 * @param guess
	 *            user's int value guess
	 */
	private void saveShowGuessingHistory(int guess) {
		model.addPrevAttempt(guess);
		view.printGameStory(model.getPrevAttempts());
	}

	/**
	 * Checks correctness of the user's secretValue prediction. Changes
	 * minValue/maxValue range values according to the user's prediction and
	 * shows the appropriate message as a result of the user's prediction
	 * 
	 * @param guess
	 *            user's int value guess
	 * @return true if user guessed the secretValue and false otherwise
	 */
	private boolean checkUserGuess(int guess) {
		if (guess < model.getMinValue() || guess > model.getMaxValue()) {
			view.printMessage(View.WRONG_INT_RANGE, View.TRY_AGAIN);
			return false;
		} else if (guess < model.getSecretValue()) {
			model.setMinValue(guess + 1);
			view.printMessage(View.LESS_INPUT, View.TRY_AGAIN);
			return false;
		} else if (guess > model.getSecretValue()) {
			model.setMaxValue(guess - 1);
			view.printMessage(View.HIGHER_INPUT, View.TRY_AGAIN);
			return false;
		} else {
			return true;
		}

	}

}
