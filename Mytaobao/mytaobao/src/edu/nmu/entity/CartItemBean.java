package edu.nmu.entity;

import java.io.Serializable;
/***
 * �����Ŀ�ķ�װ����---��װ���ݵ�javaBean
 * @author ��sir
 * BOOK--book---getPrice()����--price
 * ��������----quantity
 * 
 * price*quantity--->С��
 *
 */
public class CartItemBean implements Serializable {
    //��װbook����
	private TitlesBean book;
	//��װ����
	private int quantity;
	public CartItemBean() {
		
	}
	public CartItemBean(TitlesBean book, int quantity) {
		this.book = book;
		this.quantity = quantity;
	}
	public TitlesBean getBook() {
		return book;
	}
	public int getQuantity() {
		return quantity;
	}
	
	public void setBook(TitlesBean book) {
		this.book = book;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
