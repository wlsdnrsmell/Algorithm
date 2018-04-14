/**
 * 
 */
package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

/**
 * @author ginTonic
 * @Title 알고스팟
 * @comment 
 * 벽을 부수지 않는 경우 앞으로 push
 * 벽을 부수는 경우 뒤로 push 
 * @check
 *  check the Pair Class
 * @result
 * M - 10092KB T - 104MS
 * 2018. 3. 19.
 * 2018. 3. 19.
 */
public class No1261_dequeue {

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
		ArrayDeque<Pair> q = new ArrayDeque<Pair>();
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			for(int j=0; j<m; j++) {
				a[i][j] = line.charAt(j) - '0';
				d[i][j] = -1;
			}
		}
		q.offer(new Pair(0, 0));
		d[0][0] = 0;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int x = p.first;
			int y = p.second;
			for(int k=0;k<4;k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if(0<=nx && nx<n && 0<=ny && ny<m) {
					if(d[nx][ny]==-1) {
						if(a[nx][ny]==0) {
							d[nx][ny] = d[x][y];
							q.addFirst(new Pair(nx, ny));
						} else {
							d[nx][ny] = d[x][y] + 1;
							q.addLast(new Pair(nx, ny));
						}
					}
				}
			}
		}
		System.out.println(d[n-1][m-1]);
	}

}