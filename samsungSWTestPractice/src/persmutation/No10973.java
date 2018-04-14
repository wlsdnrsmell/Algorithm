package persmutation;

import java.util.Scanner;
//이전순열
public class No10973 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++)
			a[i] = sc.nextInt();
		if(!prePermutation(a, n-1)) {
			System.out.print("-1");
		} else {
			for(int i=0;i<n;i++) {
				System.out.println(a[i]+" ");
			}
			System.out.println();
		}
		
	}
	static boolean prePermutation (int[] a, int n) {
		int i=n, j=n;
		while (i>0&&a[i-1]<=a[i]) {
			i--;
		}
		if(i<=0)
			return false;
		
		while(a[j]>=a[i-1]){
			j--;
		}
		int temp = a[i-1];
		a[i-1] = a[j];
		a[j] = temp;
		while(i<n) {
			temp = a[i];
			a[i] = a[n];
			a[n] = temp;
			i++;n--;
		}
		return true;
	}
}
