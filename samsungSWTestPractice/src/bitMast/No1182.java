/**
 * 
 */
package bitMast;

import java.util.Scanner;

/**
 * @author jinwook.im
 *
 * 2018. 3. 17.
 */
public class No1182 {

	/**
	 * @param args
	 * @Title 부분집합의 합
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		int[] g = new int[n];
		
		
		for(int i=0;i<n;i++) {
			g[i] = sc.nextInt();
		}
		int ans = 0;
		//모든 부분 집합
		for(int i=1;i<(1<<n);i++) {
			int sum = 0;
			for(int k=0;k<n;k++) {
				if((i&(1<<k))!=0) {
					sum+=g[k];
				}
			}
			if(sum == s) {
				ans+=1;
			}
		}
		System.out.println(ans);
	}

}
