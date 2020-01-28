package itrsolution.co.kr.legacy.batch.goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GoodInfoProc {
	
	/**
	 * GOD_GOODINFO (��ǰ����) Insert ����
	 */
	private final String SQL_INSERT_GOODINFO;
	{
		System.out.println("Create 'SQL_INSERT_GOODINFO'");
		
		StringBuilder sbSql = new StringBuilder();
		sbSql.append(" insert into god_goodinfo ");
		sbSql.append(" (GOOD_ID,GOOD_NM)        ");
		sbSql.append(" values                   ");
		sbSql.append(" (:GOOD_ID,:GOOD_NM)      ");
		
		SQL_INSERT_GOODINFO = sbSql.toString();
	}
	
	/**
	 * ������ ��ǰ ��ȣ �������� ����
	 */
	private final String SQL_LAST_GOOD_NO;
	{
		System.out.println("Create 'SQL_LAST_GOOD_NO'");
		
		StringBuilder sbSql = new StringBuilder();
		sbSql.append(" select count(good_id) as lastNo ");
		sbSql.append(" from god_goodinfo               ");
		
		SQL_LAST_GOOD_NO = sbSql.toString();
	}
	
	
	/**
	 * ������
	 * @param conn
	 */
	public GoodInfoProc() {
		System.out.println("Call constructor.");
	}

	/**
	 * ������ ��ǰ ��ȣ�� ��ȯ�մϴ�.
	 * @return ������ ��ǰ ��ȣ
	 * @throws Exception
	 */
	public int getLastNo(Connection conn) throws Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;

		try {
			stmt = conn.prepareStatement(SQL_LAST_GOOD_NO);
			rs = stmt.executeQuery();
			rs.next();
			int lastNo = rs.getInt("lastNo");
			return lastNo;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if(rs!=null) try {rs.close();} catch(Exception e){}
				if(stmt!=null) try {stmt.close();} catch(Exception e){}
			} catch (Exception e2) {
				System.out.println("Close Error.");
			}
		}
	}
	
	/**
	 * ��ǰ������ ���� �մϴ�.
	 * @param goodId ��ǰ�ڵ�
	 * @param goodName ��ǰ��
	 */
	public void insertGoodInfo(Connection conn, String goodId, String goodName) {
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(SQL_INSERT_GOODINFO);
			
			stmt.setString(1, goodId);
			stmt.setString(2, goodName);
			stmt.executeUpdate();
			
//			System.out.println("goodId : " + goodId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(stmt!=null) try {stmt.close();} catch(Exception e){}
		}
	}
	
}
