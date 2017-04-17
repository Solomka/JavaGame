package ua.training.javaGame;

import java.util.List;

public class View {

	// Text's constants

	public static String WELCOME = "WELCOME !";

	public static String GAME_RULES = "Enter int number between ";

	public static String WRONG_INT_VALUE = "Wrong int value.";
	public static String WRONG_INT_RANGE = "Your guess is out of range.";
	public static String LESS_INPUT = "Your guess was too low! ";
	public static String HIGHER_INPUT = "Your guess was too high! ";

	public static String TRY_AGAIN = "Try again!";

	public static String WIN = "Congratulations! You guessed the secret value";

	public static String PREVIOUS_ATTEMPTS = "Previous attempts: ";

	public static String LEFT_PARENTHESIS = "[ ";
	public static String RIGHT_PARANTHESIS = " ]";
	public static String COLON = ": ";

	public void printMessage(String... messages) {
		String resultedMessage = generateMessage(messages);
		System.out.println(resultedMessage);
	}

	private String generateMessage(String... messages) {
		StringBuilder builder = new StringBuilder();
		for (String mgs : messages) {
			builder.append(mgs);
		}

		return builder.toString();

	}

	public void printGameStory(List<Integer> prevAttempts) {
		System.out.println(View.PREVIOUS_ATTEMPTS + prevAttempts);

	}

	public void printGameRules(Integer minValue, Integer maxValue) {
		printMessage(View.GAME_RULES, View.LEFT_PARENTHESIS, minValue.toString(), " ",
				maxValue.toString(), View.RIGHT_PARANTHESIS, View.COLON);
	}

}
