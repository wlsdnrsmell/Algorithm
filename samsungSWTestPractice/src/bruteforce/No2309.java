/**
 * 
 */
package bruteforce;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author ginTonic
 * @Title 일곱 난쟁이
 * 2018. 3. 29.
 */
public class No2309 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[9];
		int sum = 0;
 		for(int i = 0; i<9;i++) {
			a[i] = sc.nextInt();
			sum+=a[i];
		}
 		int rest = sum - 100;
 		int out1=0, out2=0;
 		for(int i =1; i<9;i++) {
 			for(int j=0; j<i; j++) {
 				if(a[i] + a[j] == (rest)) {
 					out1 = i;out2=j;
 				};
 			}
 		}
 		ArrayList<Integer> arr = new ArrayList<Integer>();
 		for(int k =0;k<9;k++) {
 			if(k==out1 || k==out2)continue;
			arr.add(a[k]);
 		}
 		
 		arr.sort(null);
 		Iterator<Integer> itor = arr.iterator();
 		while(itor.hasNext()) {
 			System.out.println(itor.next());
 		}
	}
}
