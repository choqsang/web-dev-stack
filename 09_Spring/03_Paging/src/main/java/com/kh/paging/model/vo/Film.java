package com.kh.paging.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Film {
	private int id; // film_id
	private String title; // title
	private String desc; // description
}
