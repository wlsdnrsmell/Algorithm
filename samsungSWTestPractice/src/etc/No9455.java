/**
 * 
 */
package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ginTonic
 * @Title 박스
 * 2018. 3. 25.
 */
public class No9455 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.valueOf(br.readLine());
		while(t-->0) {
			String[] mn = br.readLine().split(" ");
			int m = Integer.valueOf(mn[0]);int n = Integer.valueOf(mn[1]);
			//map
			int[][] a = new int[m][n];
			//cnt for each row
			int[] d = new int[n];
			for(int i=0;i<m;i++) {
				String[] line = br.readLine().split(" ");
				for(int j=0; j<n; j++) {
					a[i][j] = Integer.valueOf(line[j]);
				}
			}
			for(int j=0; j<n;j++) {
				int cntO = 0;
				boolean e = false;
				for(int i=0; i<m; i++) {
					if(!e) {
						if(a[i][j]==1) {
							cntO++;
							e = true;
						}
					} else {
						if(a[i][j]==0) {
							d[j] += cntO;
						} 
						if(i!=m-1) {
							if(a[i][j]==1)
								cntO++;
						}
					}
				}
			}
			int ans = 0;
			for(int i=0;i<n;i++) {
				ans+=d[i];
			}
			System.out.println(ans);
			
			
		}
		
		
	}

}
