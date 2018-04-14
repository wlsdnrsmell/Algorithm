/**
 * 
 */
package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ginTonic
 * @Title 
 * 2018. 3. 24.
 */
public class No11057 {

	/**
	 * @param args
	 */
	static int mod = 10007;
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		//int n = sc.nextInt();
		
		for(int n=1;n<=1000;n++) {
			long[][] d = new long[n+1][10];
			Arrays.fill(d[1], 1);
			long ans = 0;
			
			go(2, n, d);
			
			for(int i=0;i<10;i++) ans+=d[n][i];
			System.out.println(ans%mod);
		}
	}
	
	static void go(int i, int n, long[][] d) {
		if(i<=n) {
			for(int j=0;j<=9;j++) {
				for(int k=0;k<=j;k++) {
					d[i][j]+=d[i-1][k];
					d[i][j]%=mod;
				}
			}
			go(i+1, n ,d);
		}
	}
}
