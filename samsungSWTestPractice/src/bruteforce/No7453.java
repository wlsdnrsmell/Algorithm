/**
 * 
 */
package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author ginTonic
 * @Title 
 * 2018. 3. 31.
 */
public class No7453 {
	static int upper_bound(int[] a, int val) {
        int left = 0;
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
    static int lower_bound(int[] a, int val) {
        int left = 0;
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
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(bf.readLine());
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        int[] d = new int[n];
        for (int i=0; i<n; i++) {
            String[] line = bf.readLine().split(" ");
            a[i] = Integer.valueOf(line[0]);
            b[i] = Integer.valueOf(line[1]);
            c[i] = Integer.valueOf(line[2]);
            d[i] = Integer.valueOf(line[3]);
        }
        int[] first = new int[n*n];
        int[] second = new int[n*n];
        int p=0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                first[p] = a[i]+b[j];
                second[p] = c[i] + d[j];
                p += 1;
            }
        }
        Arrays.sort(second);
        long ans = 0;
        for (int num : first) {
            int lower = lower_bound(second, -num);
            int upper = upper_bound(second, -num);
            ans += upper - lower;
        }
        System.out.println(ans);
    }
}
