package com.kh.practice3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Music implements Comparable<Music>{

	private String song;
	private String artist;
	
	@Override
	public int compareTo(Music o) {
		return this.artist.compareTo(o.artist);
		// o.artist와 this.artist의 순서를 변경하면 정렬이 반대가 된다.
	}
	

}