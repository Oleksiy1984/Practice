package ua.khpi.orlovskyi.task01;

/**
 *
 * Sum of two numbers.
 *
 */
public final class Sum {
	/**
	 * Private constructor.
	 */
	private Sum() {
		throw new UnsupportedOperationException("Unsupported operation.");
	}

	/**
	 * Sum of two numbers.
	 *
	 * @param args
	 *            the arguments.
	 * @return sum of two numbers.
	 */
	private static Double sumOfTwoNumbers(final String[] args) {
		try {
			return Double.parseDouble(args[0]) + Double.parseDouble(args[1]);
		} catch (NumberFormatException e) {
			System.err.println("Error has occurred while parsing!");
			return null;
		} catch (ArrayIndexOutOfBoundsException exception) {
			System.err.println(exception);
			return null;
		}
	}

	/**
	 * Entry point of the Java application.
	 *
	 * @param args
	 *            the command line arguments.
	 *
	 */
	public static void main(final String[] args) {
		Double result = sumOfTwoNumbers(args);
		if (result != null) {
			System.out.println(args[0] + "+" + args[1] + "=" + result);
		}
	}
}
