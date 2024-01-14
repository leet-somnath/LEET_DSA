import java.math.BigInteger;

public class BigIntegerr {
    public static void main(String[] args) {
        // Creating BigInteger objects
        BigInteger num1 = new BigInteger("123456789012345678901234567890");
        BigInteger num2 = new BigInteger("987654321098765432109876543210");

        // Basic arithmetic operations
        BigInteger sum = num1.add(num2);
        BigInteger difference = num1.subtract(num2);
        BigInteger product = num1.multiply(num2);
        BigInteger quotient = num1.divide(num2);
        BigInteger remainder = num1.remainder(num2);

        // Power operation
        BigInteger power = num1.pow(2);

        // Comparisons
        int compareResult = num1.compareTo(num2); // Returns -1, 0, or 1

        // Displaying results
        System.out.println("num1: " + num1);
        System.out.println("num2: " + num2);
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Quotient: " + quotient);
        System.out.println("Remainder: " + remainder);
        System.out.println("Power (num1^2): " + power);
        System.out.println("Comparison result: " + compareResult);

        // Other operations
        BigInteger absValue = num1.abs();
        BigInteger negation = num2.negate();

        System.out.println("Absolute value of num1: " + absValue);
        System.out.println("Negation of num2: " + negation);

        // Shift operations
        BigInteger leftShift = num1.shiftLeft(2); // num1 * 2^2
        BigInteger rightShift = num2.shiftRight(3); // num2 / 2^3

        // Bitwise operations
        BigInteger andResult = num1.and(num2);
        BigInteger orResult = num1.or(num2);
        BigInteger xorResult = num1.xor(num2);
        BigInteger notResult = num1.not();

        // GCD (Greatest Common Divisor)
        BigInteger gcdResult = num1.gcd(num2);

        // Modulus inverse
        BigInteger modInverseResult = num1.modInverse(num2);

        // Probable prime test
        boolean isProbablePrime = num1.isProbablePrime(15);

        // Displaying additional results
        System.out.println("Left Shift: " + leftShift);
        System.out.println("Right Shift: " + rightShift);
        System.out.println("AND Result: " + andResult);
        System.out.println("OR Result: " + orResult);
        System.out.println("XOR Result: " + xorResult);
        System.out.println("NOT Result: " + notResult);
        System.out.println("GCD Result: " + gcdResult);
        System.out.println("Modulus Inverse Result: " + modInverseResult);
        System.out.println("Is Probable Prime? " + isProbablePrime);
    }
}
