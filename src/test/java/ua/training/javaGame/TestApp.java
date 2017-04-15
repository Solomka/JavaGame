package ua.training.javaGame;

import org.junit.Assert;
import org.junit.Test;

public class TestApp {

	@Test
	public void testHelloWorld() {
		String str = "Hello world!";
		Assert.assertEquals("Hello world!", str);

		// Assert.assertNotEquals("str", "str"); //false
		// Assert.assertSame("str", "str"); // true

	}

	/**
	 * fail("Error!"); assertTrue("Error!", res == 10); retrun true if true expr
	 * assertFalse("Error!", res == 10); return true if false expr
	 * assertNull()/assertNotNull() assertSame()/assertNoSame()
	 */

}
