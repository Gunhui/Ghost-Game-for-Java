package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class JumpDAO {
	private static String driverClassName = "org.mariadb.jdbc.Driver";
	private static String driverServerURL = "jdbc:mariadb://localhost:3306/roomescape";
	private static String driverUserId = "root";
	private static String driverUserPw = "quydcjf2";
	private Connection con = null;

	// DB 접속 하는 메서드
	private void connect() throws Exception {
		try {
			Class.forName(driverClassName);
			con = DriverManager.getConnection(driverServerURL, driverUserId, driverUserPw);
		} catch (Exception e) {
			throw e;
		}
	}

	public void insertMember(jump jp) throws Exception {
		connect();
		String sql = "insert into jump values(?, ?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, jp.getName());
			pstmt.setString(2, jp.getDate());
			pstmt.setInt(3, jp.getTimer());

			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			con.close();
		}
	}

	public void deleteMember(String name) throws Exception {
		connect();
		String sql = "delete from jump where name=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);

			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			con.close();
		}
	}

	public Vector listMember() throws Exception {
		Vector data = new Vector();
		connect();
		String sql = "select * from jump order by score desc";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString(1);
				String date = rs.getString(2);
				int score = rs.getInt(3);

				Vector row = new Vector();

				row.add(name);
				row.add(date);
				row.add(score);
				data.add(row);
			} // while
		} catch (Exception e) {
			throw e;
		} finally {
			con.close();
		}
		return data;
	}
}