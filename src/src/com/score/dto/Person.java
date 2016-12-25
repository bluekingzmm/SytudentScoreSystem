package src.com.score.dto;

public abstract class Person {

	
	private String name;
	private String sex;
	private int age;
	protected String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public Person(){
		
	}
	
	
	public Person(String name,String sex,int age,String password){
		
		this.name=name;
		this.sex=sex;
		this.age=age;
		this.password=password;
		
	}
	
	
	public String toString(){
		return this.name+"\t"+this.sex+"\t"+this.age;
	}
	
	
	
	
	
	
	
}
