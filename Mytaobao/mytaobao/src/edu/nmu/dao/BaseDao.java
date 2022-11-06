package edu.nmu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 此类负责数据库的连接与关闭
 * @author 黄sir
 *
 */
public class BaseDao {
   /**
    * 数据库连接的四大对象
    */
	public static final String DIVER="com.mysql.jdbc.Driver";
	public static final String USER="root";
	public static final String URL="jdbc:mysql://localhost:3306/my_shop?useSSL=false";
	public static final String PASS="root";
	
	/**
	 * 连接数据库的方法---JDBC操作前两步写在此
	 */
	public static Connection getConn(){
		Connection conn=null;
		try {
			//1加载驱动
			Class.forName(DIVER);
			//2创建连接
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
	 * 关闭资源---JDBC第6步，集中在此处理
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
