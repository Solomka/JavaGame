package ua.training.javaGame;

import java.util.Scanner;

public class Controller {

	private Model model;
	private View view;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	public void processUser() {
		Scanner scanner = new Scanner(System.in);

		model.setValuesRange(Constants.MIN_VALUE, Constants.MAX_VALUE);
		model.generateSecretValue();

		System.out.println("Secret Value: " + model.getSecretValue());

		view.printMessage(View.WELCOME);

		int val = processIntValueWithScanner(scanner);
		while (!checkUserGuess(val)) {
			val = processIntValueWithScanner(scanner);
		}

		view.printMessage(View.WIN);
		view.printGameStory(model.getPrevAttempts());
	}

	private int processIntValueWithScanner(Scanner sc) {
		view.printGameRules(model.getMinValue(), model.getMaxValue());

		while (!sc.hasNextInt()) {
			view.printMessage(View.WRONG_INT_VALUE, View.TRY_AGAIN);
			view.printGameRules(model.getMinValue(), model.getMaxValue());
			sc.next();
		}
		return sc.nextInt();
	}

	private boolean checkUserGuess(int guess) {

		model.addPrevAttempt(guess);

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
		} else if (guess == model.getSecretValue()) {
			System.out.println("Equality");
			return true;
		} else {
			return false;
		}

	}

}
