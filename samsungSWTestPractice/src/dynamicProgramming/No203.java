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
public class No203 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		
		while(t-->0) {
			int n = sc.nextInt();
			long[] d = new long[101];
			d[0] = 0; d[1] =1; d[2] = 1;
			for(int i=3; i<=n; i++) {
				d[i] = d[i-2] + d[i-3];
			}
			System.out.println(d[n]);	
		}
		
	}

}
