package com.kh._interface.step2;

public class Tv implements RemoteControl, Searchable {
	// 다중 상속이 가능하며, 중복되는 변수가 있을 경우 1개만 구현.
	// 추가할 경우 나머지 변수만 추가로 오버라이딩 된다.
	
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
	}

	@Override
	public void search(String url) {
		System.out.println(url + " 검색");
	}

	@Override
	public void setVolume(int volume) {
	}

}
