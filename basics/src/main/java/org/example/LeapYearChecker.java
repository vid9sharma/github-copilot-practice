package org.example;

public class LeapYearChecker {
  public static void main(String[] args) {
    int year = 2024;
    System.out.println(year + " is a leap year? " + isLeapYear(year));
  }

  public static boolean isLeapYear(int year) {
    if (year % 400 == 0) {
      return true;
    } else if (year % 100 == 0) {
      return false;
    } else if (year % 4 == 0) {
      return true;
    } else {
      return false;
    }
  }
}

