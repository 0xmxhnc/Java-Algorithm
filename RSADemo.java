package rsa;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class ProducePrime {
	/*
	 * ��ȡ��һ������
	 */
	
	public Integer Prime1() {
		List<Integer> list = new ArrayList<Integer>();// �洢�����ļ���
		for (int i = (int) Math.pow(2, 16); i <= Math.pow(2, 17); i++) {
			boolean num2 = true;// ��ֹ��false����
			for (int m = 2; m < Math.sqrt(i); m++) {
				if (i % m == 0) {
					num2 = false;// ��������
					break;
				} else if (num2) {
					list.add(i);// �洢������������
				}
			}

		}
		Random random = new Random();
		int n = random.nextInt(list.size());
		return list.get(n);

	}

	/*
	 * ��ȡ�ڶ�������
	 */
	
	public int Prime2() {
		int max = (int) Math.pow(2, 22);
		int min = (int) Math.pow(2, 21);
		int temp = 0;
		int num = new Random().nextInt(max - min + 1) + min;// �����ȡָ����Χ�ڵ�����
		if (Odd(num)) {
			boolean flag = true;
			for (int m = 2; m < Math.sqrt(num); m++) {
				if (num % m == 0) {
					flag = false;// ��������
					num = num + 2;
					continue;
				} 
				else if(flag) {
					temp = num;
				}
			}
		}
		else {
			num = num + 1;
			boolean flag = true;
			for (int m = 2; m < Math.sqrt(num); m++) {
				if (num % m == 0) {
					flag = false;// ��������
					num = num + 2;
					continue;
				} 
				else if(flag) {
					temp = num;
				}
			}
		}
		return temp;

	}

	public boolean Odd(int n) {
		boolean flag = true;
		if (n % 2 == 0) {
			flag = false;
			return flag;
		} else {
			return flag;
		}
	}

}

class Division {
	public void divison(int m) {
		int temp = 0;
		int c = 0;
		int[] arr = new int[1000];
		for (int i = 2; i < 1000; i++) {
			boolean flag = true;
			for (int q = 2; q < i; q++) {
				if (i % q == 0) {
					flag = false;// ������������
					break;
				}
			}
			if (flag) {
				arr[temp] = i;// �洢1000���������������Գ�
				temp++;
			}
		}
		System.out.println("�Գ���ʼ:");
		for (int a = 0; a < temp; a++) {
			if (m > arr[a]) {
				int b = m % arr[a];// �Գ�1000���ڵ�����,��������
				c++;
				System.out.println("�Գ���" + c + "��:" + m + " % " + arr[a] + "=" + b);
				System.out.println("�õ�������Ϊ:" + b);
				System.out.println();
				if (c == 168) {
					System.out.println("�Գ�����");
				}
			}
		}
	}
}

class MillerRabin {
	/*
	 * nΪ�������ݣ�t
	 */
	
	public static boolean MillerRabin2(int n, int t) {
		long s = 0;
		for(s = 1; s <= n; s++) {
			if((n - 1) == Math.pow(2, s) * t) {
				if((Math.pow(b, t) % n == 1) || ((Math.pow(b, t) % n) - n) == -1) {
					
				}
			}
		}
	}

}

class EuclideanAlgorithm {
	/*
	 * ��ȡ˽Կd
	 * ŷ�������չ�㷨
	 * ��Կe = 17
	 */
	
	long x, y;
	public long exgcd(long a, long b) {
		if (b == 0) {
			x = 1;
			y = 0;
			return a;
		}
		long r = exgcd(b, a % b);
		long t = y;
		y = x - (a / b) * y;
		x = t;
		return r;
	}
	
	public void XY(long fn, long e) {
		System.out.println("���xΪ:" + x);
		System.out.println("���yΪ:" + y);
		if (y < 0) {
			System.out.println("������ԿdΪ:" + (y + fn));
		}else {
			System.out.println("������ԿdΪ:" + y);
		}
		
	}

}

class MoChongFuPinFang {
	/*
	 * ����
	 * ��������m = 32655����Կe = 17��ģ��n
	 */
	
	String binary;
	long a = 1;
	BigInteger a2 = BigInteger.valueOf(a);

