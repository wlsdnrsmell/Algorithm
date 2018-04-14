/**
 * 
 */
package dynamicProgramming;

import java.util.Scanner;

/**
 * @author ginTonic
 * @Title 이친수
 * 2018. 3. 23.
 */
public class No2193_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[][]d = new long[n+1][2];
		d[0][0] = 0; d[0][1] =0;
		d[1][0] = 0; d[1][1] =1;
		int i = 2;
		while(i<=n) {
			for(int j=0;j<2;j++) {
				if(j==0)
					d[i][0] = d[i-1][0] + d[i-1][1];
				else
					d[i][1] = d[i-1][0];
			}
			i++;
		}
		System.out.println(d[n][0]+d[n][1]);
	}

}
