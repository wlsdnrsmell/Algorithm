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
public class No1912 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.valueOf(br.readLine());
		int[] d = new int [n];
		int[] a = new int [n];
		String[] str = br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			a[i] = Integer.valueOf(str[i]); 
		}
		
		//1. a[i]를 포함하는 연속합
		//2. a[i]로 다시 시작
		d[0] = a[0];
		for(int i = 1; i < n; i++) {
			d[i] = Math.max(d[i-1]+a[i], a[i]);
		}
		
		int max = d[0];
		for(int i=0; i<n; i++) {
			if(max<d[i])
				max = d[i];
		}
		System.out.println(max);
	}
}
