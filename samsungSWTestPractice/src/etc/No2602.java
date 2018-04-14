/**
 * 
 */
package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ginTonic
 * @Title 
 * 2018. 4. 13.
 */
public class No2602 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		String c = br.readLine();

		int k = a.length(); 
		//[몇번째열][해당돌다리를몇번째][몇번째행]
		int d[][][] = new int[101][21][2];
		int n = b.length();
		for(int i=0; i<n; i++) {
			if(b.charAt(i)==a.charAt(0)) d[i][0][0] ++;
			if(c.charAt(i)==a.charAt(0)) d[i][0][1] ++;
		}
		for(int i=0; i<k-1; i++) {
			for(int j=0; j<n; j++) {
				if(a.charAt(i)==b.charAt(j)) {
					for(int x = j+1; x<n; x++) {
						if(a.charAt(i+1)==c.charAt(x))
							d[x][i+1][1] += d[j][i][0];
					}
				}
				if(a.charAt(i)==c.charAt(j)) {
					for(int x = j+1; x<n; x++) {
						if(a.charAt(i+1)==b.charAt(x))
							d[x][i+1][0] += d[j][i][1];
					}
				}
			}
		}
		long ans = 0;
		for(int i=0; i<n; i++) {
			ans+=d[i][k-1][0] + d[i][k-1][1];
		}
		System.out.println(ans);
	}
}
