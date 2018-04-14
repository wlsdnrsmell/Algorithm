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
public class No2579_2 {

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
		int[] d = new int[n+1];
		for(int i = 1 ; i <=n ; i++) {
			a[i] = Integer.valueOf(br.readLine());
		}
		br.close();
		d[1] = a[1];
		d[2] = a[1] + a[2];
		for(int i=3;i<=n;i++) {
			d[i] = Math.max(d[i-3]+a[i]+a[i-1], d[i-2]+a[i]);
		}
		
		bw.write(String.valueOf(d[n]));
		bw.flush();
		br.close();
	}

}
