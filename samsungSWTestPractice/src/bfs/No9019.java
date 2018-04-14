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
 * 2018. 3. 10.
 */
public class No9019 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int org = sc.nextInt(); int des = sc.nextInt();
			int[] dist = new int[10001];
			int[] from = new int[10001];
			String[] how = new String[10001];
			boolean[] c = new boolean[10001];
			dist[org] = 0;
			from[org] = -1;
			c[org] = true;
			
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(org);
			
			while(!q.isEmpty()) {
				int now = q.poll();
				for(int i=1;i<=4;i++) {
					int next = oper(now,i);
					if(c[next]==false) {
						q.add(next);
						c[next]=true;
						dist[next] = dist[now]+1;
						from[next] = now;
						
						if(i==1)
							how[next]="D";
						else if(i==2)
							how[next]="S";
						else if(i==3)
							how[next]="L";
						else if(i==4)
							how[next]="R";
						
						if(des==next) break;
					}
				}
			}
			StringBuilder ans = new StringBuilder();
			while(des!=org) {
				ans.append(how[des]);
				des=from[des];
			}
			System.out.println(ans.reverse());
		}
	}
	public static int oper(Integer a, int oper) {
		int res = 0;

		if(oper==1){
			res = (a*2)%10000;
		}else if(oper==2){
			if(a-1 == -1)
				res = 9999;
			else
				res = a-1;
		}else if(oper==3) {
			res = (a%1000)*10+a/1000;
		}else if(oper==4){
			res = (a/10)+(a%10)*1000;
		}
		return res;
	}
}
