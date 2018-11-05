import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class ProducePrime {
	/*
	 * 获取第一个素数的方法
	 */
	
	public Integer Prime1() {
		List<Integer> list = new ArrayList<Integer>();// 存储素数的集合
		for (int i = (int) Math.pow(2, 16) + 1; i <= Math.pow(2, 17); i+=2) {// 判断奇数
			boolean num2 = true;// 防止被false覆盖
			for (int m = 2; m <= Math.sqrt(i); m++) {// 提高试除效率
				if (i % m == 0) {
					num2 = false;// 不是素数
					break;
				} else if (num2) {
					list.add(i);// 存储素数到集合中
				}
			}

		}
		Random random = new Random();
		int n = random.nextInt(list.size());
		return list.get(n);

	}

	/*
	 * 获取第二个素数的方法
	 */
	
	public int Prime2() {
		int max = (int) Math.pow(2, 22);
		int min = (int) Math.pow(2, 21);
		int temp = 0;
		int num = new Random().nextInt(max - min + 1) + min;// 随机获取指定范围内的数字
		if (Odd(num)) {
			boolean flag = true;
			for (int m = 2; m <= Math.sqrt(num); m++) {// 提高试除效率
				if (num % m == 0) {
					flag = false;// 不是素数
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
			for (int m = 2; m <= Math.sqrt(num); m++) {// 提高试除效率
				if (num % m == 0) {
					flag = false;// 不是素数
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
		for (int i = 3; i < 1000; i+=2) {// 判断奇数即可
			boolean flag = true;
			for (int q = 2; q <= Math.sqrt(i); q++) {
				if (i % q == 0) {
					flag = false;// 该数不是素数
					break;
				}
			}
			if (flag) {
				arr[temp] = i;// 存储1000以内素数，用于试除
				temp++;
			}
		}
		
		System.out.println("1000以内素数试除开始:");
		System.out.println();
		
		for (int a = 0; a < temp; a++) {
			int b = m % arr[a];// 试除1000以内的素数,保存余数
			System.out.println("试除第" + c + "次:" + m + " % " + arr[a] + "=" + b);
			c++;
			System.out.println("得到的余数为:" + b);
			System.out.println();
		}
		System.out.println("1000以内素数试除结束");
	}
}

class MillerRabin {
	/*
	 * n为检测数据
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
	 * 获取私钥d的方法
	 * 欧几里得扩展算法
	 * 公钥e = 17
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
		System.out.println("解得x为:" + x);
		System.out.println("解得y为:" + y);
		if (y.compareTo(BigInteger.valueOf(0)) < 0) {
			System.out.println("所以密钥d为:" + (y.add(fn)));
		}else {
			System.out.println("所以密钥d为:" + y);
		}
		
	}

}

class MoChongFuPingFang {
	/*
	 * 加密
	 * 输入加密明文m = 32655，公钥e = 17，模数为n
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
	 * 解密
	 * 密文m，私钥d，模数n
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
		System.out.println("RSA算法加密解密实现");
		System.out.println("/****************/");
		int p = 1009;//ProducePrime.Prime1();
		//int p = ProducePrime.Prime1();
		System.out.println("输出满足要求的第一个素数p:" + p);
		int q = 997;//ProducePrime.Prime2();
		//int q = ProducePrime.Prime2();
		System.out.println("输出满足要求的第二个素数q:" + q);
		System.out.println("/****************/");
		long n = (long)p * q;//避免越界，强制转型
		long fn = (long)(p - 1) * (q - 1);
		System.out.println("n=p*q=" + n);
		System.out.println("f(n)=(p-1)*(q-1)=" + fn);
		System.out.println("/****************/");
		Division.divison(p);
		System.out.println("/****************/");
		int p2 = (int)p;
		boolean flag = MillerRabin.MillerRabin2(p2);
		System.out.println("Miller-Rabin算法检测标志符为:" + flag);
		System.out.println("/****************/");
		System.out.println("请输入公钥e:");
		long e = scanner.nextLong();
		BigInteger e3 = BigInteger.valueOf(e);
		BigInteger fn2 = BigInteger.valueOf(fn);
		System.out.println("公钥e与fn的最大公约数为:" + euclideanAlgorithm.exgcd(fn2, e3));//最大公约数		
		euclideanAlgorithm.XY(fn2, e3);
		System.out.println("/****************/");
		//加密明文
		System.out.println("加密开始:");
		System.out.println("请输入明文m:");
		long m = scanner.nextLong();
		System.out.println("请输入公钥e:");
		long e2 = scanner.nextLong();
		System.out.println("加密后的密文m2为:" + moChongFuPingFang.Encryption(m, e2, n));
		System.out.println("/****************/");
		//解密密文
		System.out.println("解密开始:");
		System.out.println("请输入密文m2:");
		long m2 = scanner.nextLong();
		System.out.println("请输入密钥d:");
		long d2 = scanner.nextLong();
		System.out.println("解密后的明文为:" + pingFangCheng.Decryption(m2, d2, n));
	}
}
