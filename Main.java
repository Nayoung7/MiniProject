package ��������λ��;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		
		float num = (float)10.5;

		Scanner sc = new Scanner(System.in);
		userDAO dao = new userDAO();
		Time time = new Time();

		System.out.println("���ʹ߰��� ���, �߽߰ð� 10�� 47��");
		time.timelate(1);
		System.out.println("����Ȳ : ��ũ���غ�Ⱓ �ʰԱ��� �������� ������~~");
		time.timelate(1);

		System.out.println("LOADING/././. : �ƽ�Ű��Ʈ�� �������� ������� ǥ��");
		time.timelate(1);
		System.out.println("������ �����մϴ�");
		time.timelate(1);
		System.out.print("[1]ȸ������ [2]�α��� >> ");
		int choice = sc.nextInt();
		String id = "";
		String pw = "";
		String nick = "";
		if (choice == 1) {
			System.out.println("ȸ�������� �����մϴ�");
			System.out.print("id �Է� : ");
			id = sc.next();
			System.out.print("pw �Է� : ");
			pw = sc.next();
			System.out.print("�г��� �Է� : ");
			nick = sc.next();

			int cnt = dao.join(id, pw, nick);

			if (cnt > 0) {
				System.out.println("ȸ������ ����");
			} else {
				System.out.println("ȸ������ ����");
			}

		} else if (choice == 2) {
			System.out.print("id �Է� : ");
			id = sc.next();
			System.out.print("pw �Է� : ");
			pw = sc.next();
			nick = dao.login(id, pw);

			if (nick != null) {
				System.out.println("�α��� ����");
				System.out.println(nick + "�� ȯ���մϴ�!");
			} else {
				System.out.println("�α��� ����");
			}
		}
		System.out.println();
		System.out.println("�����ڴ� �� 5���Դϴ�.");
		time.timelate(1);
		System.out.println("1. ���, �л���ǥ, Ư�̻���:~~~");
		time.timelate(1);
		System.out.println("2. ����, ����, Ư�̻���:~~~");
		time.timelate(1);
		System.out.println("������ �Է��������� ���̺��� ȸ��������� �ҷ����� �޼ҵ� ����ϱ�");
		time.timelate(1);
		System.out.println("���ݺ��� ������ �˰��ϱ� ���� �߸��� �����մϴ�.");
		time.timelate(1);
		System.out.println("������ �˰��ִٸ� ���ΰ˰��ϱ⸦ ���� �ٷ� ������ ���� �� �ֽ��ϴ�.");
		time.timelate(1);
		System.out.print("[1]�߸��ϱ� [2]���� �˰��ϱ� >> ");
		int choice2 = sc.nextInt();
		if (choice2 == 1) {
			System.out.println("Ž���� ��Ҹ� �����ϼ���");
			System.out.print("[1]����� [2]�ΰ����ɹ� [3]������ [4]���� [5]�����͹� >> ");
			int location = sc.nextInt();
			if (location == 1) {
				System.out.println("������ �ൿ�� �����ϼ���");
				System.out.print("[1]����� �������� Ž���ϱ� [2]���� �߱��ϱ� >> ");
				int act = sc.nextInt();
				if (act == 1) {
					System.out.println("��� Ž���ϰ� ��������?");
					System.out.print("[1]å�󼭶� [2]��ǻ�� [3]ĳ��� >> ");
					int where = sc.nextInt();
					sc.nextLine();
					System.out.println();
					Quiz quizking = new Quiz();
					if (where == 1) {
						// ���� ����
						System.out.println("(77*1)+(76*2)+(75*3)+...+(1*77)�� ����ϴ� �ڵ带 �ۼ��Ͽ� �ùٸ� ����� ����Ͻÿ�");
						System.out.println("��, int sum = 0; ����Ǿ�����, sum�� ����Ͽ� ���;��� ���ٷ� ��¹����� �ۼ��ϸ� �˴ϴ�.");
						String txt = sc.nextLine();
						int sum = quizking.QuizKing(txt);

						if (sum == 79079) {
							System.out.println("�����Դϴ�! ����ȹ��!");
							System.out.println("�۱ݳ��� 1��~~~~");
							// ������ �������̺� ����
						} else {
							System.out.println("�����Դϴ� ����ȹ�����");
						}
					} else if (where == 2) {
						System.out.println("10!(���丮��) ���� ���Ͻÿ�");
						System.out.println("��, int sum = 0; ����Ǿ�����, sum�� ����Ͽ� ���;��� ���ٷ� ��¹����� �ۼ��ϸ� �˴ϴ�.");
						String txt = sc.nextLine();
						int sum = quizking.QuizKing(txt);

						if (sum == 3628800) {
							System.out.println("�����Դϴ�! ����ȹ��!");
							System.out.println("������ �������� or �޿�����~~~~");
							// ������ �������̺� ����
						} else {
							System.out.println("�����Դϴ� ����ȹ�����");
						}
					}
				}
			}
		}
	}
}
