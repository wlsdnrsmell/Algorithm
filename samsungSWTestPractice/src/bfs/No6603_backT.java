/**
 * 
 */
package bfs;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author jinwook.im
 * @Title 로또(백트레킹 - 재귀함수)
 * 2018. 3. 17.
 */
public class No6603_backT {

	/**
	 * @param args
	 */
	static LinkedList<Integer> lotto = new LinkedList<Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int num = sc.nextInt();
			int[] m = new int[num];
			if(num==0) break;
			for(int i=0;i<num;i++) {
				m[i] = sc.nextInt();
			}
			go(m, 0,0);
			System.out.println();
		}
	}
	public static void go(int[] m, int index, int cnt) {
		//로또의 모든 번호를 찾음
		if(cnt == 6) {
			for(int num : lotto) {
				System.out.print(num +" ");
			}
			System.out.println();
			return;
		}
		int n = m.length;
		if(n==index) return;
		
		lotto.add(m[index]);
		//다음번 숫자를 사용함
		go(m, index+1, cnt+1);
		lotto.pollLast();
		//다음 숫자를 사용하지 않음
		go(m, index+1, cnt);
	}

}
