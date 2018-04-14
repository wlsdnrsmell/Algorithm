/**
 * 
 */
package dynamicProgramming;

import java.util.Scanner;

/**
 * @author ginTonic
 * @Title 
 * 2018. 3. 27.
 */
public class No2133 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] d = new long[n+1];
		d[0] = 1;
		for(int i = 2; i <= n; i+=2) {
			d[i]+=3*d[i-2];
			for(int j=2 ; 2*j<=i ; j++) {
				d[i]+=2*d[i-2*j];
			}
		}
		System.out.println(d[n]);
	}

}
