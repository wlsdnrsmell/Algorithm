/**
 * 
 */
package bfs;

/**
 * @author ginTonic
 * @Title 
 * 2018. 3. 19.
 */
class Pair implements Comparable<Pair> {
	int priority;
	final int first;
	final int second;
	
	public Pair(int priority, Pair p) {
		this.priority = priority;
		this.first = p.first;
		this.second = p.second;
	}
	public Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Pair pair) {
		if(this.priority>pair.priority)
			return -1;
		if(this.priority<pair.priority)
			return 1;
		if(this.first<pair.first)
			return -1;
		if(this.first>pair.first)
			return 1;
		if(this.second<pair.second)
			return -1;
		if(this.second>pair.second)
			return 1;
		return 0;
	}
	
	@Override
	public boolean equals(Object object) {
		if(object instanceof Pair) {
			Pair pair = (Pair) object;
			return this.first==pair.first&&this.second==pair.second;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int n = 3;
		n = 19 * n +this.first;
		n = 19 * n +this.second;
		return n;
	}
}