/**
 * 
 */
package etc;

import java.util.Scanner;

/**
 * @author ginTonic
 * @Title 주사위 굴리기
 * 2018. 4. 5.
 */
public class No14499 {

	/**
	 * @param args
	 */
	static int x, y;
	static int n, m;
	static StringBuilder ans = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); m = sc.nextInt(); 
		x = sc.nextInt(); y = sc.nextInt(); int k = sc.nextInt();
		int[][] map = new int [n][m];
		for(int r=0; r<n; r++) {
			for (int c=0; c<m; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		map[x][y] = 0;
		int[] square = new int[6];
		while(k-->0) {
			//cmd 1 : 동, 2 : 서, 3 : 북, 4 : 남
			int cmd = sc.nextInt();
			switch(cmd) {
				case 1:
					E(map, square);
					break;
				case 2:
					W(map, square);
					break;
				case 3:
					N(map, square);
					break;
				case 4:
					S(map, square);
					break;
			}
		}
		for(int i=0 ;i<ans.toString().length(); i++)
			System.out.println(ans.toString().charAt(i));
	}
	private static void E(int[][] map, int[] square) {
		if(x>=0 && x<n && y>=0 && y+1<m) {
			y+=1;
			int next_num = map[x][y];
			if(next_num == 0) {
				map[x][y] = square[1];
			} else {
				square[1] = next_num;
				map[x][y] = 0;
			}
			ans.append(square[3]);
			//주사위 좌표 변경
			int temp0, temp1, temp2, temp3;
			temp0 = square[0];temp1 = square[1];
			temp2 = square[2];temp3 = square[3];
			square[0] = temp1; square[1] = temp2;
			square[2] = temp3; square[3] = temp0;
		}
		
	}
	private static void W(int[][] map, int[] square) {
		if(x>=0 && x<n && y-1>=0 && y<m) {
			y-=1;
			int next_num = map[x][y];
			if(next_num == 0) {
				map[x][y] = square[3];
			} else {
				square[3] = next_num;
				map[x][y] = 0;
			}
			ans.append(square[1]);
			//주사위 좌표 변경
			int temp0, temp1, temp2, temp3;
			temp0 = square[0];temp1 = square[1];
			temp2 = square[2];temp3 = square[3];
			square[0] = temp3; square[1] = temp0;
			square[2] = temp1; square[3] = temp2;
		}
		
	}
	private static void N(int[][] map, int[] square) {
		if(x-1>=0 && x<n && y>=0 && y<m) {
			x-=1;
			int next_num = map[x][y];
			if(next_num == 0) {
				map[x][y] = square[4];
			} else {
				square[4] = next_num;
				map[x][y] = 0;
			}
			ans.append(square[5]);
			//주사위 좌표 변경
			int temp0, temp4, temp2, temp5;
			temp0 = square[0];temp4 = square[4];
			temp2 = square[2];temp5 = square[5];
			square[0] = temp4; square[4] = temp2;
			square[2] = temp5; square[5] = temp0;
		}
	}
	private static void S(int[][] map, int[] square) {
		if(x>=0 && x+1<n && y>=0 && y<m) {
			x+=1;
			int next_num = map[x][y];
			if(next_num == 0) {
				map[x][y] = square[5];
			} else {
				square[5] = next_num;
				map[x][y] = 0;
			}
			ans.append(square[4]);
			//주사위 좌표 변경
			int temp0, temp4, temp2, temp5;
			temp0 = square[0];temp4 = square[4];
			temp2 = square[2];temp5 = square[5];
			square[0] = temp5; square[4] = temp0;
			square[2] = temp4; square[5] = temp2;
		}
		
	}

}
