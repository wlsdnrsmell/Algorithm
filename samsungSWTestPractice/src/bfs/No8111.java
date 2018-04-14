/**
 * 
 */
package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author ginTonic
 * @Title 0과 1
 * 2018. 4. 8.
 */
public class No8111 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int[] from = new int[n];
			int[] how = new int[n];
			int[] dist = new int[n];
			for(int i=0; i<n; i++) {
				from[i] = how[i] = dist[i] = -1;
			}
			Queue<Integer> q = new LinkedList<Integer>();
			q.offer(1);
			dist[1] = 0;
			how[1] = 1;
			while(!q.isEmpty()) {
				int now = q.poll();
				for(int i=0; i<=1; i++) {
					int next = (now*10 + i) % n ;
					if(dist[next] == -1) {
						dist[next] = dist[now] + 1;
						from[next] = now;
						how[next] = i;
						q.add(next);
					}
				}
			}
			if(dist[0] == -1) {
				System.out.println("BRAK");
			}
			else {
				StringBuilder sb = new StringBuilder();
				for(int i=0; i!=-1; i=from[i]) {
					sb.append(Integer.toString(how[i]));
				}
				System.out.println(sb.reverse());
			}
		}
	}

}
