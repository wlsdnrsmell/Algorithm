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

public class No10826 {

	/**
	 * @param args
	 */
	static String[] dp = new String[10001];
	static String calc(String s, String s2) {
		char[] A = s.toCharArray();
		char[] B = s2.toCharArray();
		StringBuilder sb = new StringBuilder();
		
		int t=0;
		for(int i=1; i<=Math.max(A.length, B.length)+1;i++) {
			if(i<=A.length) t+=A[A.length - i] -'0';
			if(i<=B.length) t+=B[B.length - i] -'0';
			
			sb.append(t%10);
			
			t/=10;
		}
		int vlen = sb.length();
		int keep;
		sb.reverse();
		for(keep=0; keep<vlen&&sb.charAt(keep)=='0' ;keep++);
		
		sb.delete(0, keep);
		return sb.toString();
	}
	
	static String fibo(int n) {

		if (dp[n] != "-1") return dp[n];

		if (n == 0) {

			dp[n] = "0";
			return dp[n];
		}

		else if (n == 1) {

			dp[n] = "1";
			return dp[n];
		}

		return dp[n] = calc(fibo(n - 1), fibo(n - 2));
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=0; i<dp.length;i++)
			dp[i] = "-1";
		
		fibo(n);
		System.out.println(dp[n]);
	}
	
}
