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
public class No2225_3 {

	/**
	 * @param args
	 */
	static long mod = 1000000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); int k = sc.nextInt();
		long[]d = new long[n+1];
		
		d[0] = 1;
		for(int i=0; i<=k; i++) {
			for(int j=n; j>=0; j--) {
				for(int l=1; l<=j;l++) {
					d[j]+=d[j-l];
					d[j]%=mod;
				}
			}
			
		}
		System.out.println(d[n]);
	}

}
