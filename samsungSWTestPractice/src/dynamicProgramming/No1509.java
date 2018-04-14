/**
 * 
 */
package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ginTonic
 * @Title 
 * 2018. 3. 30.
 */
public class No1509 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		int n = str.length();
		int a[] = new int[n+1];
		boolean[][] d = new boolean [n+1][n+1];
		int[] D = new int[n+1];
		for(int i=0; i<n; i++) {
			a[i+1] = Integer.valueOf(str.charAt(i)-'A');
			d[i+1][i+1] = true;
		}
		for(int i=1; i<=n-1; i++)
			if(a[i] == a[i+1])
				d[i][i+1] = true;
		for(int k=3; k<=n;k++) {
			for(int i=1; i<=n-k+1;i++) {
				int j = i+k-1;
				if(a[i]==a[j]&&d[i+1][j-1]) {
					d[i][j] = true;
				}
			}
		}
		D[0] = 0;
		for(int i=1; i<=n; i++) {
			D[i] = -1;
			for(int j=1; j<=i; j++) {
				if(d[j][i]) {
					if(D[i]==-1||D[i]>D[j-1]+1) {
						D[i] = D[j-1] + 1;
					}
				}
			}
		}
		System.out.println(D[n]);
	}
}
