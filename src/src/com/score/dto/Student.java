/**
 * 
 */
package src.com.score.dto;




/**
 * @author Administrator
 *
 *
 */
public class Student extends Person {

	private String num;// 学号
	private String mobilephone;// 电话
	private String nativeplace;// 籍贯
	private String department;// 系部
	private String change;//学籍是否有异动
	private String gradue;// 是否毕业
	

	public String getChange() {
		return change;
	}

	public void setChange(String change) {
		this.change = change;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getNativeplace() {
		return nativeplace;
	}

	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}

	public String getGradue() {
		return gradue;
	}

	public void setGradue(String gradue) {
		this.gradue = gradue;
	}

	public Student() {

	}

	public Student(String num) {
		this.num = num;
	}

	public Student(String name, String sex, int age, String num, String mobilephone, String nativeplace,
			String department, String gradue,String password,String change) {
		super(name, sex, age,password);
		this.num = num;
		this.mobilephone = mobilephone;
		this.nativeplace = nativeplace;
		this.department = department;
		this.change=change;
		this.gradue = gradue;
	}

//	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "\t" + this.num + "\t" + nativeplace + "\t" +this.department +"\t"+ this.mobilephone+ "\t"+this.change+"\t"+ this.gradue;
	}
//
//	@Override
//	public int hashCode() {
//		// TODO Auto-generated method stub
//		Long num = Long.parseLong(this.num.replace("-", ""));
//		return (int) num.intValue();
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		// TODO Auto-generated method stub
//		if (!(obj instanceof Student)) {
//			return false;
//		} else {
//			Student stu = (Student) obj;
//			return this.num.equals(stu.getNum());
//
//		}
//
//	}
//	public double totalScore() {
//		double tS = 0.0;
////		Iterator<Score> iterator = DataBase.sScore.iterator();
//		while (iterator.hasNext()) {
//			Score s = iterator.next();
//			tS += s.getScore();
//
//		}
//		return tS;
//	}
//
//	public double avgScore() {
//
////		List<Score> sList = new ArrayList<Score>(DataBase.sScore);
//
//		return totalScore() / sList.size();
//	}
}
