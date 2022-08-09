package vo;

public class PersonVO {
	private String name,tel;
	private int age;
	
	public PersonVO() { //기본생성자
		// TODO Auto-generated constructor stub
		System.out.println("--PersonVO의 생성자--");
	}
	
	public PersonVO(String name, int age, String tel) {//파라미터를 요구하는 생성자
		System.out.println("--name,age,tel을 받는 PersonVO 생성자--");
		this.name = name;
		this.age = age;
		this.tel = tel;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("--setName()호출됨--");
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		System.out.println("--setTel()호출됨--");
		this.tel = tel;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		System.out.println("--setAge()호출됨--");
		this.age = age;
	}
	
	
}
