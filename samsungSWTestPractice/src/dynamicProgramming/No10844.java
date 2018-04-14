/**
 * 
 */
package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ginTonic
 * @Title 쉬운계단수
 * 2018. 3. 23.
 */
public class No10844 {

	/**
	 * @param args
	 */
	static long mask =0x3b9aca00;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[][] d = new long[201][10];
		Arrays.fill(d[1], 1);
		long mod = 1000000000;
		int i = 2;
		while(i<=n) {
			for(int j=0;j<=9;j++) {
				if(j==0) d[i][j] = d[i-1][j+1]%mod;
				else if(j==9) d[i][j] = d[i-1][j-1]%mod;
				else d[i][j] = d[i-1][j-1]%mod + d[i-1][j+1]%mod;
			}
			i++;
		}
		long cnt = 0;
		for(int k=1;k<=9;k++){
			cnt+=d[n][k];
		}
			
		System.out.println(cnt%mod);
	}
}
