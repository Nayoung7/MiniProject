package ��������λ��;

import java.io.File;
import java.util.Scanner;

public class Quiz {

	public int QuizKing(String txt) {
		// ������ �ִ� Tread Ŭ���� ���� ����
		File file = new File("C:\\Users\\smhrd\\Desktop\\JavaStudy\\��������λ��\\src\\��������λ��\\QuizRun.java");
//		if (file.exists()) {
//			if (file.delete()) {
//				System.out.println("���ϻ��� ����");
//			} else {
//				System.out.println("���ϻ��� ����");
//			}
//		} else {
//			System.out.println("������ �������� �ʽ��ϴ�.");
//		}

		if (file.exists()) {
			if (file.delete()) {

			}
		}

//		 ������
		try {

			Thread.sleep(2000); // 2�� ���

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

		// Thread Ŭ���� ���� �����
		// �Է��� �ڵ带 ���ڿ��� Thread Ŭ���� �������� ����� �ְ� �Ѱ���
		QuizCreate test = new QuizCreate();
		test.createText(txt);
		int sum = 0;

		// ������
		try {
			Thread.sleep(2000); // 1�� ���

			// ������� Thread Ŭ���� ���� ����
			QuizRun na = new QuizRun();
			sum = na.test();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return sum;
	}
}
