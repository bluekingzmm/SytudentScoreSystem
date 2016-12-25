package src.com.score.dto;

public class Teacher extends Person {

	
	
	private String teacode;//教师编号
	private double money;//工资
	
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getTeacode() {
		return teacode;
	}
	public void setTeacode(String teacode) {
		this.teacode = teacode;
	}
	public Teacher(){
		
	}
	public Teacher(String name,String sex,int age,String teacode,double money,String password){
		super(name,sex,age,password);
		this.teacode=teacode;
		this.money=money;
		
	}
	
	
	public String toString(){
		return super.toString()+"\t"+this.teacode+"\t"+this.money;
		
	}

//	@Override
//	public int hashCode() {
//		// TODO Auto-generated method stub
//		Long code=Long.parseLong(this.teacode.replace("-", ""));
//		return (int)code.intValue();
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		// TODO Auto-generated method stub
//		if(obj instanceof Teacher){
//			return false;
//		}else{
//			Teacher tea=(Teacher) obj;
//			return tea.getTeacode().equals(teacode);
//		}
//		
//	}


	
	
}
