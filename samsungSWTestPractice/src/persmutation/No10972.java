package persmutation;

import java.util.Scanner;
//다음순열
public class No10972 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String res ="";
		int[] permutation = new int[n];
		
		for(int i=0; i<n;i++)
			permutation[i] = sc.nextInt();
		if(nextPermutation(permutation)) {
			for(int i=0;i<permutation.length;i++) {
				res=res+permutation[i]+" ";
			}
		} else {
			res = "-1";
		}
		System.out.println(res);
	}
    static boolean nextPermutation(int[] arr) {
		int n = arr.length;
    	int i = n - 1;
		int j = n - 1;
		int tmp = 0;
		while(i>0&&arr[i]<=arr[i-1]) i--;
		if(i<=0) return false;
		while(arr[j]<=arr[i-1])j--;
		tmp = arr[i-1];
		arr[i-1] = arr[j];
		arr[j] = tmp;
		sort(arr, i, n-1);
		
		return true;
	}
    static void sort(int[] data, int l, int r){
        int left = l;
        int right = r;
        int pivot = data[(l+r)/2];
        
        do{
            while(data[left] < pivot) left++;
            while(data[right] > pivot) right--;
            if(left <= right){    
                int temp = data[left];
                data[left] = data[right];
                data[right] = temp;
                left++;
                right--;
            }
        }while (left <= right);
        
        if(l < right) sort(data, l, right);
        if(r > left) sort(data, left, r);
    }
}
