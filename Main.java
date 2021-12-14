package 스인재살인사건;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		
		float num = (float)10.5;

		Scanner sc = new Scanner(System.in);
		userDAO dao = new userDAO();
		Time time = new Time();

		System.out.println("최초발견자 상민, 발견시간 10시 47분");
		time.timelate(1);
		System.out.println("배경상황 : 워크샵준비기간 늦게까지 누구누구 모여있음~~");
		time.timelate(1);

		System.out.println("LOADING/././. : 아스키아트로 점점점은 순서대로 표현");
		time.timelate(1);
		System.out.println("게임을 시작합니다");
		time.timelate(1);
		System.out.print("[1]회원가입 [2]로그인 >> ");
		int choice = sc.nextInt();
		String id = "";
		String pw = "";
		String nick = "";
		if (choice == 1) {
			System.out.println("회원가입을 시작합니다");
			System.out.print("id 입력 : ");
			id = sc.next();
			System.out.print("pw 입력 : ");
			pw = sc.next();
			System.out.print("닉네임 입력 : ");
			nick = sc.next();

			int cnt = dao.join(id, pw, nick);

			if (cnt > 0) {
				System.out.println("회원가입 성공");
			} else {
				System.out.println("회원가입 실패");
			}

		} else if (choice == 2) {
			System.out.print("id 입력 : ");
			id = sc.next();
			System.out.print("pw 입력 : ");
			pw = sc.next();
			nick = dao.login(id, pw);

			if (nick != null) {
				System.out.println("로그인 성공");
				System.out.println(nick + "님 환영합니다!");
			} else {
				System.out.println("로그인 실패");
			}
		}
		System.out.println();
		System.out.println("용의자는 총 5명입니다.");
		time.timelate(1);
		System.out.println("1. 상민, 학생대표, 특이사항:~~~");
		time.timelate(1);
		System.out.println("2. 나영, 원장, 특이사항:~~~");
		time.timelate(1);
		System.out.println("일일히 입력하지말고 테이블에서 회원정보목록 불러오는 메소드 사용하기");
		time.timelate(1);
		System.out.println("지금부터 범인을 검거하기 위한 추리를 시작합니다.");
		time.timelate(1);
		System.out.println("범인을 알고있다면 범인검거하기를 눌러 바로 범인을 잡을 수 있습니다.");
		time.timelate(1);
		System.out.print("[1]추리하기 [2]범인 검거하기 >> ");
		int choice2 = sc.nextInt();
		if (choice2 == 1) {
			System.out.println("탐색할 장소를 선택하세요");
			System.out.print("[1]원장실 [2]인공지능반 [3]교무실 [4]경비실 [5]빅데이터반 >> ");
			int location = sc.nextInt();
			if (location == 1) {
				System.out.println("수행할 행동을 선택하세요");
				System.out.print("[1]원장실 구석구석 탐색하기 [2]원장 추궁하기 >> ");
				int act = sc.nextInt();
				if (act == 1) {
					System.out.println("어디를 탐색하고 싶은가요?");
					System.out.print("[1]책상서랍 [2]컴퓨터 [3]캐비넷 >> ");
					int where = sc.nextInt();
					sc.nextLine();
					System.out.println();
					Quiz quizking = new Quiz();
					if (where == 1) {
						// 퀴즈 진행
						System.out.println("(77*1)+(76*2)+(75*3)+...+(1*77)를 계산하는 코드를 작성하여 올바른 결과를 출력하시오");
						System.out.println("단, int sum = 0; 선언되어있음, sum을 사용하여 엔터없이 한줄로 출력문까지 작성하면 됩니다.");
						String txt = sc.nextLine();
						int sum = quizking.QuizKing(txt);

						if (sum == 79079) {
							System.out.println("정답입니다! 증거획득!");
							System.out.println("송금내역 1억~~~~");
							// 차용증 증거테이블에 저장
						} else {
							System.out.println("오답입니다 증거획득실패");
						}
					} else if (where == 2) {
						System.out.println("10!(팩토리얼) 값을 구하시오");
						System.out.println("단, int sum = 0; 선언되어있음, sum을 사용하여 엔터없이 한줄로 출력문까지 작성하면 됩니다.");
						String txt = sc.nextLine();
						int sum = quizking.QuizKing(txt);

						if (sum == 3628800) {
							System.out.println("정답입니다! 증거획득!");
							System.out.println("직원들 인적사항 or 급여명세서~~~~");
							// 차용증 증거테이블에 저장
						} else {
							System.out.println("오답입니다 증거획득실패");
						}
					}
				}
			}
		}
	}
}
