package 스인재살인사건;

import java.io.File;
import java.util.Scanner;

public class Quiz {

	public int QuizKing(String txt) {
		// 기존에 있던 Tread 클래스 파일 삭제
		File file = new File("C:\\Users\\smhrd\\Desktop\\JavaStudy\\스인재살인사건\\src\\스인재살인사건\\QuizRun.java");
//		if (file.exists()) {
//			if (file.delete()) {
//				System.out.println("파일삭제 성공");
//			} else {
//				System.out.println("파일삭제 실패");
//			}
//		} else {
//			System.out.println("파일이 존재하지 않습니다.");
//		}

		if (file.exists()) {
			if (file.delete()) {

			}
		}

//		 딜레이
		try {

			Thread.sleep(2000); // 2초 대기

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

		// Thread 클래스 파일 만들기
		// 입력한 코드를 문자열로 Thread 클래스 내용으로 만들수 있게 넘겨줌
		QuizCreate test = new QuizCreate();
		test.createText(txt);
		int sum = 0;

		// 딜레이
		try {
			Thread.sleep(2000); // 1초 대기

			// 만들어진 Thread 클래스 파일 실행
			QuizRun na = new QuizRun();
			sum = na.test();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return sum;
	}
}
