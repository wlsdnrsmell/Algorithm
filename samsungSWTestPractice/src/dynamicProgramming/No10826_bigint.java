/**
 * 
 */
package dynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

/**
 * @author ginTonic
 * @Title 
 * 2018. 3. 21.
 */
public class No10826_bigint {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		BigInteger[] fibo = new BigInteger[n + 3];
		
		fibo[0] = BigInteger.ZERO;
		fibo[1] = BigInteger.ONE;
		
		for(int i=2; i<=n; i++) {
			fibo[i] = fibo[i-1].add(fibo[i-2]); 
		}
		bw.write(fibo[n]+"");
		bw.flush();
	}

}
