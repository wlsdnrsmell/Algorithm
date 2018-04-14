/**
 * 
 */
package dynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author ginTonic
 * @Title 
 * 2018. 3. 27.
 */
public class No2579 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.valueOf(br.readLine());
		
		int[] a = new int[n+1];
		int[][] d = new int[n+1][3];
		for(int i = 1 ; i <=n ; i++) {
			a[i] = Integer.valueOf(br.readLine());
		}
		br.close();
		d[1][1] = a[1];
		for(int i=2 ; i<=n; i++) {
			d[i][2] = d[i-1][1] + a[i];
			d[i][1] = Math.max(d[i-2][1], d[i-2][2])+a[i];
		}
		
		int ans =Math.max(d[n][1], d[n][2]) ;
		bw.write(String.valueOf(ans));
		bw.flush();
		br.close();
	}

}
