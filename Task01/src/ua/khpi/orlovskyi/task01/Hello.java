package ua.khpi.orlovskyi.task01;

/**
 * Prints to console Hello, World.
 *
 */
public final class Hello {
	/**
	 * Private constructor.
	 */
	private Hello() {
		throw new UnsupportedOperationException("Unsupported operation.");
	}

	/**
	 * Prints to console Hello, World.
	 */
	private static void printHelloWorld() {
		System.out.println("Hello, World");
	}

	/**
	 * Entry point of the Java application.
	 *
	 * @param args
	 *            the command line arguments.
	 */
	public static void main(final String[] args) {
		printHelloWorld();
	}
}
