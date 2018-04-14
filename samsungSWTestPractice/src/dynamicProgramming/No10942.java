/**
 * 
 */
package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author ginTonic
 * @Title 팰린드롬?
 * 2018. 3. 29.
 */
public class No10942 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	static int[] a;
	static int[][] d;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		a = new int[n+1];
		d = new int[n+1][n+1]; 
		for(int i = 1; i<=n;i++){
			for(int j=1; j<=n;j++)
				d[i][j] = -1;
		}
		String[] temp = br.readLine().split(" ");
		for(int i=1; i<=n ;i++) {
			a[i] = Integer.valueOf(temp[i-1]);
		}
		int m = Integer.valueOf(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(m-->0) {
			String[] se = br.readLine().split(" ");
			int s = Integer.valueOf(se[0]);
			int e = Integer.valueOf(se[1]);
			int res = solve(s, e);
			
			sb.append(res);
			sb.append('\n');
		}
		System.out.println(sb);
	}

	/**
	 * @param s
	 * @param e
	 * @return
	 */
	private static int solve(int s, int e) {
		if(s==e) return 1;
		else if(s+1==e) {
			if(a[s]==a[e])return 1;
			else return 0;
		}
		if(d[s][e]>=0) return d[s][e];
		if(a[s]!=a[e]) return d[s][e] = 0;
		else return d[s][e] = solve(s+1, e-1);
	}

}
