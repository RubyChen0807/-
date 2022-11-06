package edu.nmu.entity;

import java.io.Serializable;
/***
 * 此类的目的封装数据---封装数据的javaBean
 * @author 黄sir
 * BOOK--book---getPrice()方法--price
 * 数量对象----quantity
 * 
 * price*quantity--->小计
 *
 */
public class CartItemBean implements Serializable {
    //封装book对象
	private TitlesBean book;
	//封装数量
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
