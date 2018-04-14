package persmutation;

import java.util.Scanner;
//순열의  순서
public class No1722 {

	public static void main(String[] args) {
		String res = "";
		long[] f = new long[21];
		f[0] = 1;
		
		for(int i = 1; i<=20;i++) {
			f[i] = f[i-1] * i;
		}
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		
		String subN = sc.nextLine();
		res = numPermutation(f, n, subN);
		
		System.out.println(res);
	}
	protected static String numPermutation(long[] f,int n, String subN) {
		Long index = (long) 1.0;
		String res = "";
		String[] subProb = subN.substring(2, subN.length()).split(" ");
		boolean[] c = new boolean[21];
		
		//순열의 순서 - index값의 순열
		if(subN.startsWith("1")) {
			Long k = Long.parseLong(subProb[0]);
			for(int i = 0;i< n;i++) {
				for(int j=1;j<=n;j++) {
					if(c[j]==true) continue;
					if(f[n-i-1]<k) {
						k-=f[n-i-1];
					} else {
						res = res + j + " ";
						c[j] = true;
						break;
					}
				}
			}
		} 
		//순열의 순서 - 순열의 index값
		else if(subN.startsWith("2")) {
			for(int i=0;i<n;i++) {
				for(int j =1; j < Integer.parseInt(subProb[i]);j++) {
					if(c[j]==false) {
						index += f[n-i-1];
					}
				}
				c[Integer.parseInt(subProb[i])] = true;
			}
			res = index.toString();
		}
		
		return res;
	}
}