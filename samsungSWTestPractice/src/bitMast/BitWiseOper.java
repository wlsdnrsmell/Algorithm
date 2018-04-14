package bitMast;

/*
 * @Author : wookTire
 * 
 * @Title : ��Ʈ��������
 */
public class BitWiseOper {

	public static void main(String[] args) {
		int x = 0xAB;		//1010 1011
		int y = 0xF;        //0000 1111
		
		System.out.printf("x = %#X \t%s%n", x, toBinaryString(x));
		System.out.printf("y = %#X \t%s%n", y, toBinaryString(y));
		
		//AND������
		System.out.printf("x & y = %#X \t%s%n", x&y, toBinaryString(x&y));
		//OR������
		System.out.printf("x | y = %#X \t%s%n", x|y, toBinaryString(x|y));
		//XOR������
		System.out.printf("x ^ y = %#X \t%s%n", x^y, toBinaryString(x^y));
		System.out.printf("x^y^y = %#X \t%s%n", x^y^y, toBinaryString(x^y^y));
	}

	//������� 10�� ������ 2������ ��ȯ�� �޼���(������ ������ 32bit[4byte]�̴�. ������ ���� ���� 8bit�� ��� ǥ��)
	private static String toBinaryString(int x) {
		String preBinary = "00000000";
		String tmp = preBinary.concat(Integer.toBinaryString(x));
		return tmp.substring(tmp.length() - 8, tmp.length()-4)+" "+tmp.substring(tmp.length() - 4);
	}
}
