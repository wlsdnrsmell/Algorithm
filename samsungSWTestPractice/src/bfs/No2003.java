/**
 * 
 */
package bfs;

import java.util.Scanner;

/**
 * @author jinwook.im
 * @Title 수들의 합2
 * 2018. 3. 17.
 */
public class No2003 {

	/**
	 * @param args
	 */
	static int n, m;
	static int cnt =0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); m = sc.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		int l = 0, r = 0;
		int sum = a[l];
		solve(a, l, r, sum);
		System.out.println(cnt);
		
	}
	public static void solve(int[] arr, int l, int r, int sum) {
		if(sum==m) cnt+=1;
		if(sum > m && r>=l) {
			sum -=arr[l];
			solve(arr, l+1, r, sum);
		} else if(sum <=m&& r<n-1) {
			sum+=arr[r+1];
			solve(arr, l, r+1, sum);
		}
	}

}
