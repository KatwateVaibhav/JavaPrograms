package com.test;

public class Test {

	// 1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz
	public static void main(String[] args) {

		int countForThree = 0, countForFive = 0;

		for (int i = 1; i <= 20; i++) {
			String d = "";

			countForFive++;
			countForThree++;
			if (countForThree == 3) {
				System.out.print("fizz");
				countForThree = 0;
			}
			if (countForFive == 5) {
				System.out.print("buzz");
				countForFive = 0;
			}
			if (d == "") {
				System.out.println(i);
			} else {
				System.out.print(d);
			}

			// divisibleByThree = i % 3;
			// System.out.println(i + " " +divisibleByThree);
			// divisibleByFive = i % 5;
			// System.out.println(i + " " +divisibleByFive);
			/*
			 * if ((divisibleByThree == 0) && (divisibleByFive == 0)) {
			 * System.out.print("fizzbuzz" + " "); } else if (divisibleByThree == 0) {
			 * System.out.print("fizz" + " "); } else if (divisibleByFive == 0) {
			 * System.out.print("buzz" + " "); } else { System.out.print(i + " "); }
			 */

		}

	}

}
