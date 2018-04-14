/**
 * 
 */
package bfs;

import java.util.Scanner;

/**
 * @author jinwook.im
 * @Title 1,2,3 합구하기
 * 2018. 3. 15.
 */
public class No9095 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-->0) {
			int n = sc.nextInt();
			int count = 0;

			count = go(0, 0, n);
			
			System.out.println(count);
		}
	}

	static int go(int count, int sum, int goal) {
		if(sum>goal) return 0;
		if(sum==goal) return 1;
		int now = 0;
		for(int i=1;i<=3;i++) {
			now += go(count+1, sum+i, goal);
		}
		
		return now;
	}
}
