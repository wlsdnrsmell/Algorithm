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
 * @Title 
 * 2018. 4. 12.
 */
public class No4008 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T;
		T=Integer.valueOf(br.readLine().trim());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = Integer.valueOf(br.readLine().trim());
			String[] o = br.readLine().split(" ");
			int[] oper = new int[n-1];
			int idx=0;
			for(int i=0; i<4; i++) {
				for(int j=0; j<Integer.valueOf(o[i]); j++) {
					if(i==0) oper[j] = 0;
					else if(i==1) oper[idx+j] = 1;
					else if(i==2) oper[idx+j] = 2;
					else if(i==3) oper[idx+j] = 3;
				}
				idx+=Integer.valueOf(o[i]);
			}
			String[] nums = br.readLine().split(" ");
			int[] num = new int[n];
			for(int i=0; i<n; i++) {
				num[i] = Integer.valueOf(nums[i]);
			}
			long max = Integer.MIN_VALUE;
			long min = Integer.MAX_VALUE;
			do {
				long calc = num[0];
				for(int i=1; i<n; i++) {
					if(oper[i-1]==0) calc+=num[i];
					if(oper[i-1]==1) calc-=num[i];
					if(oper[i-1]==2) calc*=num[i];
					if(oper[i-1]==3) calc/=num[i];
				}
				if(calc<min) min = calc;
				if(calc>max) max = calc;
			}while(next_permutation(oper));
			
			bw.write("#"+test_case+" "+(max-min)+"\n");
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
