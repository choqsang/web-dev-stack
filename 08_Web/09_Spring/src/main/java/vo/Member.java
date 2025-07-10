package vo;

public class Member {

	private String id;
	private String name;
	private String pwd;
	private int age;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Member() {
		super();
	}
	public Member(String id, String name, String pwd, int age) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.age = age;
	}
	
	
}
