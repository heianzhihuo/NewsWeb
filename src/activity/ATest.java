package activity;

import java.util.Iterator;
import java.util.Map;

import model.newsInfo;

public class ATest {
	ChinaNews test1 = new ChinaNews();
	
	public void testGetNewsInfo() {
		test1.getTopics();
		Iterator iter =  test1.TopicList.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			System.out.print(entry.getKey());
			System.out.println(":"+entry.getValue());
		}
		
		String url = "http://www.chinanews.com/sh/2016/11-24/8073190.shtml";
		newsInfo testnews= test1.getNewsInfo(url) ;
		System.out.println(testnews.getTitle());
		
	}
	
	public static void main(String[] args) {
		ATest pATest = new ATest();
		pATest.testGetNewsInfo();
	}
}
