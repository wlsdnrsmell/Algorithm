/**
 * 
 */
package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author jinwook.im
 * @Titile 물통
 * 2018. 3. 12.
 */
public class No2251 {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		final int[] from = {0, 0, 1, 1, 2, 2};
		final int[] to = {1, 2, 0, 2, 0, 1};
		Scanner sc = new Scanner(System.in);
		int b[] = new int[3];
		for(int i=0;i<3;i++)
			b[i] = sc.nextInt();
		boolean[][] check = new boolean[201][201];
		boolean[] ans = new boolean[201];
		Queue<Pair> q = new LinkedList<Pair>();
		
		q.offer(new Pair(0, 0));
		check[0][0]=true;
		ans[b[2]]=true;
		int sum = b[2];
		int c = 0;
		while(!q.isEmpty()) {
			int[]cur = new int[3];
			Pair p = q.peek();
			cur[0] = p.first;
			cur[1] = p.second;
			cur[2] = sum - cur[0] - cur[1];
			q.remove();
			
			for(int k=0;k<6;k++) {
				int[]next = {cur[0], cur[1], cur[2]};
				next[to[k]]+=cur[from[k]];
				next[from[k]]=0;
				if(next[to[k]]>=b[to[k]]) {
					next[from[k]] = next[to[k]] - b[to[k]];
					next[to[k]] = b[to[k]];
				}
				if(!check[next[0]][next[1]]) {
					check[next[0]][next[1]] = true;
					q.offer(new Pair(next[0], next[1]));
					if(next[0]==0)
						ans[next[2]] = true;
				}
			}
		}
		
		for(int i=0;i<=b[2];i++) {
			if(ans[i])
				System.out.print(i+" ");
		}
		System.out.println();
	}

}
