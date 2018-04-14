/**
 * 
 */
package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ginTonic
 * @Title 스티커뽑기
 * 2018. 3. 24.
 */
public class No9455 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			int[][] d = new int[n+1][3];
			int[][] A = new int[2][n+1];
			for(int i=0;i<2;i++) {
				String l = br.readLine();
				String[] line =l.split(" ");
				for(int j=0;j<n;j++) {
					A[i][j] = Integer.parseInt(line[j]);
				}
			}
			// 0 : 위아래 다 선택 안함/ 1: 위만 선택 / 2: 아래만선택 
			d[0][0] = 0; d[0][1] = A[0][0]; d[0][2] = A[1][0];
			go(1, n, d, A);
			
			int ans = 0;
			ans = Math.max(d[n][0], Math.max(d[n][1], d[n][2]));
			System.out.println(ans);
		}
	}
	static void go(int i, int n, int[][] d, int[][] A) {
		if(i>n) return;
		d[i][0] = Math.max(d[i-1][0], Math.max(d[i-1][1], d[i-1][2]));
		d[i][1] = Math.max(d[i-1][0], d[i-1][2])+A[0][i];
		d[i][2] = Math.max(d[i-1][0], d[i-1][1])+A[1][i];
		go(i+1, n, d, A);
	}
}
