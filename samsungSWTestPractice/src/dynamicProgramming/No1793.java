/**
 * 
 */
package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author ginTonic
 * @Title 
 * 2018. 3. 22.
 */
public class No1793 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	static BigInteger[] d;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String line = br.readLine();
			if(line==null) break;
			
			int n = Integer.parseInt(line);
			d = new BigInteger[n+3];
			Arrays.fill(d, BigInteger.ZERO);
			d[0]=BigInteger.ONE;d[1] = BigInteger.ONE; d[2] =BigInteger.valueOf(3);
			
			go(n);
			
			System.out.println(d[n].toString());
		}
	}
	static BigInteger go(int n) {
		if(n==1||n==2) return d[n];
		if(!d[n].equals(BigInteger.ZERO)) return d[n];
		
		d[n] = go(n-1).add(go(n-2).add(go(n-2)));
		
		return d[n];
	}
}
