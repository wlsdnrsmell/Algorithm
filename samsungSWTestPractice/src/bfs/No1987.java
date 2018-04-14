/**
 * 
 */
package bfs;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author jinwook.im
 * @Title 알파벳
 * 2018. 3. 17.
 */
public class No1987 {

	/**
	 * @param args
	 */
	static int R, C;
	
	static int[] dx = {1, -1, 0 ,0};
	static int[] dy = {0, 0, 1, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt(); C= sc.nextInt();
		Integer[][] map = new Integer[R][C];
		boolean[] t = new boolean[28];
		
		for(int i=0;i<R;i++) {
			char[] s = sc.next().toCharArray();
			for(int j=0;j<s.length;j++) {
				map[i][j] = (int)s[j];
			}
		}
		t[map[0][0]-'A'] = true;
		
		
		System.out.println(go(map, t, 0, 0));
	}
	//전역변수 이용
	/*public static void go(Integer[][] map,boolean[] t, int row, int col, int cnt) {
		if(cnt>ans) ans = cnt;
		for(int k=0; k<4; k++) {
			int nx = row + dx[k];
			int ny = col + dy[k];
			if(nx>=0 && nx < R && ny>=0 && ny<C) {
				if(!t[map[nx][ny]-'A']){
					t[map[nx][ny]-'A']=true;
					go(map, t, nx, ny, cnt+1);
					t[map[nx][ny]-'A']=false;
				}
			}
		}
	}*/
	public static int go(Integer[][] map,boolean[] t, int row, int col) {
		int ans = 0;
		for(int k=0; k<4; k++) {
			int nx = row + dx[k];
			int ny = col + dy[k];
			if(nx>=0 && nx < R && ny>=0 && ny<C) {
				if(!t[map[nx][ny]-'A']){
					t[map[nx][ny]-'A']=true;
					int next = go(map, t, nx, ny);
					if(ans<next) ans = next;
					t[map[nx][ny]-'A']=false;
				}
			}
		}
		return ans + 1;
	}
}
