package com.kh.object;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

//객체를 직렬화로 통과하려면 반드시 implements Serializable이 되어있어야 한다!
public class Person implements Serializable {

	private String name;
	private String id;
}
