package org.example;

import java.math.BigInteger;

public class Factorial {
  public static void main(String[] args) {
    int number = -8; // Example number
    System.out.println("Factorial of " + number + " is: " + calculateFactorial(number));
  }

  public static BigInteger calculateFactorial(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("Factorial is not defined for negative numbers");
    }
    BigInteger result = BigInteger.ONE;
    for (int i = 1; i <= n; i++) {
      result = result.multiply(BigInteger.valueOf(i));
    }
    return result;
  }
}
