/**
 * 
 */
package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No1261 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		int m = Integer.parseInt(nm[0]), n = Integer.parseInt(nm[1]);
		int dx[] = {0, 0, 1, -1};
		int dy[] = {1, -1, 0, 0};
		int[][] a = new int [n][m];
		int[][] d = new int [n][m];
		Queue<Pair> q = new LinkedList<Pair>();
		Queue<Pair> next_q = new LinkedList<Pair>();
		for(int i=0; i<n; i++) {
			String[] line = br.readLine().split("");
			for(int j=0; j<m; j++) {
				a[i][j] = Integer.parseInt(line[j]);
				d[i][j] = -1;
			}
		}
		q.offer(new Pair(0, 0));
		d[0][0] = 0;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int x = p.first;
			int y = p.second;
			for(int k =0;k<4; k++) {
				int nx = x +dx[k];
				int ny = y +dy[k];
				if(0<=nx && nx<n && 0<=ny && ny<m) {
					if(d[nx][ny]==-1) {
						if(a[nx][ny]==0) {
							d[nx][ny] = d[x][y];
							q.offer(new Pair(nx, ny));
						} else {
							d[nx][ny] = d[x][y] + 1;
							next_q.offer(new Pair(nx, ny));
						}
					}
				}
			}
			if(q.isEmpty()) {
				q = next_q;
				next_q = new LinkedList<Pair>();
			}
		}
		System.out.println(d[n-1][m-1]);
 	}
}
