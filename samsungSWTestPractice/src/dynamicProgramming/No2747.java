/**
 * 
 */
package dynamicProgramming;

import java.util.Scanner;

/**
 * @author ginTonic
 * @Title 
 * 2018. 3. 21.
 */
public class No2747 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] fibo = new int[n+1];
		fibo[0] = 0;
		fibo[1] = 1;
		
		for(int i=2;i<=n;i++)
			fibo[i] = fibo[i-1] + fibo[i-2];
		System.out.println(fibo[n]);
	}

}
