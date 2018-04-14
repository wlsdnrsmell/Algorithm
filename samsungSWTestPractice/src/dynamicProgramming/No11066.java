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
 * @Title 파일합치기
 * 2018. 4. 1.
 */
public class No11066 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	static int[][] d;
	static int[] a;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());
		while(T-->0) {
			int k = Integer.valueOf(br.readLine());
			String[] line = br.readLine().split(" ");
			a = new int[k+1];
			d = new int[k+1][k+1];
			for(int i=1; i<=k;i++) {
				a[i] = Integer.valueOf(line[i-1]);
				Arrays.fill(d[i], -1);
			}
			System.out.println(go(1, k));
		}
		
		
	}
	/**
	 * @param i
	 * @param k
	 * @return
	 */
	private static int go(int i, int j) {
		if(i==j) return 0;
		
		if(d[i][j]!=-1) {
			return d[i][j];
		}
		
		int ans = -1;
		int sum = 0;
		for(int k=i; k<=j;k++) {
			sum+=a[k];
		}
		for(int k=i; k<=j-1; k++) {
			int temp = go(i, k) + go(k+1, j) +sum;
			if(ans == -1 || ans>temp) {
				ans = temp;
			}
		}
		d[i][j] = ans;
		return ans;
	}
}
