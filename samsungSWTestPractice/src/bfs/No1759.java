/**
 * 
 */
package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author jinwook.im
 * @Title 암호만들기
 * 2018. 3. 15.
 */
public class No1759 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int C = sc.nextInt();
		
		//추측 알파벳
		LinkedList<String> arr = new LinkedList<String>();
		for(int i =0;i<C ;i++) {
			arr.add(sc.next());
		}
		arr.sort(null);
		
		go(L, arr, "", 0);
		
	}
	
	public static void go(int n, LinkedList<String>arr, String password, int i) {
		if(password.length()==n) {
			if(check(password)) {
				System.out.println(password);
			}
			return;
		}
		if(i>=arr.size()) return;
		go(n, arr, password+arr.get(i), i+1);
		go(n, arr, password, i+1);
		
	}

	/**
	 * @param password
	 * @return
	 */
	private static boolean check(String password) {
		int ja = 0;
		int mo = 0;
		
		for(int i =0;i<password.length();i++) {
			char x = password.charAt(i); 
			if(x=='a'||x=='e'||x=='u'||x=='i'||x=='o') {
				mo+=1;
			}
			else
				ja+=1;
			
		}
		return ja>=2&&mo>=1;
	}

}
