/**
 * 
 */
package etc;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ginTonic
 * @Title 
 * 2018. 3. 28.
 */
public class No14888 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] oper = new int[n-1];
		int[] p = new int[n-1];
		for(int i =0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		for(int i =0; i<n-1; i++) {
			p[i] = i;
		}
		int idx = 0;
		for(int i =0; i<4; i++) {
			int k = sc.nextInt();
			for(int j=0;j<k;j++) {
				oper[idx++] = i;
			}
		}
		ArrayList<Long> arr = new ArrayList<Long>();
		do{
			long res = a[0];
			for(int i=0; i<n-1; i++) {
				res = calc(res, oper[p[i]], a[i+1]);
			}
			arr.add(res);
		}while(next_permutation(p));
		
		arr.sort(null);
		System.out.println(arr.get(arr.size()-1));
		System.out.println(arr.get(0));
	}
	private static boolean next_permutation(int[] p) {
		int n =p.length;
		int i = n-1;
		int j = n-1;
		while(i>0&&p[i]<=p[i-1]) i--;
		if(i<=0) return false;
		while(p[j]<=p[i-1])j--;
		
		int temp = p[i-1];
		p[i-1] = p[j];
		p[j] = temp;
		
		while(i<n) {
			temp = p[i];
			p[i] = p[n-1];
			p[n-1] = temp;
			i++;n--;
		}
		
		return true;
	}
	private static long calc (long a, int oper, long b) {
		long res = 0;
		if(oper == 0)
			res = a+b;
		if(oper==1)
			res = a-b;
		if(oper==2)
			res = a*b;
		if(oper==3) {
			res = a/b;
		}
		return res;
	}

}
