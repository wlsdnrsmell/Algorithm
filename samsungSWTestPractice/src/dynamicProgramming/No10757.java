/**
 * 
 */
package dynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author ginTonic
 * @Title 
 * 2018. 3. 21.
 */
public class No10757 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String a = st.nextToken();
		String b = st.nextToken();
		
		char[] A = a.toCharArray();
		char[] B = b.toCharArray();
		
		char[] C = new char[Math.max(A.length, B.length)+1];
		int t = 0;
		int ansIndex = Math.max(A.length, B.length);
		
		for(int i = 1;i<=Math.max(A.length, B.length)+1;i++) {
			if(i<=A.length) t+=A[A.length-i] - '0';
			if(i<=B.length) t+=B[B.length-i] - '0';
			
			C[ansIndex--] = Integer.toString(t%10).charAt(0);
			t = t/10;
		}
		
		for(int i=0;i<C.length;i++) {
			if(i==0&&C[i]=='0');
			else bw.write(C[i]);
		}
		bw.write("\n");
		bw.flush();
	}
}
