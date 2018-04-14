/**
 * 
 */
package bfs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author ginTonic
 * @Title 부분집합의 합2
 * 2018. 3. 19.
 */
class Descending implements Comparator<Integer> {
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Integer o1, Integer o2) {
		return o2.compareTo(o1);
	}
}
public class No1208 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		ArrayList<Integer> arrUp = new ArrayList<Integer>(41);
		ArrayList<Integer> arrDown = new ArrayList<Integer>(41);
		ArrayList<Integer> UP = new ArrayList<Integer>(40);
		ArrayList<Integer> DOWN = new ArrayList<Integer>(40);
		for(int i=0;i<n;i++) {
			if(i<n/2) {
				arrUp.add(sc.nextInt());
			} else
				arrDown.add(sc.nextInt());
		}

		go(arrUp, UP, 0, 0);
		go(arrDown, DOWN, 0, 0);
		
		Descending descending = new Descending();
		UP.sort(null);
		DOWN.sort(descending);

		int i = 0, j = 0;
		long ans = 0;
		n = UP.size();
		int m = DOWN.size();
		while(i<n && j<m) {
			if(UP.get(i) + DOWN.get(j) == s) {
				long c1 = 1;
				long c2 = 1;
				i+=1;
				j+=1;
				while(i<n && UP.get(i).equals(UP.get(i-1))) {
					c1+=1;
					i+=1;
				}
				while(j<m && DOWN.get(j).equals(DOWN.get(j-1))) {
					c2+=1;
					j+=1;
				}
				ans +=c1*c2;
			} else if(UP.get(i) + DOWN.get(j) < s) {
				i+=1;
			} else {
				j+=1;
			}
		}
		if(s == 0) ans-=1;
		System.out.println(ans);
	}
	static void go(ArrayList<Integer> arr, ArrayList<Integer> resArr, int sum, int idx) {
		if(idx==arr.size())
			resArr.add(sum);
		if(idx<arr.size()) {
			sum+=arr.get(idx);
			go(arr, resArr, sum, idx+1);
			sum-=arr.get(idx);
			go(arr, resArr, sum, idx+1);
		}
	}

}
