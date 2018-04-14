/**
 * 
 */
package swExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ginTonic
 * @Title 톱니바퀴
 * 2018. 3. 25.
 */
public class No4013 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> dq1 = new LinkedList<Integer>();
		Deque<Integer> dq2 = new LinkedList<Integer>();
		Deque<Integer> dq3 = new LinkedList<Integer>();
		Deque<Integer> dq4 = new LinkedList<Integer>();
		
		//초기화
		String str = br.readLine();
		for(int j=0;j<str.length();j++)
			dq1.addLast(str.charAt(j)-'0');
		str = br.readLine();
		for(int j=0;j<str.length();j++)
			dq2.addLast(str.charAt(j)-'0');
		str = br.readLine();
		for(int j=0;j<str.length();j++)
			dq3.addLast(str.charAt(j)-'0');
		str = br.readLine();
		for(int j=0;j<str.length();j++)
			dq4.addLast(str.charAt(j)-'0');
		
		int k = Integer.valueOf(br.readLine());
		while(k-->0) {
			String[] a = br.readLine().split(" ");
			//m - 몇번쨰바퀴, n - 무슨방향(1:시계방향, -1:반시계방향)
			int m = Integer.valueOf(a[0]);
			int n = Integer.valueOf(a[1]);
			boolean flag = false;
			if(n==1) flag= true;
			if(flag){
				if(m==1)
					clockWise(dq1);
				if(m==2)
					clockWise(dq2);
				if(m==3)
					clockWise(dq3);
				if(m==4)
					clockWise(dq4);
			} else {
				if(m==1)
					reClockWise(dq1);
				if(m==2)
					reClockWise(dq2);
				if(m==3)
					reClockWise(dq3);
				if(m==4)
					reClockWise(dq4);
			}
			
			forward(dq1, dq2, dq3, dq4, m, flag);
			backward(dq1, dq2, dq3, dq4, m, flag);
		}
		int sum = 0;
		int q1 = dq1.peekFirst();
		int q2 = dq2.peekFirst();
		int q3 = dq3.peekFirst();
		int q4 = dq4.peekFirst();
		if(q1==0)
			sum+=0;
		else
			sum+=1;
		if(q2==0)
			sum+=0;
		else
			sum+=2;
		if(q3==0)
			sum+=0;
		else
			sum+=4;
		if(q4==0)
			sum+=0;
		else
			sum+=8;
		System.out.println(sum);
	}

	/**
	 * @param dq1
	 * @param dq2
	 * @param dq3
	 * @param dq4
	 * @param m
	 * @param n
	 */
	private static void forward(Deque<Integer> dq1, Deque<Integer> dq2, Deque<Integer> dq3, Deque<Integer> dq4, int m, boolean n) {
		if(m>3) return;
		if(m==1) {
			if(solve(dq1, dq2, n)){
				forward(dq1, dq2, dq3, dq4, m+1, !n);	
			}
		} else if(m==2) {
			if(solve(dq2, dq3, n))
				forward(dq1, dq2, dq3, dq4, m+1, !n);
		} else if(m==3) {
			if(solve(dq3, dq4, n))
				forward(dq1, dq2, dq3, dq4, m+1, !n);
		}
	}
	private static void backward(Deque<Integer> dq1, Deque<Integer> dq2, Deque<Integer> dq3, Deque<Integer> dq4, int m, boolean n) {
		if(m<2) return;
		if(m==2) {
			if(solveB(dq1, dq2, n))
				backward(dq1, dq2, dq3, dq4, m-1, !n);
		} else if(m==3) {
			if(solveB(dq2, dq3, n))
				backward(dq1, dq2, dq3, dq4, m-1, !n);
		} else if(m==4) {
			if(solveB(dq3, dq4, n))
				backward(dq1, dq2, dq3, dq4, m-1, !n);
		}
		
	}
	private static boolean solve(Deque<Integer> dqL, Deque<Integer> dqR, boolean n) {
		Object[] arrL = dqL.toArray();
		Object[] arrR = dqR.toArray();
		int l = 2; int r = 6;
		if(n) {
			if(!arrL[l+1].equals(arrR[r])) {
				reClockWise(dqR);
			} else 
				return false;
		} else {
			if(!arrL[l-1].equals(arrR[r])) {
				clockWise(dqR);
			} else
				return false;
		}
		return true;
	}
	
	private static boolean solveB(Deque<Integer> dqL, Deque<Integer> dqR, boolean n) {
		Object[] arrL = dqL.toArray();
		Object[] arrR = dqR.toArray();
		int l = 2; int r = 6;
		if(n) {
			if(!arrL[l].equals(arrR[r+1])) {
				reClockWise(dqL);
			} else 
				return false;
		} else {
			if(!arrL[l].equals(arrR[r-1])) {
				clockWise(dqL);
			} else
				return false;
		}
		return true;
	}
	@SuppressWarnings("unused")
	private static void clockWise(Deque<Integer> dq) {
		dq.addFirst(dq.removeLast());
	}
	@SuppressWarnings("unused")
	private static void reClockWise(Deque<Integer> dq) {
		dq.addLast(dq.removeFirst());
	}

}
