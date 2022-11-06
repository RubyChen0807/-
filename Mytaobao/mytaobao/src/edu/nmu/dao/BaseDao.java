package edu.nmu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ���ฺ�����ݿ��������ر�
 * @author ��sir
 *
 */
public class BaseDao {
   /**
    * ���ݿ����ӵ��Ĵ����
    */
	public static final String DIVER="com.mysql.jdbc.Driver";
	public static final String USER="root";
	public static final String URL="jdbc:mysql://localhost:3306/my_shop?useSSL=false";
	public static final String PASS="root";
	
	/**
	 * �������ݿ�ķ���---JDBC����ǰ����д�ڴ�
	 */
	public static Connection getConn(){
		Connection conn=null;
		try {
			//1��������
			Class.forName(DIVER);
			//2��������
			conn=DriverManager.getConnection(URL,USER,PASS);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * �ر���Դ---JDBC��6���������ڴ˴���
	 * 
	 */
	public static void closeAll(Connection conn,PreparedStatement pstmt,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
			
}
