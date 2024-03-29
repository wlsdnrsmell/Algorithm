/**
 * 
 */
package etc;

import java.util.Scanner;

/**
 * @author ginTonic
 * @Title 클리보드
 * 2018. 4. 8.
 */
public class No11058 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] d= new long[n + 1];
		d[0] = 1;
		for(int i=1;i<=n-1; i++) {
			long temp = d[i-1] + 1;
			for (int j=1; j<=i-2; j++) {
				if(temp < d[i-j-2] * (j+1)) {
					temp = d[i-j-2] * (j+1);
				}
			}
			d[i] = temp;
		}
		System.out.println(d[n-1]);
	}
}
