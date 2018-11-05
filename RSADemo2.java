import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class ProducePrime {
	/*
	 * ��ȡ��һ�������ķ���
	 */
	
	public Integer Prime1() {
		List<Integer> list = new ArrayList<Integer>();// �洢�����ļ���
		for (int i = (int) Math.pow(2, 16) + 1; i <= Math.pow(2, 17); i+=2) {// �ж�����
			boolean num2 = true;// ��ֹ��false����
			for (int m = 2; m <= Math.sqrt(i); m++) {// ����Գ�Ч��
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
	 * ��ȡ�ڶ��������ķ���
	 */
	
	public int Prime2() {
		int max = (int) Math.pow(2, 22);
		int min = (int) Math.pow(2, 21);
		int temp = 0;
		int num = new Random().nextInt(max - min + 1) + min;// �����ȡָ����Χ�ڵ�����
		if (Odd(num)) {
			boolean flag = true;
			for (int m = 2; m <= Math.sqrt(num); m++) {// ����Գ�Ч��
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
			for (int m = 2; m <= Math.sqrt(num); m++) {// ����Գ�Ч��
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
		int temp = 1;
		int c = 1;
		int[] arr = new int[1000];
		arr[0] = 2;
		for (int i = 3; i < 1000; i+=2) {// �ж���������
			boolean flag = true;
			for (int q = 2; q <= Math.sqrt(i); q++) {
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
		
		System.out.println("1000���������Գ���ʼ:");
		System.out.println();
		
		for (int a = 0; a < temp; a++) {
			int b = m % arr[a];// �Գ�1000���ڵ�����,��������
			System.out.println("�Գ���" + c + "��:" + m + " % " + arr[a] + "=" + b);
			c++;
			System.out.println("�õ�������Ϊ:" + b);
			System.out.println();
		}
		System.out.println("1000���������Գ�����");
	}
}

class MillerRabin {
	/*
	 * nΪ�������
	 */
	
	public boolean MillerRabin2(int n) {
		int a = new Random().nextInt(n) + 1;
		long s = 1;
		long n2 = n - 1;
		long n3 = n - 1;
		int t = 0, temp = 0;
		boolean flag = true;
		out :
			for(;;) {
			if (n2 % 2 != 0) {
				s = temp;
				break out;
			}else {
				n2 = n2 / 2;
				temp++;
			}
		}
		t = (int) (n3 / Math.pow(2, s));
		int b = (int) Math.pow(a, t);
		for(long i = (long) Math.pow(2,s - 1); i >= 1; i--){
			if((Math.pow(b, i) + 1) % n == 0){
				break;
			}
			if(i == 1){
				if((Math.pow(b, i) - 1) % n == 0){
					break;
				}
				else{
					flag = false;
				}
			}
		}
		return flag;
	}

}

class EuclideanAlgorithm {
	/*
	 * ��ȡ˽Կd�ķ���
	 * ŷ�������չ�㷨
	 * ��Կe = 17
	 */
	
	BigInteger x, y, a, b, t, r;
	public BigInteger exgcd(BigInteger a, BigInteger b) {
		if (b == BigInteger.valueOf(0)) {
			x = BigInteger.valueOf(1);
			y = BigInteger.valueOf(0);
			return a;
		}
		r = exgcd(b, a.mod(b));
		t = x;
		x = y;
		y = t.subtract((a.divide(b)).multiply(y));
		return r;
	}
	
	public void XY(BigInteger fn, BigInteger e) {
		System.out.println("���xΪ:" + x);
		System.out.println("���yΪ:" + y);
		if (y.compareTo(BigInteger.valueOf(0)) < 0) {
			System.out.println("������ԿdΪ:" + (y.add(fn)));
		}else {
			System.out.println("������ԿdΪ:" + y);
		}
		
	}

}

class MoChongFuPingFang {
	/*
	 * ����
	 * �����������m = 32655����Կe = 17��ģ��Ϊn
	 */
	
	String binary;
	long a = 1;
	BigInteger a2 = BigInteger.valueOf(a);

	public BigInteger Encryption(long m, long e2, long n) {
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

class PingFangCheng {
	/*
	 * ����
	 * ����m��˽Կd��ģ��n
	 */
	
	String binary;
	long x = 0, y = 1;
	BigInteger x2 = BigInteger.valueOf(x);
	BigInteger y2 = BigInteger.valueOf(y);
	public BigInteger Decryption(long m, long d, long n) {
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
		MoChongFuPingFang moChongFuPingFang = new MoChongFuPingFang();
		PingFangCheng pingFangCheng = new PingFangCheng();
		MillerRabin MillerRabin = new MillerRabin();
		Scanner scanner = new Scanner(System.in);
		System.out.println("/****************/");
		System.out.println("RSA�㷨���ܽ���ʵ��");
		System.out.println("/****************/");
		int p = 1009;//ProducePrime.Prime1();
		//int p = ProducePrime.Prime1();
		System.out.println("�������Ҫ��ĵ�һ������p:" + p);
		int q = 997;//ProducePrime.Prime2();
		//int q = ProducePrime.Prime2();
		System.out.println("�������Ҫ��ĵڶ�������q:" + q);
		System.out.println("/****************/");
		long n = (long)p * q;//����Խ�磬ǿ��ת��
		long fn = (long)(p - 1) * (q - 1);
		System.out.println("n=p*q=" + n);
		System.out.println("f(n)=(p-1)*(q-1)=" + fn);
		System.out.println("/****************/");
		Division.divison(p);
		System.out.println("/****************/");
		int p2 = (int)p;
		boolean flag = MillerRabin.MillerRabin2(p2);
		System.out.println("Miller-Rabin�㷨����־��Ϊ:" + flag);
		System.out.println("/****************/");
		System.out.println("�����빫Կe:");
		long e = scanner.nextLong();
		BigInteger e3 = BigInteger.valueOf(e);
		BigInteger fn2 = BigInteger.valueOf(fn);
		System.out.println("��Կe��fn�����Լ��Ϊ:" + euclideanAlgorithm.exgcd(fn2, e3));//���Լ��		
		euclideanAlgorithm.XY(fn2, e3);
		System.out.println("/****************/");
		//��������
		System.out.println("���ܿ�ʼ:");
		System.out.println("����������m:");
		long m = scanner.nextLong();
		System.out.println("�����빫Կe:");
		long e2 = scanner.nextLong();
		System.out.println("���ܺ������m2Ϊ:" + moChongFuPingFang.Encryption(m, e2, n));
		System.out.println("/****************/");
		//��������
		System.out.println("���ܿ�ʼ:");
		System.out.println("����������m2:");
		long m2 = scanner.nextLong();
		System.out.println("��������Կd:");
		long d2 = scanner.nextLong();
		System.out.println("���ܺ������Ϊ:" + pingFangCheng.Decryption(m2, d2, n));
	}
}
