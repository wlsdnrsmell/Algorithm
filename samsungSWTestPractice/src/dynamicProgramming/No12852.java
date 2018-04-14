/**
 * 
 */
package dynamicProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author ginTonic
 * @Title 
 * 2018. 3. 22.
 */
public class No12852 {

	/**
	 * @param args
	 */
	static int[] d;
	static int[] w;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		d = new int[N+1];
		w = new int[N+1];
		Arrays.fill(d, -1);
		
		
		go(N);
		System.out.println(d[N]);
		System.out.print(N+" ");
		while(N!=1) {
			System.out.print(w[N]+" ");
			N = w[N];
		}
	}
	static int go(int n) {
		if(n==1) return 0;
		if(d[n]>0) return d[n];
		d[n] = go(n-1)+1;
		w[n] = n-1;
		if(n%2==0) {
			int temp = go(n/2) + 1;
			if(d[n]>temp) {
				d[n] = temp;
				w[n] = n/2;
			} 
		}
		if(n%3==0) {
			int temp = go(n/3) + 1;
			if(d[n]>temp) {
				d[n] = temp;
				w[n] = n/3;
			}
		}
		return d[n];
	}
}
