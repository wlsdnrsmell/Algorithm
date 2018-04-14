/**
 * 
 */
package dynamicProgramming;

import java.util.Scanner;

/**
 * @author ginTonic
 * @Title 
 * 2018. 3. 28.
 */
public class No2225_2 {
	/**
	 * @param args
	 */
	static long mod = 1000000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); int k = sc.nextInt();
		long[][] d = new long[k+1][n+1];

		d[0][0] = 1;
		for(int i=1; i<=k; i++) {
			for(int j=0; j<=n; j++) {
				for(int l=0; l<=j; l++) {
					d[i%2][j] += d[1-(i%2)][j-l];
					d[i%2][j]%=mod;
				}
			}
		}
		
		System.out.println(d[k%2][n]);
	}
}
