package edu.nmu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.nmu.dao.BaseDao;
import edu.nmu.dao.TitlesDao;
import edu.nmu.entity.TitlesBean;
/**
 * һ��ҵ�������ȼ̳и��࣬�����еķ��������ԣ���ʵ�ֽӿ�
 * @author Administrator
 *
 */
public class TitlesDaoImpl extends BaseDao implements TitlesDao {

	@Override
	public List<TitlesBean> getAll() {
		List<TitlesBean> list=new ArrayList<TitlesBean>();
		//jdbc��ѯ���ݿ⣨mysql)
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		//1��������
		//2��������(���ʸ���ķ���this,super)
		//conn=super.getConn();
		conn =this.getConn();
		//3дSQL
		String sql="select * from titles";
		try {
			//4ִ��SQLִ����
			pstmt=conn.prepareStatement(sql);
			//5�õ������������
			rs=pstmt.executeQuery();
			//����������һ��������ʹ��whileѭ����������
			while(rs.next()){
				//�����ն���
				TitlesBean book =new TitlesBean();
				//��ѯ���ݿ�Կն���ֵ
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setCopyright(rs.getString("copyright"));
				book.setEdittionnum(rs.getInt("EDITIONNUMBER"));
				book.setPublisherid(rs.getInt("publisherid"));
				book.setImagefile(rs.getString("imagefile"));
				book.setPrice(rs.getDouble("price"));
				//�Ѷ�����뵽����
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		//6�ر���Դ
			this.closeAll(conn, pstmt, rs);
		}
		return list;
	}

}
