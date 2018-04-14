/**
 * 
 */
package bfs;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author jinwook.im
 * @로또
 * 2018. 3. 9.
 */
public class No6603 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int n = sc.nextInt();
			if(n==0) break;
			int[] a = new int[n];
			for(int i=0;i<n;i++) {
				a[i] = sc.nextInt();
			}
			
			int[] b = new int[n];
			Arrays.fill(b, 1);
			for(int i=6;i<n;i++) {
				b[i]=0;
			}
			do {
				for(int i=0;i<n;i++) {
					if(b[i]==1) {
						System.out.print(a[i]+" ");
					}
				}
				System.out.println();
			}while(prev_permutation(b));
			System.out.println();
		}

	}
	static boolean prev_permutation (int[] a) {
		int i=a.length-1;
		while (i>0&&a[i-1]<=a[i]) {
			i--;
		}
		if(i<=0)
			return false;
		int j=a.length-1;
		while(a[j]>=a[i-1]){
			j--;
		}
		int temp = a[i-1];
		a[i-1] = a[j];
		a[j] = temp;
		j=a.length-1;
		while(i<j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;j--;
		}
		return true;
	}
}
