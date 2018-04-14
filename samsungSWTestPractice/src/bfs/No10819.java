/**
 * 
 */
package bfs;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author jinwook.im
 *
 * 2018. 3. 8.
 */
public class No10819 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n;i++)
			arr[i]=sc.nextInt();
		Arrays.sort(arr);

		int res = 0;
		int max = 0;
		do {
			res = cal(arr);
			max = Math.max(max, res);
		}while(next_permutation(arr));
		System.out.println(max);
	}
	public static int cal(int[] arr) {
		int sum = 0;
		for(int i=1;i<arr.length;i++) {
			sum +=Math.abs(arr[i]-arr[i-1]);
		}
		return sum;
	}
	public static boolean next_permutation(int[] arr) {
		int i = arr.length - 1;
		while(i>0&&arr[i-1]>=arr[i]) {
			i-=1;
		}
		if(i<=0)
			return false;
		int j=arr.length-1;
		
		while(arr[j]<=arr[i-1]) {
			j-=1;
		}
		
		int temp = arr[j];
		arr[j]=arr[i-1];
		arr[i-1]=temp;
		
		
		
		j = arr.length;
		Arrays.sort(arr, i, j);
        /*while (i < j) {

            temp = arr[i];

            arr[i] = arr[j];

            arr[j] = temp;

            i += 1;

            j -= 1;

        }*/
		return true;
	}
}
