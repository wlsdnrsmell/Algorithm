/**
 * 
 */
package dynamicProgramming;

import java.util.Scanner;

/**
 * @author ginTonic
 * @Title 
 * 2018. 3. 21.
 */
public class No2748 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		long[] m = new long[n+1];
		m[0] = 0;
		m[1] = 1;
		
		System.out.println(fibo(m, n));
	}
	static long fibo(long[] m, int n) {
		if(n<=1) return n;
		else {
			if(m[n]>0) return m[n];
			m[n] = fibo(m, n-1) + fibo(m, n-2);
			return m[n];
		} 
	}
}
