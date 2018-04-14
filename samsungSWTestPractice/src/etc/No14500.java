/**
 * 
 */
package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ginTonic
 * @Title 테트로미노
 * 2018. 4. 5.
 */
public class No14500 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	static int map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		int n = Integer.valueOf(nm[0]);
		int m = Integer.valueOf(nm[1]);
		map = new int[n][m];
		for(int r=0; r<n; r++) {
			String[] line = br.readLine().split(" ");
			for(int c=0; c<m; c++) {
				map[r][c]= Integer.valueOf(line[c]);
			}
		}
		int ans = 0;
		for(int r=0; r<n; r++) {
			for(int c=0; c<m; c++) {
				//----
				if(c+3<m) {
					int temp = map[r][c] + map[r][c+1] + map[r][c+2] + map[r][c+3];
					if(ans < temp) ans = temp;
				}
				if(r+3<n) {
					int temp = map[r][c] + map[r+1][c] + map[r+2][c] + map[r+3][c];
					if(ans < temp) ans = temp;
				}
				//==
				//==
				if(r+1 < n && c+1 < m) {
					int temp = map[r][c] + map[r][c+1] + map[r+1][c] + map[r+1][c+1];
					if(ans < temp) ans = temp;
				}
				// |
				// ====
				if(r+2 < n && c-1 >=0) {
					int temp = map[r][c] + map[r+1][c] + map[r+2][c] + map[r+2][c-1];
					if(ans < temp) ans = temp;
				}
				if(r+2 < n && c+1 < m) {
					int temp = map[r][c] + map[r+1][c] + map[r+2][c] + map[r+2][c+1];
					if(ans < temp) ans = temp;
				}
				if(r+2 < n && c+1 < m) {
					int temp = map[r][c] + map[r][c+1] + map[r+1][c+1] + map[r+2][c+1];
					if(ans < temp) ans = temp;
				}
				if(r+2 < n && c+1 < m) {
					int temp = map[r][c] + map[r][c+1] +map[r+1][c] + map[r+2][c] ;
					if(ans < temp) ans = temp;
				}
				if(r+1 < n && c-2 >=0) {
					int temp = map[r][c] + map[r+1][c] +map[r+1][c-1] + map[r+1][c-2] ;
					if(ans < temp) ans = temp;
				}
				if(r+1 < n && c+2 < m) {
					int temp = map[r][c] + map[r+1][c] +map[r+1][c+1] + map[r+1][c+2] ;
					if(ans < temp) ans = temp;
				}
				if(r+1 < n && c+2 < m) {
					int temp = map[r][c] + map[r][c+1] +map[r][c+2] + map[r+1][c+2] ;
					if(ans < temp) ans = temp;
				}
				if(r+1 < n && c+2 < m) {
					int temp = map[r][c] + map[r][c+1] +map[r][c+2] + map[r+1][c] ;
					if(ans < temp) ans = temp;
				}
				//==
				// ==
				if(r+2 < n && c+1 < m) {
					int temp = map[r][c] + map[r+1][c] +map[r+1][c+1] + map[r+2][c+1] ;
					if(ans < temp) ans = temp;
				}
				if(r+2 < n && c-1>=0) {
					int temp = map[r][c] + map[r+1][c] +map[r+1][c-1] + map[r+2][c-1] ;
					if(ans < temp) ans = temp;
				}
				if(r+1<n && c+1 < m && c-1>=0) {
					int temp = map[r][c] + map[r+1][c] +map[r][c+1] + map[r+1][c-1] ;
					if(ans < temp) ans = temp;
				}
				if(r+1 < n && c+2<m) {
					int temp = map[r][c] + map[r][c+1] +map[r+1][c+1] + map[r+1][c+2] ;
					if(ans < temp) ans = temp;
				}
				// ===
				//  |
				if(r+1 < n && c+2 < m) {
					int temp = map[r][c] + map[r][c+1] +map[r][c+2] + map[r+1][c+1] ;
					if(ans < temp) ans = temp;
				}
				if(r-1 >= 0 && c+2<m) {
					int temp = map[r][c] + map[r][c+1] +map[r][c+2] + map[r-1][c+1] ;
					if(ans < temp) ans = temp;
				}
				if(r-1>=0 && r+1<n && c+1<m) {
					int temp = map[r][c] + map[r][c+1] +map[r-1][c+1] + map[r+1][c+1] ;
					if(ans < temp) ans = temp;
				}
				if(r+2<n && c+1<m) {
					int temp = map[r][c] + map[r+1][c] +map[r+2][c] + map[r+1][c+1] ;
					if(ans < temp) ans = temp;
				}
			}
		}
		System.out.println(ans);
	}
}
