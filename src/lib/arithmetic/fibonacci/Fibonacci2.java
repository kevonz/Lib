package lib.arithmetic.fibonacci;

import java.util.Scanner;

public class Fibonacci2 {

	/**
	 * 高精度斐波那契
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		do {
			cul(n);
			n = s.nextInt();
		} while (n > 0);// 当n<=0时终止
	}

	private static void cul(int n) {
		BigIntT b = new BigIntT();
		BigIntT a = new BigIntT();
		b.formatBigInt("1");
		a.formatBigInt("2");
		if (n == 1 || n == 2) {
			System.out.println(1);
			return;
		}
		int i = 3;
		for (; i <= n; i++) {
			if (i % 2 > 0)
				b.add(a);
			else
				a.add(b);
		}
		BigIntT t = null;
		if (i % 2 > 0)
			t = b;
		else
			t = a;
		for (int j = t.getPos(); j < 100000; j++)
			System.out.print(t.getBase(j));
		System.out.println();
	}
}

class BigIntT {
	int max = 100000;
	private byte[] base = new byte[max];
	private int pos = max;

	public void formatBigInt(String arr) {
		int l = arr.length();
		if (l == 0)
			return;
		int tmp = l - 1;
		for (int i = max - 1; i >= max - l; i--) {
			base[i] = (byte) (arr.charAt(tmp--) - '0');
			pos--;
		}
	}

	public void add(BigIntT right) {
		int bigger = this.getPos() > right.getPos() ? right.getPos() : this
				.getPos();
		pos = bigger;
		for (int i = max - 1; i >= pos - 2; i--) {
			int t = this.base[i] + right.getBase(i);
			if (t >= 10) {
				this.base[i] = (byte) (t % 10);
				this.base[i - 1] += t / 10;
				if (i - 1 < pos)
					pos = i - 1;
			} else {
				this.base[i] = (byte) t;
			}
		}
	}

	public int getPos() {
		return pos;
	}

	public byte getBase(int index) {
		return base[index];
	}
}