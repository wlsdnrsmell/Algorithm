package consistency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import vo.AdvancedTestVO;
import vo.TestVO;

/**
 * 
 * @author jinwook.im
 *
 * 2017. 12. 27.
 */

public class ShallowOrDeepCopyTest {
	@Test
	public void main() {
		Map<String, String> map = new HashMap<String, String> ();
		map.put("first", "first");
		
		Map<String, String> map2 = new HashMap<String, String> ();
		map2.put("first", "first");
		
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		list.add("first");
		list2.add("first");
		
		
		System.out.println("================1. Print Origin Objects===========");
		System.out.println(map);
		System.out.println(list);
		System.out.println(map2);
		System.out.println(list2);
		
		//객체생성
		AdvancedTestVO aTv = new AdvancedTestVO(list2, map2);
		
		//accessor를 통해 값을 가져온다(복사된 배열)
		Map<String, String> adTestMap = aTv.getTestMap();		
		ArrayList<String> adTestList = aTv.getTestList();

		System.out.println("=============2. Get Objects by Accessor===========");
		System.out.println("2. deep copy");
		System.out.println(adTestMap);		//{first=first}
		System.out.println(adTestList);		//{first}
		
		//복사된 배열이 변경되기 때문에 기존의 배열과 객체 내부 필드의 값을 변경할 수 없다.
		System.out.println("=============3. Add <second> to Object by put method==========");
		adTestMap.put("second", "second");
		adTestList.add("second");
		
		System.out.println("===============5. Get Objects by Accessor============");
		System.out.println("2. deep copy");
		System.out.println(aTv.getTestList());	//{first=first}
		System.out.println(aTv.getTestMap());	//{first}
		
		//mutator를 이용하여 private필드 접근 변경
		System.out.println("===============6. Change Objects value by mutator============");
		aTv.setTestList(adTestList);
		aTv.setTestMap(adTestMap);
		
		System.out.println("===============7. Get Objects by Accessor after Mutator============");
		System.out.println("2. deep copy");
		System.out.println(aTv.getTestList());	//{first=first, second=second}
		System.out.println(aTv.getTestMap());	//{first, second}
		
		System.out.println("===============8. Print Origin Objects===============");
		System.out.println(map);
		System.out.println(list);
		System.out.println(map2);
		System.out.println(list2);
	}

}