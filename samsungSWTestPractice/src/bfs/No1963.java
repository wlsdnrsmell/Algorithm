/**
 * 
 */
package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author jinwook.im
 * @Title 소수의 경로
 * 2018. 3. 10.
 */
public class No1963 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		boolean[] prime = new boolean[10001];
		
		//소수 (에라토스테네스의 체)
		for(int i=2;i<=10000;i++) {
			if(prime[i]==false) {
				for(int j=i*i;j<=10000;j+=i) {
					prime[j]=true;
				}
			}
		}
		for(int i=0;i<=10000;i++) prime[i]= !prime[i];
		
		while(num-->0) {
			int m = sc.nextInt(); int n = sc.nextInt();
			boolean[] c = new boolean[10001];
			int[] d = new int[10001];
			d[m]=0;
			c[m] = true;
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(m);
			while(!q.isEmpty()) {
				int now = q.remove();
				for(int i=0;i<4;i++) {
					for(int j=0;j<=9;j++) {
						int next = change(now, i, j);
						if(next!=-1) {
							if(prime[next]&&c[next]==false) {
								q.add(next);
								d[next] = d[now] + 1;
								c[next] = true;
							}
						}
					}
				}
			}
			System.out.println(d[n]);
		}
	}
	public static int change(Integer a, int i, int j) {
		if(i==0&&j==0) return -1;
		String s = a.toString();
		StringBuilder sb = new StringBuilder(s);
		sb.setCharAt(i, (char)(j+'0'));
		return Integer.parseInt(sb.toString());
	}
	
}
