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
public class No2228 {

	/**
	 * @param args
	 */
	static int min = -32786*101;
	private static int go(int[]a, int[]s, boolean[][]c, int[][]d, int n, int m) {
		// i - n 번째, j - m 구간의정보
		//답을 찾음
		if(m==0) return 0;
		//답이 될 수 없는 상황
		if(n<=0) return min;
		//메모이제이션
		if(c[n][m]) return d[n][m];
		c[n][m] = true;
		//구간에 포함 X
		d[n][m] = go(a,s,c,d,n-1, m);
		for(int i=1; i<=n; i++) {
			//구간에 포함 O
			int temp = go(a,s,c,d,i-2, m-1) + (s[n] - s[i-1]);
			d[n][m] = Math.max(d[n][m], temp);
		}
		
		return d[n][m];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n+1];
		int[] s = new int[n+1];
		for(int i=1; i<=n; i++) {
			a[i] = sc.nextInt();
			s[i] = s[i-1] + a[i];
		}
		int[][]d = new int[n+1][m+1];
		boolean[][]c = new boolean[n+1][m+1];
		System.out.println(go(a, s, c, d, n, m));
	}
}
