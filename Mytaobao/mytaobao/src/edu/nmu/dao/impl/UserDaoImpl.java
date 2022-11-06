package edu.nmu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.nmu.dao.BaseDao;
import edu.nmu.dao.UserDao;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public boolean isLogin(String username, String userpass) {
		boolean ret=false;
		//实现JDBC6步
		//1加载驱动
		//2创建连接
		//创建数据库三大对象
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		//继承--父类
		conn=BaseDao.getConn();
		try {
			//3写sql
			String sql="select userpass from user_login where username=?";
			//4写出sql执行器
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, username);
			//5得到结果
			rs=pstmt.executeQuery();
			if(rs.next()){
				//从数据库内根据列名查出的密码
				String pass=rs.getString("userpass");
				//判断屏幕输入的密码和查询的密码是否一致，如果一致，则通过，返回值 为true
				if(pass.equals(userpass)){
					ret=true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//JDBC第6步：关闭资源
			BaseDao.closeAll(conn, pstmt, rs);
		}
		
		return ret;
	}

}
