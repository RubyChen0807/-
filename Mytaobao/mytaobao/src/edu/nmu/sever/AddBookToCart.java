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
		//���ﳵ
		//1����session�����֮ǰû�д������򴴽�������У�������
		HttpSession session=request.getSession(false);
		//2����һ��ת����
	    if(session==null){
	     	request.getRequestDispatcher("login.jsp").forward(request, response);
	    }
	    
	   //�ǲ��ǵ�һ�ι������ǵ�һ�ι����û�й��ﳵ����--key->(book.getIsbn())----value-->new Book(xxxx) ������1
	    //���˼���ǣ���map���ݽṹ��ʵ��--put(key,value)
	   //3���֮ǰ��session,��ȡ������
	    TitlesBean book=(TitlesBean)session.getAttribute("bookTOAdd");
	    //������仰���൱����������꿴���Ȿ������������--->���빺�ﳵ������
	    //��û�й��ﳵ����
	    //4��һ�η��ʴ˴��봦��Ҳ�൱�ڵ�һ�ν���꣬�϶�û�й��ﳵ����Ҫ�����µĹ��ﳵ
	    Map cart=(Map)session.getAttribute("cart");
	    if(cart==null){
	    	cart=new HashMap(); //������һ���µĹ��ﳵ
	    	session.setAttribute("cart", cart); //�����µĹ��ﳵ
	    }
	    //5�µĹ��ﳵ����û����--ͼ����󣿣���
	    CartItemBean cartItem= (CartItemBean)cart.get(book.getIsbn());
	    //6.�ж��Ƿ����cartItem?(���飩
	    if(cartItem==null){
	    	CartItemBean cartit=new CartItemBean(book,1);
	    	cart.put(book.getIsbn(), cartit);
	    }else{
	    	//������ﳵ���д˶���������+1
	    	cartItem.setQuantity(cartItem.getQuantity()+1);
	    }
	    //7.ת����ͼ
	    request.getRequestDispatcher("viewCart.jsp").forward(request, response);
	}

}
