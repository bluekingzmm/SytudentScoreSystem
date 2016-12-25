/**
 * 
 */
package src.com.score.dto;

/**
 * @author Administrator
 *
 */
public class Exam {

	private String Couse_id;
	private String couse_name;
	private String stu_name;
	private String stu_id;
	private double score;

	



	public String getStu_id() {
		return stu_id;
	}

	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}

	public String getCouse_id() {
		return Couse_id;
	}

	public void setCouse_id(String couse_id) {
		Couse_id = couse_id;
	}

	public String getCouse_name() {
		return couse_name;
	}

	public void setCouse_name(String couse_name) {
		this.couse_name = couse_name;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}



	public Exam() {

	}
	
	
	
	
	public String toString(){
		return this.Couse_id+"\t"+this.couse_name+"\t"+this.stu_name+"\t"+this.stu_id+"\t"+this.score;
	}
}
