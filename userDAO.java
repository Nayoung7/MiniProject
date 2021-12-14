package ��������λ��;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class userDAO {

	// DAO > DataBase Access Object : ������ ���̽��� �����ϱ� ���� ��ü�� ���� �� �ִ� Ŭ����
		private Connection conn;
		private PreparedStatement psmt;
		private ResultSet rs;

		// ����̹� �ε��� Ŀ�ؼ� ��ü�� �������� �޼ҵ�
		private void getConnection() {
			// JDBC
			// 0.JDBC�� ����ϴ� ������Ʈ�� Driver ���� �ֱ�
			// 1.Driver �ε� : ����̹� ��������(Oracle Driver) -> ���� ����ϴ� DBMS�� ����̹� �ε�, �����ε�(�����̹���
			// �����Ŀ� ���� �޶�����?)
			// - Class.forName("oracle.jdbc.driver.OracleDriver") : Ŭ���� �̸��� ���ؼ� ����̹��� �ε��ϰڴٴ�
			// �ǹ�
			// - try{���ܻ�Ȳ�� �߻���ų �� �ִ� �ڵ带 ����} catch( ���ܻ�Ȳ ����ֱ� >> ClassNotFoundException e :
			// �ش��ϴ� Ŭ������ ����){������
			// ����ϴ°�}
			// - ���ܻ�Ȳ�� �߻��� ���Ѱ͵��� �ϳ��� try�� �������
			// ���⼭ ���ܻ�Ȳ�� Ŭ���� ������ ���� ��η� �����Ϸ��� ã�ư��ǵ� ��ο� ������ ���� ��� or ��ο� ��Ÿ�� �ִ°�� Ŭ������ ã�ư���
			// ���� �� �ִ�
			// �׷��� try catch�� ����ó�� ���ִ°�
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				// 2.Connection ����
				// - DB�� ���Ӱ����� url, id, pw�� �ʿ��ϴ�.
				String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
				String db_id = "hr";
				String db_pw = "hr";
				// drivermanager�� ���ؼ� ��� ����������� conn �̶�� ��ο� �־��ִ� ��
				// ���⼭ ���ܻ�Ȳ�� Ŀ�ؼ��� �������� �� = db�� ������ �ȵƴٴ� �� = url,id,pw �� �ϳ��� Ʋ���� ��
				conn = DriverManager.getConnection(db_url, db_id, db_pw);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		// DataBase�� ������ �����ִ� �޼ҵ�
		private void close() {
			// 4. ���� �����ֱ�
			// try�� �� �ǵ� catch�� �Ѿ���� finally�� ���� ������ ����� �Ѿ���Ե�
			// �������� ������ ��������
			try {
				// rs�� null �� �ƴҶ��� ó�����ֱ� ������ rs�� ������ close�� �ᵵ �������
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

		// �α��� ���
		public String login(String id, String pw) {

			getConnection();
			String nick = null;

			try {
				// 3.SQL�� �ۼ� �� ����
				// �޾ƿ� ���� �޾Ƽ� ó���ؾ��ϱ� ������ Ȯ������ ���� ���� ����ǥ�� ����Ѵ�.
				// ���⼭ ���ܻ�Ȳ�� sql���� ��Ÿ�� �߻��� �� �ִ� > �� ��Ȳ�� ���� ����ó���� �ʿ���
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

		// ȸ�� ���� ��� �޼ҵ�
		public int join(String id, String pw, String nick) {

			getConnection();
			int cnt = 0;

			try {
				// 3.SQL�� �ۼ� �� ����
				// �޾ƿ� ���� �޾Ƽ� ó���ؾ��ϱ� ������ Ȯ������ ���� ���� ����ǥ�� ����Ѵ�.
				String sql = "insert into miniuser values(?,?,?)";
				// PreparedStatement : sql���� ����ǥ�� ä���ְ� ��ü, sql���� ������ ó���ϴ� ��ü
				// ��, ������ connection�� ���ؼ� �޾ƿ��� �� = ��� ������ connection���� ����
				// connection���� ������ �޾� ���� ���ؼ� sql���� �ѹ� ������ �ᵵ�Ǵ��� ����� ���� �޾ƿ��� ��
				// sql���� ������ ���� conn ��θ� ���� ������ �޾ƿ��� ��
				psmt = conn.prepareStatement(sql);
				// psmt�� ���ؼ� 1�� ����ǥ�� string���� id�� ä��� *3���� �ݺ�
				psmt.setString(1, id);
				psmt.setString(2, pw);
				psmt.setString(3, nick);
				// psmt�� ���� sql�� ����
				// psmt�� ��������ּ���( sql������ ���� )
				cnt = psmt.executeUpdate();

			} catch (SQLException e) {
				// �����ͺ��̽��� ���õ� ��� ����ó��
				e.printStackTrace();
			} finally {
				// try�� �� �ǵ� catch�� �Ѿ���� finally�� ���� ������ ����� �Ѿ���Ե�
				// �������� ��������
				close();
			}
			return cnt;
		}

		// ȸ�� ���� ����� ���� �ִ� �޼ҵ�
		public ArrayList<userDTO> selectAll() {

			getConnection();
			ArrayList<userDTO> list = new ArrayList<userDTO>();

			try {
				// 3.SQL�� �ۼ� �� ����
				// �޾ƿ� ���� �޾Ƽ� ó���ؾ��ϱ� ������ Ȯ������ ���� ���� ����ǥ�� ����Ѵ�.
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
				// try�� �� �ǵ� catch�� �Ѿ���� finally�� ���� ������ ����� �Ѿ���Ե�
				// �������� ��������
				close();
			}
			return list;
		}

		// ȸ�� ���� �����ϴ� �޼ҵ�
		public int update(String id, String nick) {

			getConnection();
			int cnt = 0;

			try {
				// 3.SQL�� �ۼ� �� ����
				// �޾ƿ� ���� �޾Ƽ� ó���ؾ��ϱ� ������ Ȯ������ ���� ���� ����ǥ�� ����Ѵ�.
				String sql = "update miniuser set nick = ? where id = ?";

				psmt = conn.prepareStatement(sql);
				psmt.setString(1, nick);
				psmt.setString(2, id);

				cnt = psmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				// try�� �� �ǵ� catch�� �Ѿ���� finally�� ���� ������ ����� �Ѿ���Ե�
				// �������� ��������
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
