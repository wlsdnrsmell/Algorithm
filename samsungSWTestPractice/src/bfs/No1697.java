/**
 * 
 */
package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author jinwook.im
 * @Title 숨바꼭질
 * 2018. 3. 9.
 */
public class No1697 {
	static final int MAX = 200000;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] d = new int[MAX];
		boolean[] check = new boolean[MAX];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		
 		while(!q.isEmpty()) {
 			int now = q.peek();
 			q.poll();
 			if(now-1>=0) {
 				if(check[now-1]==false) {
 					q.add(now-1);
 					check[now-1]=true;
 					d[now-1] = d[now]+1;
 				}
 			}
 			if(now+1<MAX) {
 				if(check[now+1]==false) {
 					q.add(now+1);
 					check[now+1]=true;
 					d[now+1] = d[now]+1;
 				}
 			}
 			if(now*2<MAX) {
 				if(check[now*2]==false) {
 					q.add(now*2);
 					check[now*2]=true;
 					d[now*2] = d[now]+1;
 				}
 			}
 			if(now==k) break;
		}
 		System.out.println(d[k]);
	}

}
