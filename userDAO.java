package 스인재살인사건;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class userDAO {

	// DAO > DataBase Access Object : 데이터 베이스에 접근하기 위한 객체를 만들 수 있는 클래스
		private Connection conn;
		private PreparedStatement psmt;
		private ResultSet rs;

		// 드라이버 로딩과 커넥션 객체를 가져오는 메소드
		private void getConnection() {
			// JDBC
			// 0.JDBC를 사용하는 프로젝트에 Driver 파일 넣기
			// 1.Driver 로딩 : 드라이버 가져오기(Oracle Driver) -> 내가 사용하는 DBMS의 드라이버 로딩, 동적로딩(어떤드라이버를
			// 쓰느냐에 따라서 달라진다?)
			// - Class.forName("oracle.jdbc.driver.OracleDriver") : 클래스 이름을 통해서 드라이버를 로딩하겠다는
			// 의미
			// - try{예외상황이 발생시킬 수 있는 코드를 넣음} catch( 예외상황 잡아주기 >> ClassNotFoundException e :
			// 해당하는 클래스가 없음){에러를
			// 출력하는것}
			// - 예외상황이 발생할 만한것들을 하나의 try에 묶어놓기
			// 여기서 예외상황은 클래스 포네임 안의 경로로 컴파일러가 찾아갈건데 경로에 파일이 없는 경우 or 경로에 오타가 있는경우 클래스를 찾아가지
			// 못할 수 있다
			// 그래서 try catch로 예외처리 해주는것
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				// 2.Connection 연결
				// - DB에 접속가능학 url, id, pw가 필요하다.
				String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
				String db_id = "hr";
				String db_pw = "hr";
				// drivermanager를 통해서 통로 만들었던것을 conn 이라는 통로에 넣어주는 것
				// 여기서 예외상황은 커넥션을 못가져올 때 = db에 연결이 안됐다는 것 = url,id,pw 중 하나라도 틀렸을 때
				conn = DriverManager.getConnection(db_url, db_id, db_pw);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		// DataBase와 연결을 끊어주는 메소드
		private void close() {
			// 4. 연결 끊어주기
			// try가 잘 되든 catch로 넘어오든 finally를 쓰면 무조건 여기로 넘어오게됨
			// 닫을때는 생성의 역순으로
			try {
				// rs가 null 이 아닐때만 처리해주기 때문에 rs가 없을때 close를 써도 상관없음
				if (rs != null) {
					rs.close();
				}
				if (psmt != null) {
					psmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		// 로그인 기능
		public String login(String id, String pw) {

			getConnection();
			String nick = null;

			try {
				// 3.SQL문 작성 및 실행
				// 받아온 값을 받아서 처리해야하기 때문에 확정되지 않은 값은 물음표를 사용한다.
				// 여기서 예외상황은 sql문에 오타가 발생할 수 있다 > 이 상황에 대한 예외처리가 필요함
				String sql = "select * from miniuser where id = ? and pw = ?";

				psmt = conn.prepareStatement(sql);
				psmt.setString(1, id);
				psmt.setString(2, pw);

				rs = psmt.executeQuery();
				if (rs.next()) {
					nick = rs.getString("nick"); // = rs.getString(3);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}

			return nick;
		}

		// 회원 가입 기능 메소드
		public int join(String id, String pw, String nick) {

			getConnection();
			int cnt = 0;

			try {
				// 3.SQL문 작성 및 실행
				// 받아온 값을 받아서 처리해야하기 때문에 확정되지 않은 값은 물음표를 사용한다.
				String sql = "insert into miniuser values(?,?,?)";
				// PreparedStatement : sql문의 물음표를 채워주고 객체, sql문의 모든것을 처리하는 객체
				// 단, 조건은 connection을 통해서 받아오는 것 = 모든 권한은 connection에게 있음
				// connection에게 권한을 받아 오기 위해서 sql문을 한번 보내서 써도되는지 물어보고 나서 받아오는 것
				// sql문의 실행을 위해 conn 통로를 통해 권한을 받아오는 것
				psmt = conn.prepareStatement(sql);
				// psmt를 통해서 1번 물음표를 string형의 id로 채운다 *3까지 반복
				psmt.setString(1, id);
				psmt.setString(2, pw);
				psmt.setString(3, nick);
				// psmt를 통해 sql문 실행
				// psmt를 실행시켜주세요( sql문에서 엔터 )
				cnt = psmt.executeUpdate();

			} catch (SQLException e) {
				// 데이터베이스에 관련된 모든 예외처리
				e.printStackTrace();
			} finally {
				// try가 잘 되든 catch로 넘어오든 finally를 쓰면 무조건 여기로 넘어오게됨
				// 닫을때는 역순으로
				close();
			}
			return cnt;
		}

		// 회원 정보 목록을 볼수 있는 메소드
		public ArrayList<userDTO> selectAll() {

			getConnection();
			ArrayList<userDTO> list = new ArrayList<userDTO>();

			try {
				// 3.SQL문 작성 및 실행
				// 받아온 값을 받아서 처리해야하기 때문에 확정되지 않은 값은 물음표를 사용한다.
				String sql = "select * from miniuser";

				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();

				while (rs.next()) {
					String id = rs.getString("id");
					String pw = rs.getString("pw");
					String nick = rs.getString("nick");
					userDTO dto = new userDTO(id, pw, nick);
					list.add(dto);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				// try가 잘 되든 catch로 넘어오든 finally를 쓰면 무조건 여기로 넘어오게됨
				// 닫을때는 역순으로
				close();
			}
			return list;
		}

		// 회원 정보 수정하는 메소드
		public int update(String id, String nick) {

			getConnection();
			int cnt = 0;

			try {
				// 3.SQL문 작성 및 실행
				// 받아온 값을 받아서 처리해야하기 때문에 확정되지 않은 값은 물음표를 사용한다.
				String sql = "update miniuser set nick = ? where id = ?";

				psmt = conn.prepareStatement(sql);
				psmt.setString(1, nick);
				psmt.setString(2, id);

				cnt = psmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				// try가 잘 되든 catch로 넘어오든 finally를 쓰면 무조건 여기로 넘어오게됨
				// 닫을때는 역순으로
				close();
			}
			return cnt;
		}

		public int delete(String id, String pw) {

			getConnection();
			int cnt = 0;
			try {
				String sql = "delete from miniuser where id = ? and pw = ?";

				psmt = conn.prepareStatement(sql);
				psmt.setString(1, id);
				psmt.setString(2, pw);

				cnt = psmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}
			return cnt;
		}

}
