/**
 * 
 */
package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ginTonic
 * @Title 
 * 2018. 3. 23.
 */
public class No2193 {

	/**
	 * @param args
	 */
	static long [] d;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		d = new long[n+1];
		Arrays.fill(d, -1);
		d[0] = 0; d[1] = 1;
		
		go(n);
		
		System.out.println(d[n]);
	}
	static long go(int n) {
		if(n==0||n==1) return d[n];
		if(d[n]>0) return d[n];
		
		if(n>=2) {
			d[n] = go(n-1) + go(n-2);
		}
		return d[n];
	}

}
