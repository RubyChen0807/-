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
		//ʵ��JDBC6��
		//1��������
		//2��������
		//�������ݿ��������
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		//�̳�--����
		conn=BaseDao.getConn();
		try {
			//3дsql
			String sql="select userpass from user_login where username=?";
			//4д��sqlִ����
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, username);
			//5�õ����
			rs=pstmt.executeQuery();
			if(rs.next()){
				//�����ݿ��ڸ����������������
				String pass=rs.getString("userpass");
				//�ж���Ļ���������Ͳ�ѯ�������Ƿ�һ�£����һ�£���ͨ��������ֵ Ϊtrue
				if(pass.equals(userpass)){
					ret=true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//JDBC��6�����ر���Դ
			BaseDao.closeAll(conn, pstmt, rs);
		}
		
		return ret;
	}

}
