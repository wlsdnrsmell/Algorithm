package vo;

import java.util.ArrayList;
import java.util.Map;

/**
 * 
 * @author jinwook.im
 *
 * 2017. 12. 27.
 */

public class TestVO {
	private ArrayList<String> testList;
	private Map<String, String> testMap;
	
	public ArrayList<String> getTestList() {
		return testList;
	}
	public TestVO() {}
	public TestVO(ArrayList<String> testList,  Map<String, String> testMap) {
		super();
		this.testList = testList;
		this.testMap = testMap;
	}
	public void setTestList(ArrayList<String> testList) {
		this.testList = testList;
	}
	public Map<String, String> getTestMap() {
		return testMap;
	}
	public void setTestMap(Map<String, String> testMap) {
		this.testMap = testMap;
	}
}