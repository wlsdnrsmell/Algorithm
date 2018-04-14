/**
 * 
 */
package codeJam;
import java.util.*;
import java.io.*;
/**
 * @author ginTonic
 * @Title 
 * 2018. 3. 23.
 */
public class EvenDigits {
	static long LONG_MASK = 11111;
	public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int i = 1; i <= t; ++i) {
	      long n = in.nextLong();
	      int cntL=0, cntH=0;
	      Queue<Long> q = new LinkedList<Long>();
	      int highWord =(int)(n>>>32);
	      System.out.println((highWord)+" "+(n&LONG_MASK));
	      //Map<Long, Boolean> map = new HashMap<Long, Boolean>();
	      boolean[]d = new boolean[10000001];
	      if(highWord==0)
	    	  d[(int)n] = true;
	      else
	    	  d[(int)(highWord)]=true;
	      q.offer(n); 
	      
	      while(!q.isEmpty()) {
	    	  long now = q.poll();
	    	  highWord = (int)(now>>>32);
	    	  if(now>0) {
	    		  if(highWord==0) {
	    			  if(!d[(int)now-1]) {
			    		  if(!check(now)) {
				    		  cntL++;
		    				  q.offer(now-1);
		    				  d[(int)now-1]= true;
			    		  }
			    	  }
			    	  if(!d[(int)now+1]) {
			    		  if(!check(now)) {
				    		  cntH++;
		    				  q.offer(now+1);
				    		  d[(int)now+1] = true;
				    	  }
			    	  }
	    		  } else {
	    			  if(!d[highWord-1]) {
			    		  if(!check(now)) {
				    		  cntL++;
		    				  q.offer(now-1);
		    				  d[highWord-1]= true;
			    		  }
			    	  }
			    	  if(!d[highWord+1]) {
			    		  if(!check(now)) {
				    		  cntH++;
		    				  q.offer(now+1);
				    		  d[highWord+1] = true;
				    	  }
			    	  }
	    		  }
		      }
		  }
	      System.out.println("Case #" + i + ": " + Math.min(cntL, cntH));
	    }
	}
	static boolean check (long n) {
		while(n!=0) {
			long div = n%10;
			if(div%2!=0) return false;
			n = n/10;
		}
		return true;
	}
	
}

  
