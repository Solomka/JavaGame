package ua.training.javaGame;

import java.util.List;

/**
 * <p>
 * Class that represents View. It provides main user interface and displaying of
 * all the user's actions related messages
 * </p>
 * 
 * @author Solomka
 *
 */
public class View {

	// text's constants
	public static String WELCOME = "WELCOME!";

	public static String GAME_RULES = "Enter int number between ";

	public static String WRONG_INT_VALUE = "Wrong int value.";
	public static String WRONG_INT_RANGE = "Your guess is out of range.";
	public static String LESS_INPUT = "Your guess was too low! ";
	public static String HIGHER_INPUT = "Your guess was too high! ";

	public static String TRY_AGAIN = "Try again!";

	public static String WIN = "Congratulations! You guessed the secret value =)";

	public static String PREVIOUS_ATTEMPTS = "Your predictions: ";

	public static String LEFT_PARENTHESIS = "[ ";
	public static String RIGHT_PARANTHESIS = " ]";
	public static String COLON = ": ";
	public static String EMPTY_STR = " ";
	public static String NEW_LINE = "\n";

	/**
	 * Shows constructed message
	 * 
	 * @param messages
	 *            parts of the message (one or many)
	 */
	public void printMessage(String... messages) {
		String resultedMessage = generateMessage(messages);
		System.out.println(resultedMessage);
	}

	/**
	 * Generates one message from its parts (one or many)
	 * 
	 * @param messages
	 *            parts of the message (one or many)
	 * @return constructed message
	 */
	private String generateMessage(String... messages) {
		StringBuilder builder = new StringBuilder();

		for (String mgs : messages) {
			builder.append(mgs);
		}
		return builder.toString();
	}

	/**
	 * Shows up-to-date secretValues search rule
	 * 
	 * @param minValue
	 *            lower range value
	 * @param maxValue
	 *            higher range value
	 */
	public void printGameRules(int minValue, int maxValue) {
		printMessage(View.NEW_LINE, View.GAME_RULES, View.LEFT_PARENTHESIS, Integer.toString(minValue), View.EMPTY_STR,
				Integer.toString(maxValue), View.RIGHT_PARANTHESIS, View.COLON);
	}

	/**
	 * Shows all the user's predictions during the game
	 * 
	 * @param prevAttempts
	 *            List of user's predictions
	 */
	public void printGameStory(List<Integer> prevAttempts) {
		System.out.println(View.PREVIOUS_ATTEMPTS + prevAttempts);
	}
}
