/**
 * 
 */
package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author ginTonic
 * @Title 
 * 2018. 3. 29.
 */
public class No1890 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	static int n ;
	static int[][] a;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		a = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			String line = br.readLine().trim();
			StringTokenizer to = new StringTokenizer(line);
			int j = 1;
			while (to.hasMoreTokens()) {
				a[i][j++] = Integer.valueOf(to.nextToken());
			}
		}
		long[][] d = new long[n+1][n+1];
		d[1][1] = 1;
		solve(d, 1, 1);
		/*for(int i=1; i<=n;i++) {
			for(int j=1; j<=n; j++) {
				if(a[i][j]==0) continue;
				if(j+a[i][j]<=n)
					d[i][j+a[i][j]]+=d[i][j];
				if(i+a[i][j]<=n)
					d[i+a[i][j]][j]+=d[i][j];
			}
		}*/
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++)
				System.out.print(d[i][j]+" ");
			System.out.println();
		}
		System.out.println(d[n][n]);
	}
	private static long solve(long[][] d, int x, int y) {
		int dxy = a[x][y];
		if(dxy==0) return d[x][y];
		if(x + dxy<=n&&y<=n) {
			d[x + dxy][y] += 1;
			solve(d, x + dxy, y);
		}
		if(y+dxy<=n&&x<=n) {
			d[x][y + dxy] += 1;
			solve(d, x, y + dxy);
		}
		
		return d[n][n];
	}
}
