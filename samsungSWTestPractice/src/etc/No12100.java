/**
 * 
 */
package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Title 2048(easy)
 * 2018. 4. 4.
 * 
 * 4
2 2 2 2
2 2 0 0
0 0 2 2
0 2 0 2
 * 
 * 
 */
public class No12100 {

	static int n;
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		int[][] a = new int[n][n];
		max = 0;
		for(int i=0; i<n; i++) {
			String[] line = br.readLine().split(" ");
			for(int j=0; j<n; j++) {
				a[i][j] = Integer.valueOf(line[j]);
				if(a[i][j]>max)
					max=a[i][j];
			}
		}
		go(0, a);
		System.out.println(max);
	}
	private static void go(int p, int[][] map) {
		if(p==5) return;
		for(int idx=0; idx<4; idx++) {
			int[][] copyMap = new int[n][n];
			for(int i =0; i<n; i++) {
				for(int j=0; j<n ;j++) {
					copyMap[i][j] = map[i][j];
				}
			}
			if(idx==0)
				up(p, copyMap);
			if(idx==1)
				down(p, copyMap);
			if(idx==2)
				left(p, copyMap);
			if(idx==3)
				right(p, copyMap);
		}
	}
	/**
	 * @param k
	 */
	private static void up(int p, int[][] a) {
		for(int j=0; j<n ;j++) {
			for(int i=0; i<n; i++) {
				for(int k=i+1; k<n; k++) {
					int data1 = a[i][j];
					int data2 = a[k][j];
					if(data1==0 && data2!=0) {
						a[i][j] = a[k][j];
						a[k][j] = 0;
					}
					data1 = a[i][j];
					data2 = a[k][j];
					if(data2 == 0 ) continue;
					if(data2 != 0 && data1!=data2) break;
					if(data1 == data2) {
						a[i][j]*=2;
						if(a[i][j]>max)
							max=a[i][j];
						a[k][j] = 0;
					}
					break;
				}
			}
		}
		go(p+1, a);
	}
	private static void down(int p, int[][] a) {
		for(int j=0; j<n ;j++) {
			for(int i=n-1; i>=0; i--) {
				for(int k=i-1; k>=0; k--) {
					int data1 = a[i][j];
					int data2 = a[k][j];
					if(data1==0 && data2!=0) {
						a[i][j] = a[k][j];
						a[k][j] = 0;
					}
					data1 = a[i][j];
					data2 = a[k][j];
					if(data2 == 0 ) continue;
					if(data2 != 0 && data1!=data2) break;
					if(data1 == data2) {
						a[i][j]*=2;
						if(a[i][j]>max)
							max=a[i][j];
						a[k][j] = 0;
					}
					break;
				}
			}
		}
		go(p+1, a);
	}
	private static void left(int p, int[][] a) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n ;j++) {
				for(int k=j+1; k<n; k++) {
					int data1 = a[i][j];
					int data2 = a[i][k];
					if(data1==0 && data2!=0) {
						a[i][j] = a[i][k];
						a[i][k] = 0;
					}
					data1 = a[i][j];
					data2 = a[i][k];
					if(data2 == 0) continue;
					if(data2 != 0 && data1!=data2) break;
					if(data1 == data2) {
						a[i][j]*=2;
						if(a[i][j]>max)
							max=a[i][j];
						a[i][k] = 0;
					}
					break;
				}
			}
		}
		go(p+1, a);
	}
	private static void right(int p, int[][] a) {
		for(int i=0; i<n; i++) {
			for(int j=n-1; j>=0 ;j--) {
				for(int k=j-1; k>=0; k--) {
					int data1 = a[i][j];
					int data2 = a[i][k];
					if(data1==0 && data2!=0) {
						a[i][j] = a[i][k];
						a[i][k] = 0;
					}
					data1 = a[i][j];
					data2 = a[i][k];
					if(data2 == 0 ) continue;
					if(data2 != 0 && data1!=data2) break;
					if(data1 == data2) {
						a[i][j]*=2;
						if(a[i][j]>max)
							max=a[i][j];
						a[i][k] = 0;
					}
					break;
				}
			}
		}
		go(p+1, a);
	}

}
