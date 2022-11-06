package edu.nmu.sever;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.nmu.entity.CartItemBean;
import edu.nmu.entity.TitlesBean;

/**
 * Servlet implementation class AddBookToCart
 */
public class AddBookToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//购物车
		//1创建session，如果之前没有创建，则创建，如果有，不创建
		HttpSession session=request.getSession(false);
		//2创建一个转发器
	    if(session==null){
	     	request.getRequestDispatcher("login.jsp").forward(request, response);
	    }
	    
	   //是不是第一次购物？如果是第一次购物，有没有购物车？？--key->(book.getIsbn())----value-->new Book(xxxx) 数量是1
	    //设计思想是：由map数据结构来实现--put(key,value)
	   //3如果之前有session,则取出对象
	    TitlesBean book=(TitlesBean)session.getAttribute("bookTOAdd");
	    //上面这句话，相当于是你在书店看了这本书的情况后，想买--->放入购物车？？？
	    //有没有购物车？？
	    //4第一次访问此代码处，也相当于第一次进书店，肯定没有购物车，就要创建新的购物车
	    Map cart=(Map)session.getAttribute("cart");
	    if(cart==null){
	    	cart=new HashMap(); //创建了一个新的购物车
	    	session.setAttribute("cart", cart); //保存新的购物车
	    }
	    //5新的购物车里有没货物--图书对象？？？
	    CartItemBean cartItem= (CartItemBean)cart.get(book.getIsbn());
	    //6.判断是否存在cartItem?(新书）
	    if(cartItem==null){
	    	CartItemBean cartit=new CartItemBean(book,1);
	    	cart.put(book.getIsbn(), cartit);
	    }else{
	    	//如果购物车中有此对象，则数量+1
	    	cartItem.setQuantity(cartItem.getQuantity()+1);
	    }
	    //7.转发视图
	    request.getRequestDispatcher("viewCart.jsp").forward(request, response);
	}

}
