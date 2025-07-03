package vo;
// VO(Value Object) : 값만 담는 객체

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {

	private int id;
	private String name;
	private int age;
	private String addr;
}
