/**
 * 
 */
package bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author jinwook.im
 *
 * 2018. 3. 12.
 */
public class No1525 {

	/**
	 * @param args
	 */
	//[0] : 아래이동 [1] : 위로이동 [2] : 오른쪽이동 [3] : 왼쪽이동
	public static final int[] dx = {0, 0, 1, -1};
	public static final int[] dy = {1, -1, 0, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =3;
		int start =0;
		for(int i=0; i<n;i++) {
			for(int j=0;j<n;j++) {
				int temp=sc.nextInt();
				if(temp==0)
					temp = 9;
				//123456789를 위하기 위함
				start = start * 10 +temp;
			}
		}
		Queue<Integer> q = new LinkedList<Integer>();
		Map<Integer, Integer> d = new HashMap<Integer, Integer>();
		d.put(start, 0);
		q.offer(start);
		
		while(!q.isEmpty()) {
			int now_num = q.poll();
			String now = Integer.toString(now_num);
			//0인 부분 찾기
			int z = now.indexOf('9');
			//193/425/678
			//z가 123/456/789 일차배열로 된 2차배열이므로
			//(x,y)는 현재 0의 위치
			int x = z/3;
			int y = z%3;
			//4방향으로 움직임
			for(int k=0;k<4;k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				//0의 위치는 puzzle 공간안에 존재해야한다.
				if(nx>=0&&nx<n&&ny>=0&&ny<n) {
					StringBuilder next = new StringBuilder(now);
					//temp = 0의 값
					char temp = next.charAt(x*3+y);
					//새로 움직이는 칸의 자리와 0의 위치를 변경
					next.setCharAt(x*3+y, next.charAt(nx*3+ny));
					next.setCharAt(nx*3+ny, temp);
					//비교를 위해 숫자로 변경
					int num = Integer.parseInt(next.toString());
					//움직인 일을 하나 추가해주고 큐에 넣어줌
					if(!d.containsKey(num)) {
						d.put(num, d.get(now_num)+1);
						q.add(num);
					}
				}
			}
		}
		if(d.containsKey(123456789))
			System.out.println(d.get(123456789));
		else
			System.out.println(-1);
	}

}
