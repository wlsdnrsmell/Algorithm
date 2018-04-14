/**
 * 
 */
package bfs;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ginTonic
 * @Title 조세퍼스 문제2
 * 2018. 3. 30.
 */
public class No1168 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		ArrayList<Integer> ll = new ArrayList<Integer>();
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=n; i++)
			ll.add(i);
		sb.append("<");
		int idx = 0;
		while(ll.size()>1) {
			idx = (idx+m-1)%(ll.size());
			sb.append(ll.remove(idx)+", ");
		}
		sb.append(ll.remove(0)+">");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	} 

}
