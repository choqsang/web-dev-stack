package com.kh.map;

import java.util.Enumeration;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

/*
 * Properties
 * - HashMap 구버전인 Hashtable(Object, Object)을 상속받아 구현한 것
 * - (String, String) 형태로 단순화된 컬렉션 클래스
 * - 주로 환경설정과 관련된 속성(property)을 저장하는 데 사용
 * */

public class B_Properties {
		
	public static void main(String[] args) {
		Properties prop = new Properties();
		
		prop.setProperty("List", "ArrayList");
		prop.setProperty("Set", "HashSet");
		prop.setProperty("Map", "HashMap");
		prop.setProperty("Map", "Properties");
		
		System.out.println(prop);
		Set<Entry<Object, Object>> entrySet = prop.entrySet();
		for(Entry<Object, Object> entry : entrySet) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		Set<Object> keySet = prop.keySet();
		for(Object key : keySet) {
			System.out.println(key + " - " + prop.getProperty((String) key));
		}
		
		Enumeration en = prop.propertyNames(); // Iterator와 유사한 기능
		while(en.hasMoreElements()) {
			String key = (String) en.nextElement();
			String value = prop.getProperty(key);
			System.out.println(key + " / " + value);
		}
	}

}
