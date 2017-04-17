package ua.training.javaGame;

public class Main {

	public static void main(String[] args) {

		// Initialization
		Model model = new Model();
		View view = new View();
		Controller controller = new Controller(model, view);

		// Start user's interaction
		controller.processUser();
	}
}
