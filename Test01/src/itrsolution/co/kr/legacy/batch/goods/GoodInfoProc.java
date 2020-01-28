package itrsolution.co.kr.legacy.batch.goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GoodInfoProc {
	
	/**
	 * GOD_GOODINFO (상품정보) Insert 쿼리
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
	 * 마지막 상품 번호 가져오는 쿼리
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
	 * 생성자
	 * @param conn
	 */
	public GoodInfoProc() {
		System.out.println("Call constructor.");
	}

	/**
	 * 마지막 상품 번호를 반환합니다.
	 * @return 마지막 상품 번호
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
	 * 상품정보를 삽입 합니다.
	 * @param goodId 상품코드
	 * @param goodName 상품명
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
