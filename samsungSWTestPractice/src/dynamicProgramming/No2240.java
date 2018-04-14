/**
 * 
 */
package dynamicProgramming;

import java.util.Scanner;

/**
 * @author ginTonic
 * @Title 
 * 2018. 4. 4.
 */
public class No2240 {

	/**
	 * @param args
	 */
	static int[] a;
	static int[][] d;
	static boolean[][] c;
	static int T;
	static int W;
	private static int go(int n, int m) {
		//정답이 아닐 경우
		if(n==T+1 && m<=W) return 0;
		if(m>W) return 0;
		if(c[n][m]) return d[n][m];
		c[n][m] = true;
		int where = m%2 + 1;

		int cnt = where==a[n]?1:0;
		d[n][m] = go(n+1, m)+cnt;
		
		int temp = go(n+1, m+1)+cnt;
		if(d[n][m]<temp)
			d[n][m] = temp ;
		
		return d[n][m];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt(); W = sc.nextInt();
		a = new int [T+1];
		d = new int [T+1][W+1];
		c = new boolean [T+1][W+1];
		for(int i=1; i<=T; i++) {
			a[i] = sc.nextInt();
		}
		
		System.out.println(Math.max(go(1, 0), go(1, 1)));
	}

}
