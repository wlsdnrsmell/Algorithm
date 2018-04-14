/**
 * 
 */
package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author ginTonic
 * @Title 
 * 2018. 4. 1.
 */
public class NoDescription {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	static final double pi = 3.1416;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Circle[] circle = new Circle[3];
		for(int i=0; i<3; i++) {
			String[] n = br.readLine().split(" ");
			int x = Integer.valueOf(n[0]);
			int y = Integer.valueOf(n[1]);
			int r = Integer.valueOf(n[2]);
			Circle cir = new Circle(x, y, r);
			circle[i] = cir;
		}
		
		double[] thetas = new double[3];
		thetas[0] = theta(circle[0], circle[1]);
		thetas[1] = theta(circle[0], circle[2]);
		thetas[2] = theta(circle[1], circle[2]);
		
		double ans = 0;
		for(int i=0; i<3; i++) {
			System.out.println("thetas"+i+" : "+thetas[i]+" area : "+area(circle[i]));
			ans+=area(circle[i]);
			if(thetas[i]>0) {
				ans -= thetas[i];
			}
		}
		System.out.println(ans);
	}
	
	private static double dist(Circle cir1, Circle cir2) {
		return Math.sqrt(Math.pow((cir1.x - cir2.x), 2) + Math.pow((cir1.y-cir2.y), 2));
	}
	private static double theta (Circle cir1, Circle cir2) {
		double z = (cir1.r + cir2.r) - dist(cir1, cir2);
		if(z>0){
			double h = Math.sqrt(Math.pow(cir1.r, 2) - Math.pow(cir1.r - (z/2), 2));
			double theta = Math.asin(h/cir1.r);
			double area = (pi/2)*Math.pow(cir1.r,2)*theta;
			double tri = ((cir1.r-(z/2)) * h)/2;
			System.out.println(area + "       "+tri);
			return (area - tri)*4;
		}
			
		else return -1;
	}
	private static double area (Circle cir) {
		return pi*Math.pow(cir.r, 2);
	}
}
class Circle {
	int x;
	int y;
	int r;
	Circle(int x, int y, int r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}
}