	public BigInteger ChongFuPinFang(long m, long e2, long n) {
		binary = Long.toBinaryString(e2);
		BigInteger a3 = a2;
		BigInteger m2 = BigInteger.valueOf(m);
		BigInteger m3 = m2;
		BigInteger n2 = BigInteger.valueOf(n);
		
		for (int i = binary.length() - 1; i >= 0; i--) {
			if (binary.charAt(i) == '1') {
				a3 = a2.multiply(m2).mod(n2);
				a2 = a3;
				m3 = m2.multiply(m2).mod(n2);
				m2 = m3;
			}else {
				m3 = m2.multiply(m2).mod(n2);
				m2 = m3;
			}
		}
		return a3;	
	}

}

class PinFangChen {
	/*
	 * ����
	 * ����m��˽Կd��ģ��n
	 */
	
	String binary;
	long x = 0, y = 1;
	BigInteger x2 = BigInteger.valueOf(x);
	BigInteger y2 = BigInteger.valueOf(y);
	public BigInteger JieMi(long m, long d, long n) {
		binary = Long.toBinaryString(d);
		BigInteger x3 = x2;
		BigInteger m2 = BigInteger.valueOf(m);
		BigInteger n2 = BigInteger.valueOf(n);
		BigInteger y3 = y2;
		BigInteger c = BigInteger.valueOf(2);
		BigInteger c2 = BigInteger.valueOf(1);
		for(int i = 0; i < binary.length(); i++) {
			x3 = x2.multiply(c);
			x2 = x3;
			y3 = y2.multiply(y2).mod(n2);
			y2 = y3;
			if (binary.charAt(i) == '1') {
				x3 = x2.add(c2);
				x2 = x3;
				y3 = y2.multiply(m2).mod(n2); 
				y2 = y3;
			}
		}
		return y3;
	}

}

public class RSADemo {
	public static void main(String[] args) {
		ProducePrime ProducePrime = new ProducePrime();
		Division Division = new Division();
		EuclideanAlgorithm euclideanAlgorithm = new EuclideanAlgorithm();
		MoChongFuPinFang moChongFuPinFang = new MoChongFuPinFang();
		PinFangChen pinFangChen = new PinFangChen();
		MillerRabin MillerRabin = new MillerRabin();
		Scanner scanner = new Scanner(System.in);
		System.out.println("/****************/");
		System.out.println("RSA�㷨���ܽ���ʵ��");
		System.out.println("/****************/");
		int p = ProducePrime.Prime1();
		System.out.println("�������Ҫ��ĵ�һ������p:" + p);
		int q = ProducePrime.Prime2();
		System.out.println("�������Ҫ��ĵڶ�������q:" + q);
		System.out.println("/****************/");
		long n = (long)p * q;//����Խ�磬ǿ��ת��
		long fn = (long)(p - 1) * (q - 1);
		System.out.println("n=p*q=" + n);
		System.out.println("f(n)=(p-1)*(q-1)=" + fn);
		System.out.println("/****************/");
		Division.divison(p);
		System.out.println("/****************/");
		boolean flag = MillerRabin.MillerRabin2((int) 9, 5);
		System.out.println(flag);
		System.out.println("/****************/");
		System.out.println("�����빫Կe:");
		long e = scanner.nextInt();
		System.out.println("��Կe��fn�����Լ��Ϊ:" + euclideanAlgorithm.exgcd(fn, e));//���Լ��		
		euclideanAlgorithm.XY(fn, e);
		System.out.println("/****************/");
		//��������
		System.out.println("����������m:");
		long m = scanner.nextLong();
		System.out.println("�����빫Կe:");
		long e2 = scanner.nextInt();
		System.out.println("����ܺ������m2Ϊ:" + moChongFuPinFang.ChongFuPinFang(m, e2, n));
		System.out.println("/****************/");
		//��������
		System.out.println("����������m2:");
		long m2 = scanner.nextLong();
		System.out.println("��������Կd:");
		long d2 = scanner.nextLong();
		System.out.println("���ܺ������Ϊ:" + pinFangChen.JieMi(m2, d2, n));

	}
}
