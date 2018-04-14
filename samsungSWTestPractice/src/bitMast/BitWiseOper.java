package bitMast;

/*
 * @Author : wookTire
 * 
 * @Title : 비트논리연산자
 */
public class BitWiseOper {

	public static void main(String[] args) {
		int x = 0xAB;		//1010 1011
		int y = 0xF;        //0000 1111
		
		System.out.printf("x = %#X \t%s%n", x, toBinaryString(x));
		System.out.printf("y = %#X \t%s%n", y, toBinaryString(y));
		
		//AND연산자
		System.out.printf("x & y = %#X \t%s%n", x&y, toBinaryString(x&y));
		//OR연산자
		System.out.printf("x | y = %#X \t%s%n", x|y, toBinaryString(x|y));
		//XOR연산자
		System.out.printf("x ^ y = %#X \t%s%n", x^y, toBinaryString(x^y));
		System.out.printf("x^y^y = %#X \t%s%n", x^y^y, toBinaryString(x^y^y));
	}

	//약식으로 10진 정수를 2진수로 변환한 메서드(원래는 정수는 32bit[4byte]이다. 간단한 예를 위해 8bit로 약식 표현)
	private static String toBinaryString(int x) {
		String preBinary = "00000000";
		String tmp = preBinary.concat(Integer.toBinaryString(x));
		return tmp.substring(tmp.length() - 8, tmp.length()-4)+" "+tmp.substring(tmp.length() - 4);
	}
}
