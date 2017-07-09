package ua.khpi.orlovskyi.task01;

public class Gcd {

    private static Integer calculateGreatestCommonDivisor(String[] args) {
        try {
            Integer a = Integer.parseInt(args[0]);
            Integer b = Integer.parseInt(args[1]);
            if((a<0)||(b<0)||(a+b==0)){
                System.err.println("Numbers must be positive and sum not equal zero!");
                return null;
            } else {
                while (a != 0 && b != 0) {
                    int c = b;
                    b = a % b;
                    a = c;
                }
                return a + b;
            }

        } catch (NumberFormatException e) {
            System.err.println("Error has occurred while parsing!");
            return null;
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.err.println(exception);
            return null;
        }
    }

    public static void main(String args[]) {
        Integer result = calculateGreatestCommonDivisor(args);
        if (result != null) {
            System.out.println(result);
        }
    }
}  


