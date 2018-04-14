/**
 * 
 */
package line_coding_test;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class No3 {

    /**
     * Time complexity:
     * Space complexity:
     */
    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine().trim());

            for (int i = 0; i < T; ++i) {
                String word = br.readLine().trim();
                int[] array = new int[word.length()];
                char[] input = word.toCharArray();
                for(int j = 0; j < input.length; j++) {
                    array[j] = (int) input[j];
                }

                String result_word = new String();
                int idx = 0;
                int j = 0;
                while(j <= array.length-1) {
                	int up, lo;
                	System.out.println("앞 : "+array[j]+" 뒤:"+array[j+1]);
                	if(array[j]<=array[j+1]) {
		            	up = upper_bound(array, array[j], idx);
		            	lo = lower_bound(array, array[j], idx);
                	} else {
                		lo = upper_bound(array, array[j], idx);
		            	up = lower_bound(array, array[j], idx);
                	}
                	int count = up - lo;
                    result_word += String.valueOf(count) + (char) array[j];
                    System.out.println(up +" "+lo);
                    idx += up; j+=up;
                }

                System.out.println(result_word);
            }
        }
    }

    static int upper_bound(int[] a, int val, int idx) {
        int left = idx;
        int right = a.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (a[mid] <= val) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    static int lower_bound(int[] a, int val, int idx) {
        int left = idx;
        int right = a.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (a[mid] >= val) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}