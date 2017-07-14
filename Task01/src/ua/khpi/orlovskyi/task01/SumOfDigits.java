package ua.khpi.orlovskyi.task01;

/**
 *
 * Sum of digits of a number.
 *
 */
public final class SumOfDigits {
	/**
	 * Private constructor.
	 */
	private SumOfDigits() {
		throw new UnsupportedOperationException("Unsupported operation.");
	}

	/**
	 * Determining sum of digits of a number.
	 * @param arg the argument.
	 * @return sum of digits of a number.
	 */
    private static Integer calculateSumOfDigits(final String arg) {
        try {
            int sum = 0;
            int number = Integer.parseInt(arg);
            if (number < 0) {
                System.err.printf("Error number %s must be positive!%n", arg);
                return null;
            }
            while (number > 0) {
                sum = sum + number % 10;
                number = number / 10;
            }
            return sum;
        } catch (NumberFormatException e) {
            System.err.println("Error has occurred while parsing arg " + arg);
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
        for (String arg : args) {
            Integer result = calculateSumOfDigits(arg);
            if (result != null) {
                System.out.println(arg + "=" + result);
            }
        }
    }
}


