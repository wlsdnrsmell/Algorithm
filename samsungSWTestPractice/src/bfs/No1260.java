/**
 * 
 */
package bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author ginTonic
 * @Title 
 * 2018. 4. 3.
 */
public class No1260 {

	/**
	 * @param args
	 */
	static boolean[] d;
	static boolean[][] graph;
	static int n,m,v;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); m = sc.nextInt(); v= sc.nextInt();
		d = new boolean[n+1];
		graph = new boolean[n+1][n+1];
		while(m-->0) {
			int a = sc.nextInt(); int b = sc.nextInt();
			graph[a][b] = graph[b][a] = true;
		}
		
		d[v] = true;
		dfs(v);
		System.out.println();
		bfs(v);
	}
	private static void dfs(int start) {
		System.out.print(start+" ");
		for(int i=1; i<=n; i++) {
			if(graph[start][i] && d[i]==false) {
				d[i] = true;
				dfs(i);
			}
		}
	}
	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0; i<=n; i++) d[i] = false;
		q.offer(start);
		d[start] = true;
		
		while(!q.isEmpty()) {
			int num = q.poll();
			System.out.print(num+" ");
			for(int i=1; i<=n;i++) {
				if(graph[num][i] && d[i]==false) {
					d[i] = true;
					q.add(i);
				}
			}
		}
	}

}
