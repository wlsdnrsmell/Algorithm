/**
 * 
 */
package bfs;

import java.util.Scanner;

/**
 * @author jinwook.im
 *
 * 2018. 3. 15.
 */
public class No9663 {
	//protected static boolean map[][] = new boolean[15][15];
	protected static boolean[] check_col = new boolean[40];
	protected static boolean[] check_dig1 = new boolean[40];
	protected static boolean[] check_dig2 = new boolean[40];
	protected static int n;
	static int ans =0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		System.out.println(go(0));
	}
	public static int go(int row) {
		if(row==n) {
			//ans ++;
			return 1;
		}
		int cnt=0;
		for(int col=0;col<n;col++) {
			// | / \ 위, 대각선 방향 놓을수 있는지 확인
			if(check(row, col)) {
				//놓을수 있으면 true
				// / 대각선 방향 
				check_dig1[row+col] = true;
				// \ 대각선방향
				check_dig2[row-col+n]=true;
				// | 수직방향
				check_col[col] = true;
				//map[row][col]= true;
				
				cnt+=go(row+1);
				
				//계산이 끝나면 false로
				check_dig1[row+col] = false;
				check_dig2[row-col+n]=false;
				check_col[col] = false;
				//map[row][col]= false;
			}
		}
		return cnt;
	}
	/**
	 * @param row
	 * @param col
	 * @return
	 */
	private static boolean check(int row, int col) {
		/*//직선
		for(int i=0;i<n;i++) {
			if(i == row) continue;
			if(map[i][col]) {
				return false;
			}
		}
		//왼쪽 위 대각선 \
		int x = row-1;
		int y = col-1;
		while(x>=0&&y>=0) {
			if(map[x][y]==true) {
				return false;
			}
			x-=1;
			y-=1;
		}
		//오른쪽 위 대각선 /
		x = row-1;
		y = col+1;
		while(x>=0&&y<n) {
			if(map[x][y]==true){
				return false;
			}
			x-=1;
			y+=1;
		}*/
		if(check_col[col]) {
			return false;
		}
		if(check_dig1[row+col]) {
			return false;
		}
		if(check_dig2[row-col+n]) {
			return false;
		}
		return true;
	}

}
