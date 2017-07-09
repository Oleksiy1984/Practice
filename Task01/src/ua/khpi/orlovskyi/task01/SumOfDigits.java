package ua.khpi.orlovskyi.task01;

public class SumOfDigits {

    private static Integer calculateSumOfDigits(String arg) {
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

    public static void main(String args[]) {
        for (String arg : args) {
            Integer result = calculateSumOfDigits(arg);
            if (result != null) {
                System.out.println(arg + "=" + result);
            }
        }
    }
}  


