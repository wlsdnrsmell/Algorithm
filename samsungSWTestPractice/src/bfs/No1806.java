/**
 * 
 */
package bfs;

import java.util.Scanner;

/**
 * @author jinwook.im
 * @Title 부분합
 * 2018. 3. 18.
 */
public class No1806 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); int s = sc.nextInt();
		int max = n+2;
		int[] arr = new int[n];
		for(int i=0; i<n ;i++) {
			arr[i] = sc.nextInt();
		}
		int l=0, r=0, ans=max, diff=0;
		int sum=arr[l];
		while(l<=r&&r<n-1) {
			if(sum>=s) {
				diff = r - l;
				if(ans>diff)
					ans = diff;
				if(l>r&&l<n) {
					r=l;
					sum = arr[l];
				}else {
					sum-=arr[l];
					l+=1;
				}
			}
			if(sum<s) {
				r+=1;
				sum+=arr[r];
			}
		}
		if(ans<max)
			System.out.println(ans+1);
		else if(ans>=max)
			System.out.println(0);
	}
}
