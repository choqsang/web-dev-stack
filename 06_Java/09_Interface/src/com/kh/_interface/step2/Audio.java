package com.kh._interface.step2;

public class Audio implements RemoteControl {

	private int volume; // 클래스라 지정 가능
	
	@Override
	public void turnOn() {
		System.out.println("오디오를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("오디오를 끕니다.");
	}

	@Override
	public void setVolume(int volume) {
		if(volume > Volume.MAX_VOLUME) {
			this.volume = Volume.MAX_VOLUME;
		} else if (volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		System.out.println("현재 오디오 볼륨 : " + this.volume);
	}

	@Override
	public void search(String url) {
	}

}
