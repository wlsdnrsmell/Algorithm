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
 * 2018. 4. 3.
 */
public class No15486 {

	/**
	 * @param args
	 */
	static int[] T;
	static int[] P;
	static int[] d;
	static int n;
	static int ans = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		T = new int[n+2];
		P = new int[n+2];
		d = new int[n+2];
		for(int i = 1; i<=n; i++) {
			String[] str = br.readLine().split(" ");
			T[i] = Integer.valueOf(str[0]);
			P[i] = d[i] = Integer.valueOf(str[1]);
		}
		/*for(int i=0; i<n; i++) {
			if(i+T[i]<n+1) {
				d[i] = P[i];
				if(d[i]>d[i+T[i]]) {
					max = d[i];
					for(int j=i; j<=n-T[i]; j++) {
						d[j+T[i]] = d[i];
					}
				} 
			}
		}*/ 
		
		for(int i=n; i>=0; i--) {
			if(i+T[i]<=n+1) {
				d[i] = Math.max(d[i] + d[T[i] + i], d[i + 1]); 
			} else
				d[i] = d[i+1];
		}
		
		/* for (int i = n - 1; i >= 0; --i) 
			 P[i] = T[i] + i < n + 1 ? Math.max(P[i] + P[T[i] + i], P[i + 1]) : P[i + 1];
		*/
		//Arrays.sort(d);
		/*for(int i=0; i<n; i++) {
			System.out.print(d[i]+" ");
		}*/
		System.out.println(d[1]);
	}

}
