/**
 * 
 */
package swExpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * @author ginTonic
 * @Title 요리사
 * 2018. 4. 12.
 */
public class No4012 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T;
		T=Integer.valueOf(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = Integer.valueOf(br.readLine());
			int a[][] = new int[n][n];
			for(int i=0; i<n; i++) {
				String line[] = br.readLine().split(" ");
				for(int j=0; j<n; j++) {
					a[i][j] = Integer.valueOf(line[j]);
				}
			}
			
			int[] arr = new int[n];
			for(int i=0; i<n/2; i++) {
				arr[i] = 0;
			}
			for(int i=n/2; i<n; i++) {
				arr[i] = 1;
			}
			
			long ans = Integer.MAX_VALUE;
			do {
				int foodA=0;
				int foodB=0;
				for(int i=0; i<n ; i++) {
					for(int j=i+1; j<n; j++) {
						if(arr[i]==arr[j] && arr[i]==0) {
							foodA += a[i][j] + a[j][i];
						} else if(arr[i]==arr[j] && arr[i]==1) {
							foodB += a[i][j] + a[j][i];
						}
					}
				}
				int diff = Math.abs(foodA - foodB);
				if(ans>diff) {
					ans = diff;
				}
			}while(next_permutation(arr));
			bw.write("#"+test_case+" "+ans+"\n");
			bw.flush();
		}
		bw.close();
	}
	private static boolean next_permutation(int[] arr) {
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
