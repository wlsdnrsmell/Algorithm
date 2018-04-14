package bitMast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11723 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(sc.readLine());
		int s = 0;
		int num =0;
		int n = 20;
		String sb = "";
		while(cnt-->0){
			String line = sc.readLine();
			if(line.startsWith("add")) {
				num = Integer.parseInt(line.substring(4));num--;
				s = s | (1<<num);
			}
			else if(line.startsWith("remove")){
				num = Integer.parseInt(line.substring(7));num--;
				s = s & ~(1<<num);	
			}
			else if(line.startsWith("check")) {
				num = Integer.parseInt(line.substring(6));num--;
				int res =s&(1<<num);
				if(res>0){
					sb+=("1"+"\n");
				}
				else{
					sb+=("0"+"\n");
				}
			}
			else if(line.startsWith("toggle")) {
				num = Integer.parseInt(line.substring(7));num--;
				s = s^(1<<num);
			}
			else if(line.startsWith("empty")) {
				s = 0;
			}
			else if(line.startsWith("all")) {
				s = (1<<n)-1;
			}
		}
		sc.close();
		System.out.print(sb);
	}
	
}
