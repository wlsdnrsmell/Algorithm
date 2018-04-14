/**
 * 
 */
package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author ginTonic
 * @Title 
 * 2018. 4. 4.
 */
public class No11049 {
	static int[][] a;
	static int[][] d;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		d = new int[n][n];
		a = new int[n][2];
		for(int i=0; i<n; i++) {
			String[] line = br.readLine().split(" ");
			a[i][0] = Integer.valueOf(line[0]);
			a[i][1] = Integer.valueOf(line[1]);
			Arrays.fill(d[i], -1);
		}
		
		System.out.println(solve(0, n-1));
	}
	
	private static int solve(int i, int j) {
		//메모이제이션
		if(d[i][j]>0) return d[i][j];
		//불가능한 경우
		//정답을 찾은 경우
		if(i==j) return 0;
		//다음 상태를 만드는 경우
		if(i+1==j) {
			return a[i][0]*a[i][1]*a[j][1];
		}
		for(int k=i; k<j; k++) {
			int t1 = solve(i, k);
			int t2 = solve(k+1, j);
			int t3 = a[i][0]*a[k][1]*a[j][1];
			if(d[i][j]==-1 || d[i][j]>t1+t2+t3) {
				d[i][j] = t1+t2+t3;
			}
		}
		return d[i][j];
	}
}
