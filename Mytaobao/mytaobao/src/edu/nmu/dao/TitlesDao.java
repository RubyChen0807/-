package edu.nmu.dao;

import java.util.List;

import edu.nmu.entity.TitlesBean;

/***
 * ����ӿڱ�̵ĺô���ʵ���˿���ԭ�� ---�����й��ܹرգ����¹��ܿ���
 * @author ��sir
 * �ӿ�ֻ�Ƕ��巽������ʵ��
 */
public interface TitlesDao {
   //��ѯ����ͼ����Ϣ
   public List<TitlesBean> getAll();
   
}
