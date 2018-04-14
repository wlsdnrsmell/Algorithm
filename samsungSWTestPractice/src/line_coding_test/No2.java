/**
 * 
 */
package line_coding_test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @author ginTonic
 * @Title 
 * 2018. 3. 31.
 */
public class No2 {

	/**
     * Time complexity:
     * Space complexity:
     */
    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokens = new StringTokenizer(br.readLine().trim());
            int userX = Integer.parseInt(tokens.nextToken());
            int userY = Integer.parseInt(tokens.nextToken());
            int shopCount = Integer.parseInt(tokens.nextToken());
            ArrayList<Store> stores = new ArrayList<Store>();
            User user = new User(userX, userY);
            for (int i = 0; i < shopCount; i++) {
                tokens = new StringTokenizer(br.readLine().trim());
                int shopX = Integer.parseInt(tokens.nextToken());
                int shopY = Integer.parseInt(tokens.nextToken());
                String name = tokens.nextToken();
                int coupon = Integer.parseInt(tokens.nextToken());
                Store store = new Store(shopX, shopY, name, coupon, user);
                stores.add(store);
            }
            Solve sol = new Solve();
            stores.sort(sol);
            for(int i=0; i<stores.size(); i++) {
            	System.out.println(stores.get(i).toString());
            }
        }	
    }
}
class Solve implements Comparator<Store> {
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Store o1, Store o2) {
		if(o2.getDist()-o1.getDist()>0)
			return -1;
		else if (o2.getDist()==o1.getDist()) {
			if(o2.getCpnNum()-o1.getCpnNum()>0)
				return 1;
			else if (o2.getCpnNum()==o1.getCpnNum()) {
				return o2.getName().compareTo(o1.getName());
			}
			else return 1;
		}
		else return 1;
	}
}
class Position {
	int x;
	int y;
	
	/**
	 * @param x
	 * @param y
	 */
	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
}
class User extends Position {

	/**
	 * @param x
	 * @param y
	 */
	public User(int x, int y) {
		super(x, y);
	}
	
}
class Store extends Position {

	String name;
	User user;
	int cpnNum;
	int dist;
	/**
	 * @param x
	 * @param y
	 */
	public Store(int x, int y, String name, int cpnNum, User user) {
		super(x, y);
		this.user = user;
		this.name = name;
		this.cpnNum = cpnNum;
		this.dist = dist();
	}
	private int dist() {
		int temp = (int) (Math.pow((this.x-user.x), 2) + Math.pow((this.y-user.y), 2));
		int dist = (int) Math.sqrt(temp);
		return dist = dist - dist%100;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the cpnNum
	 */
	public int getCpnNum() {
		return cpnNum;
	}
	/**
	 * @param cpnNum the cpnNum to set
	 */
	public void setCpnNum(int cpnNum) {
		this.cpnNum = cpnNum;
	}
	/**
	 * @return the dist
	 */
	public int getDist() {
		return dist;
	}
	/**
	 * @param dist the dist to set
	 */
	public void setDist(int dist) {
		this.dist = dist;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return x + " " + y + " " + name + " " + cpnNum;
	}
}