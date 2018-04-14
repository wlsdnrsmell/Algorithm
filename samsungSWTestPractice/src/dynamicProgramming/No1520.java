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
 * @Title 내리막길
 * 2018. 3. 30.
 */
public class No1520 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	static int[][]a;
	static int[][]d;
	static int m, n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());
		m = Integer.valueOf(tok.nextToken());
		n = Integer.valueOf(tok.nextToken());
		a = new int[m+2][n+2];
		d = new int[m+2][n+2];
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				d[i][j] = -1;
				a[i][j] = Integer.MAX_VALUE;
			}
		}
		for(int i = 1; i<=m; i++) {
			String[] line = br.readLine().split(" ");
			for(int j = 1; j<=n; j++) {
				a[i][j] = Integer.valueOf(line[j-1]);
			}
		}
		
		/*for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				//상
				if(a[i][j]>a[i-1][j]) {
					d[i-1][j] += d[i][j];
				}
				//하
				if(a[i][j]>a[i+1][j]) {
					d[i+1][j] += d[i][j];
				}
				//좌
				if(a[i][j]>a[i][j-1]) {
					d[i][j-1] += d[i][j];
				}
				//우
				if(a[i][j]>a[i][j+1]) {
					d[i][j+1] += d[i][j];
				}
			}
		}*/
		
		/*for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++)
				System.out.print(d[i][j]+" ");
			System.out.println();
		}*/
		
		System.out.println(solve(1, 1));
	}
	static private int solve (int x, int y) {
		if(x==m && y==n) return 1;
		if(d[x][y]>=0) return d[x][y];
		d[x][y] = 0;
		if(x>0&&x<=m&&y>=1&&y<=n) {
			//상
			
			if(a[x][y]>a[x-1][y]) {
				//;
				d[x][y] += solve(x-1, y);
			}
			//하
			if(a[x][y]>a[x+1][y]) {
				///solve(x+1, y);
				d[x][y] += solve(x+1, y);
			}
			//좌
			if(a[x][y]>a[x][y-1]) {
				//solve(x, y-1);
				d[x][y] += solve(x, y-1);
			}
			//우
			if(a[x][y]>a[x][y+1]) {
				d[x][y] += solve(x, y+1);
			}	
		}
		return d[x][y];
	}
}
