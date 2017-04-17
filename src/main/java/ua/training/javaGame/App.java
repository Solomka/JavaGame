package ua.training.javaGame;

import java.util.Random;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		Random random = new Random();
		int secretValue = random.nextInt(2) + 1;
		System.out.println("Secret value: "+ secretValue);
	}
}
