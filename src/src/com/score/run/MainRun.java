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
				System.out.println("1��********************��ʦ��¼");
				System.out.println("2��********************ѧ����¼");
				System.out.println("3��********************ϵͳ�˳�");
				System.out.println("************�����ѡ��*********");
				int key = sc.nextInt();
				switch (key) {
				case 1:
					if (ta.loginTeacher()) {
						TeacherMain.TeaMenu();
					} else {
						System.out.println("�������룡��");
					}
					break;
				case 2:
				
						StudentMain.StuMenu();
				
					break;
				case 3:
					System.out.println("ϵͳ�����˳���");
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
			System.out.println("�쳣˵����");
			e.printStackTrace();
		}

	}

}
