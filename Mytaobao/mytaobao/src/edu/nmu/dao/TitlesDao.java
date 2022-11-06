package edu.nmu.dao;

import java.util.List;

import edu.nmu.entity.TitlesBean;

/***
 * 面向接口编程的好处：实现了开闭原则 ---对已有功能关闭，对新功能开放
 * @author 黄sir
 * 接口只是定义方法而不实现
 */
public interface TitlesDao {
   //查询所有图书信息
   public List<TitlesBean> getAll();
   
}
