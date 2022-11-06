package edu.nmu.entity;

import java.io.Serializable;

/**
 * javaBean��Ҫ������װ����POJO
 * 
 * @author ��sir һ��ʵ����Ӧ�ð��������֣�˽�л����ֶΡ����������ԣ�getter\setter)�����췽��
 */
public class TitlesBean implements Serializable {
	//˽�л����ֶ�
	private String isbn;
	private String title;
	private int edittionnum;
	private String copyright;
	private int publisherid;
	private String imagefile;
	private double price;
    //���������ԣ�get&set)
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getEdittionnum() {
		return edittionnum;
	}

	public void setEdittionnum(int edittionnum) {
		this.edittionnum = edittionnum;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public int getPublisherid() {
		return publisherid;
	}

	public void setPublisherid(int publisherid) {
		this.publisherid = publisherid;
	}

	public String getImagefile() {
		return imagefile;
	}

	public void setImagefile(String imagefile) {
		this.imagefile = imagefile;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
    //�������췽�����գ�ȫ�εģ�
	public TitlesBean() {

	}

	public TitlesBean(String isbn, String title, int edittionnum, String copyright, int publisherid, String imagefile,
			double price) {

		this.isbn = isbn;
		this.title = title;
		this.edittionnum = edittionnum;
		this.copyright = copyright;
		this.publisherid = publisherid;
		this.imagefile = imagefile;
		this.price = price;
	}

}
