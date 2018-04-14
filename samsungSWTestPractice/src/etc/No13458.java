/**
 * 
 */
package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ginTonic
 * @Title 시험 감독
 * 2018. 4. 6.
 */
public class No13458 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int[] a = new int[n];
		String[] line = br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			a[i] = Integer.valueOf(line[i]);
		}
		int b, c;
		String[] bc = br.readLine().split(" ");
		b = Integer.valueOf(bc[0]); c = Integer.valueOf(bc[1]);
		long ans = 0;
		for(int i=0; i<n; i++) {
			//반별 주감독을 제외한 부감독이 맡아야하는 학생 수
			int subAns = 0;
			if(a[i]>b)
				subAns = a[i] - b;
			if(subAns%c>0) ans+=subAns/c+1;
			else ans+=subAns/c;
		}
		
		System.out.println(ans+n);
	}

}
