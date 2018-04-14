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
 * 2018. 4. 3.
 */
public class No15486_sol {

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
		int[] d2 = new int[n+2];
		int Mdex =n;
		int M=0, M2=0;
		for(int i = 0; i<n; i++) {
			String[] str = br.readLine().split(" ");
			T[i] = Integer.valueOf(str[0]);
			P[i] = Integer.valueOf(str[1]);
		}
		
		for(int i=n-1; i>=0; i--) {
			if(T[i]+i-1>=n+1) d[i] = 0;
			else {
				if(T[i]+i-1<Mdex)d[i]=P[i]+M;
				else d[i]=P[i]+d[T[i]+i];
			}
			if(M<=d[i]) {
				M=d[i];Mdex=i;
			}
			M2=d2[i] = Math.max(M2, d[i]);
		}
		System.out.println(M);
	}

}
