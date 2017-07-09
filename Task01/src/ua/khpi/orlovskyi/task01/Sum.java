package ua.khpi.orlovskyi.task01;

public class Sum {

    private static Double sumOfTwoNumbers(String[] args) {
        try {
            return Double.parseDouble(args[0]) + Double.parseDouble(args[1]);
        } catch (NumberFormatException e) {
            System.err.println("Error has occurred while parsing!");
            return null;
        }
        catch(ArrayIndexOutOfBoundsException exception) {
            System.err.println(exception);
            return null;
        }
    }

    public static void main(String args[]) {
        Double result = sumOfTwoNumbers(args);
        if (result != null) {
            System.out.println(args[0] + "+" + args[1] + "=" + result);
        }
    }
}  


