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
public class No11048 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		
		int n = Integer.valueOf(nm[0]);
		int m = Integer.valueOf(nm[1]);
		int[][] a = new int[n][m];
		for(int i=0; i<n; i++) {
			String line = br.readLine().trim();
			StringTokenizer tokenizer = new StringTokenizer(line);
			int j =0;
			while(tokenizer.hasMoreTokens()) {
				a[i][j++] = Integer.valueOf(tokenizer.nextToken());
			}
		}
		
		int[][] d = new int[n][m];
		d[0][0] = a[0][0];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(i==0&&j==0) continue;
				if(i==0&&j!=0)
					d[i][j]= d[i][j-1]+a[i][j];
				else if(i!=0&&j==0)
					d[i][j]= d[i-1][j]+a[i][j];
				else
					d[i][j] = Math.max(d[i-1][j], Math.max(d[i][j-1], d[i-1][j-1]))+a[i][j];
			} 
		}
		
		System.out.println(d[n-1][m-1]);
	}
}
