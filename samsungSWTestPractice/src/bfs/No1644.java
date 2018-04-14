/**
 * 
 */
package bfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author jinwook.im
 * @Title 1644
 * {@link=https://www.acmicpc.net/problem/1644}
 * 2018. 3. 18.
 */
public class No1644 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[] prime = new boolean[n+1];
		List<Integer> p = new ArrayList<Integer>();
		//소수 (에라토스테네스의 체)
		for(int i=2;i<=n;i++) {
			if(!prime[i]) {
				p.add(i);
				for(int j=i*2;j<=n;j+=i) {
					prime[j]=true;
				}
			}
		}
		int l=0,r=0,cnt=0;
		int sum = p.size()==0? 0:p.get(0);
		
		while(l<=r && r<p.size()) {
			if(sum<=n) {
				if(sum==n)
					cnt+=1;
				r+=1;
				if(r<p.size()) {
					sum+=p.get(r);
				}
			} else if(sum>n) {
				sum-=p.get(l++);
			}
		}
		System.out.println(cnt);
	}

}
