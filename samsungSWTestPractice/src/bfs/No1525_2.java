/**
 * 
 */
package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ginTonic
 * @Title 
 * 2018. 4. 3.
 */
public class No1525_2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	static final int[] dx = {1, -1 ,0, 0};
	static final int[] dy = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[3][3];
		int start = 0;
		//맵그리기
		for(int i=0; i<3; i++) {
			String[] line = br.readLine().split(" ");
			for(int j=0; j<3; j++) {
				int temp = Integer.valueOf(line[j]);
				if(temp==0) {
					temp = 9;
				}
				start = start*10 + temp;
			}
		}
		Queue<Integer> q = new LinkedList<Integer>();
		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
		q.offer(start);
		m.put(start, 0);
		while(!q.isEmpty()) {
			int now_num = q.poll();
			String now = Integer.toString(now_num);
			int indx = now.indexOf('9');
			int nowX = indx/3;
			int nowY = indx%3;
			
			for(int k=0; k<4; k++) {
				int nx = nowX + dx[k];
				int ny = nowY + dy[k];
				
				if(nx>=0 && nx<3 && ny>=0 && ny<3) {
					StringBuilder next = new StringBuilder(now);
					char temp = next.charAt(3*nx + ny);
					next.setCharAt(nowX*3 + nowY, temp);
					next.setCharAt(nx*3 + ny, '9');
					int num = Integer.parseInt(next.toString());
					if(!m.containsKey(num)) {
						m.put(num, m.get(now_num)+1);
						q.add(num);
					}
				}
			}
			
		}
		if(m.containsKey(123456789))
			System.out.println(m.get(123456789));
		else
			System.out.println(-1);
	}

}