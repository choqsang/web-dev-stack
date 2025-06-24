package com.kh._interface.step2;

public interface Volume {
	// 상수(대문자로 표기)
	public static final int MIN_VOLUME = 0;
	int MAX_VOLUME = 20;
	// 인터페이스에 멤버변수는 무조건 상수! 표기를 하든 안하든 public static final 항상 적용
	
	public abstract void setVolume(int volume); // public abstract는 표기되어 있으나 없으나 항상 적용 (추상메서드)
}
