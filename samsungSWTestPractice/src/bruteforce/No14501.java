/**
 * 
 */
package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author ginTonic
 * @Title 퇴사
 * 2018. 4. 2.
 */
public class No14501 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
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
			P[i] = Integer.valueOf(str[1]);
		}
		go(1, 0);
		System.out.println(ans);
	}
	static void go(int day, int sum) {
		if(day == n+1) {
			if(ans<sum) ans = sum;
			return;
		}
		if(day>n) return;
		go(day+1, sum);
		go(day+T[day], sum+P[day]);
		
	}

}
