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
 * 一个业务类首先继承父类，拿已有的方法和属性，再实现接口
 * @author Administrator
 *
 */
public class TitlesDaoImpl extends BaseDao implements TitlesDao {

	@Override
	public List<TitlesBean> getAll() {
		List<TitlesBean> list=new ArrayList<TitlesBean>();
		//jdbc查询数据库（mysql)
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		//1加载驱动
		//2创建连接(访问父类的方法this,super)
		//conn=super.getConn();
		conn =this.getConn();
		//3写SQL
		String sql="select * from titles";
		try {
			//4执行SQL执行器
			pstmt=conn.prepareStatement(sql);
			//5得到结果集并处理
			rs=pstmt.executeQuery();
			//如果结果多于一条，必须使用while循环遍历数据
			while(rs.next()){
				//创建空对象
				TitlesBean book =new TitlesBean();
				//查询数据库对空对象赋值
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setCopyright(rs.getString("copyright"));
				book.setEdittionnum(rs.getInt("EDITIONNUMBER"));
				book.setPublisherid(rs.getInt("publisherid"));
				book.setImagefile(rs.getString("imagefile"));
				book.setPrice(rs.getDouble("price"));
				//把对象加入到集合
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		//6关闭资源
			this.closeAll(conn, pstmt, rs);
		}
		return list;
	}

}
