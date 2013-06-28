package lib.arithmetic.fibonacci;

import java.math.BigInteger;

/*
 快速计算第n个Java程
 */
public class Fibonacci {
	// n为第n个斐波那契数列的数
	public static BigInteger compute(int n) {
		if (n == 1 || n == 2) {
			return BigInteger.ONE;
		}
		BigInteger num1 = BigInteger.ONE;
		BigInteger num2 = BigInteger.ONE;
		BigInteger result = BigInteger.ZERO;
		for (int i = 2; i < n; i++) {
			result = num1.add(num2);
			num2 = num1;
			num1 = result;
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(Fibonacci.compute(1));
		System.out.println(Fibonacci.compute(2));
		System.out.println(Fibonacci.compute(3));
		System.out.println(Fibonacci.compute(4));
		System.out.println(Fibonacci.compute(5));
		System.out.println(Fibonacci.compute(6));
		System.out.println(Fibonacci.compute(7));
		System.out.println(Fibonacci.compute(100));
	}
}
