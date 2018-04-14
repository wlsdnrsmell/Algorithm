/**
 * 
 */
package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author jinwook.im
 *
 * 2018. 3. 15.
 */
public class No5014 {

	/**
	 * @param args
	 * @Title 스타트링크
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//건물 높이
		int F = sc.nextInt();
		//현재위치
		int S = sc.nextInt();
		//사무실위치
		int G = sc.nextInt();
		//올라가는 층수
		int U = sc.nextInt();
		//내려가는 층수
		int D = sc.nextInt();
		
		int[] d= new int[1000001];
		boolean[] m = new boolean[1000001];
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(S);
		d[S] = 0;
		m[S]=true;
		while(!q.isEmpty()) {
			int now = q.poll();
			if(now == G) break;
			if(now + U <= F && U!=0) {
				if(!m[now+U]) {
					q.offer(now+U);
					d[now+U] = d[now]+1;
					m[now+U] = true;
				}
			}
			if(now - D >= 0 && D!=0) {
				if(!m[now-D]) {
					q.offer(now-D);
					d[now-D] = d[now]+1;
					m[now-D] = true;
				}	
			}
		}
		if(d[G]==0)
			if(S!=G)
				System.out.println("use the stairs");
			else
				System.out.println(d[G]);
		else
			System.out.println(d[G]);
	}
}
