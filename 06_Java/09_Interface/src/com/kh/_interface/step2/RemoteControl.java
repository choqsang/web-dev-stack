package com.kh._interface.step2;

public interface RemoteControl extends Volume, Searchable {
	// 같은 인터페이스 내에서는 extends로 상속됨 (implements 불가)
	// 인터페이스는 다중 상속이 가능하며, extends를 사용하더라도 동일하게 적용 가능
	
	void turnOn();
	void turnOff();
}
