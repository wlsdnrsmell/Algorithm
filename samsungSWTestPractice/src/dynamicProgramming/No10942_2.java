/**
 * 
 */
package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ginTonic
 * @Title 팰린드롭_BOTTOM_UP
 * 2018. 3. 29.
 */
public class No10942_2 {

	/**
	 * @param args
	 */
	static int[] a;
	static boolean[][] d;
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		a = new int[n+1];
		d = new boolean[n+1][n+1]; 
		String[] temp = br.readLine().split(" ");
		for(int i=1; i<=n ;i++) {
			a[i] = Integer.valueOf(temp[i-1]);
		}
		
		for(int i=1; i<=n; i++) d[i][i] = true;
		for(int i=1; i<=n-1; i++) {
			if(a[i]==a[i+1])
				d[i][i+1] = true;
		}
		for(int k =3; k<=n; k++) {
			for(int i=1; i<=n-k+1; i++) {
				int j = i + k - 1;
				if(a[i]==a[j]&&d[i+1][j-1])
					d[i][j] = true;
			}
		}
		
		int m = Integer.valueOf(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(m-->0) {
			String[] se = br.readLine().split(" ");
			int s = Integer.valueOf(se[0]);
			int e = Integer.valueOf(se[1]);

			if(d[s][e])
				sb.append("1");
			else
				sb.append("0");
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
