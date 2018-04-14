package vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author jinwook.im
 *
 * 2017. 12. 27.
 */

public class AdvancedTestVO implements Cloneable{
	private ArrayList<String> testList;
	private Map<String, String> testMap;
	
	public AdvancedTestVO() {}
	public AdvancedTestVO(ArrayList<String> testList,  Map<String, String> testMap) {
		super();
		this.testList = testList;
		this.testMap = testMap;
	}
	@SuppressWarnings("unchecked")
	public ArrayList<String> getTestList() {
		/*List<String> tempList = new ArrayList<String>();
		tempList.addAll(tempList.size(), testList);*/
		return (ArrayList<String>)testList.clone();		//clone()을 이용하여 배열을 복사해서 반환한다.
	}
	@SuppressWarnings("unchecked")
	public void setTestList(ArrayList<String> testList) {
		/*List<String> tempList = new ArrayList<String>();
		tempList.addAll(tempList.size(), testList);*/
		this.testList = (ArrayList<String>) testList.clone();
	}
	public Map<String, String> getTestMap() {
		Map<String, String> tempMap = new HashMap<String, String>();
		tempMap.putAll(testMap);						//배열을 복사하여 반환한다.
		return tempMap;
	}
	public void setTestMap(Map<String, String> testMap) {
		Map<String, String> tempMap = new HashMap<String, String>();
		tempMap.putAll(testMap);
		this.testMap = tempMap;
	}
}