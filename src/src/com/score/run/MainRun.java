/**
 * 
 */
package src.com.score.run;

import java.util.Scanner;

import src.com.score.service.StudentAiist;
import src.com.score.service.TeacherAiist;

/**
 * @author Administrator
 *
 */
public class MainRun {

	/**
	 * @param args
	 */
	static TeacherAiist ta = new TeacherAiist();
	static StudentAiist sa = new StudentAiist();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method s

		try {
			// StudentAiist.allInit();
			boolean flag = true;
			while (flag) {
				System.out.println("1：********************教师登录");
				System.out.println("2：********************学生登录");
				System.out.println("3：********************系统退出");
				System.out.println("************请进行选择*********");
				int key = sc.nextInt();
				switch (key) {
				case 1:
					if (ta.loginTeacher()) {
						TeacherMain.TeaMenu();
					} else {
						System.out.println("重新输入！！");
					}
					break;
				case 2:
				
						StudentMain.StuMenu();
				
					break;
				case 3:
					System.out.println("系统即将退出了");
					for (int i = 0; i < 20; i++) {
						System.out.print("*");
					}
					try {
						Thread.sleep(3000);
					} catch (Exception e) {
						// TODO: handle exception
					}
					System.exit(0);
					break;
				default:
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("异常说明：");
			e.printStackTrace();
		}

	}

}
