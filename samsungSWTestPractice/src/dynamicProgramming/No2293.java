/**
 * 
 */
package dynamicProgramming;

import java.util.Scanner;

/**
 * @author ginTonic
 * @Title 동전
 * 2018. 3. 30.
 */
public class No2293 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int [n+1];
		int[] d = new int [k+1];
		for(int i=1; i<=n; i++) {
			a[i] = sc.nextInt();
		}
		d[0] = 1;
		
		for(int i = 1; i<=n; i++) {
			for(int j=0; j<=k; j++) {	
				if(j>=a[i])
					d[j] += d[j-a[i]];//동전사용
			}
		}
		System.out.println(d[k]);
	}
}
