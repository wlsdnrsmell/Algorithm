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
 * 2018. 3. 28.
 */
public class No2011 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	static int mod = 1000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int[] a = new int[5001];
		int[] d = new int[5001];
		for(int i = 1; i<=line.length();i++) {
			a[i] = line.charAt(i-1) - '0';
		}
		int n = line.length();
		d[0] = 1;
		for(int i=1; i<=n; i++ ) {
			int x = a[i];
			if(1<=x && x<=9) {
				d[i] = (d[i]+d[i-1])%mod;
			}
			if(i==1)continue;
			if(a[i-1]=='0')continue;
			x = (a[i-1]*10) + a[i];
			if(10<=x&&x<=26) {
				d[i] = (d[i]+d[i-2])%mod;
			}
		}
		
		System.out.println(d[n]);
	}

}
