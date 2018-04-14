/**
 * 
 */
package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ginTonic
 * @Title 동전2
 * 2018. 3. 31.
 */
public class No2294 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int [n+1];
		for(int i=1; i<=n; i++) {
			a[i] = sc.nextInt();
		}
		
		int[] d = new int [k+1];
		Arrays.fill(d, -1);
		
		d[0] = 0;
		
		for(int i=1; i<=n; i++) {
			for(int j=0; j<=k; j++) {
				if(j>=a[i] && d[j-a[i]] != -1) {
					if(d[j]==-1 || d[j]>d[j-a[i]]+1)
						d[j] = d[j-a[i]] + 1;
				}
			}
		}
		
		if(d[k]==0)System.out.println("-1");
		else System.out.println(d[k]);
	}

}
