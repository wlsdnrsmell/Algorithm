/**
 * 
 */
package bfs;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author jinwook.im
 *
 * 2018. 3. 17.
 */
public class No1182_backT {

	/**
	 * @param args
	 */
	static int s ;
	static int ans =0;
	ArrayList<Integer> arr = new ArrayList<Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		s = sc.nextInt();
		int[] g = new int[n];
		
		
		for(int i=0;i<n;i++) {
			g[i] = sc.nextInt();
		}

		solve(g, 0, 0);
		if(s==0) ans-=1;
		System.out.println(ans);
	}
	public static void solve(int[] a, int sum, int idx) {
		if(idx==a.length) {
			if(sum==s)
				ans++;
		}
		if(idx<a.length) {
			sum+=a[idx];
			solve(a, sum, idx+1);
			sum-=a[idx];
			solve(a, sum, idx+1);
		}
	}

}
