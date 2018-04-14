/**
 * 
 */
package line_coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author ginTonic
 * @Title 
 * 2018. 3. 31.
 */
public class No1 {

	/**
     * Time complexity:
     * Space complexity:
     */
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int T = Integer.parseInt(br.readLine().trim());

            for (int i = 0; i < T; i ++) {
                final StringTokenizer tokenizer = new StringTokenizer(br.readLine().trim());
                int N = Integer.parseInt(tokenizer.nextToken());
                int K = Integer.parseInt(tokenizer.nextToken());
                int M = Integer.parseInt(tokenizer.nextToken());
                int q = K-M;
                int res = zohap(N, M) * zohap(N, q);
                System.out.println(res);
            }
        }
    }
    static int zohap(int N, int K) {
    	   int bunza;
    	   int bunmo;
    	   int ans;
    	   int temp=1;
    	   for (int i = N; i > N - K; i--) {
    	      temp = temp*i;
    	   }
    	   bunza = temp;
    	   temp = 1;

    	   for (int i = K; i > 0; i--) {
    	      temp = temp*i;
    	   }
    	   bunmo = temp;

    	   ans = bunza / bunmo;

    	   return ans;

    	}
}
