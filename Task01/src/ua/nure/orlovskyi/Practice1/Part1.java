package ua.nure.orlovskyi.Practice1;

/**
 * Prints to console Hello, World.
 *
 */
public final class Part1 {
	/**
	 * Private constructor.
	 */
	private Part1() {
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
