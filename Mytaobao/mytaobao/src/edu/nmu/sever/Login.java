package edu.nmu.sever;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.nmu.dao.UserDao;
import edu.nmu.dao.impl.UserDaoImpl;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1中文处理
		request.setCharacterEncoding("gbk");
		
		//2获得页面传参
		String username=request.getParameter("uname");
		String userpass=request.getParameter("upass");
		//3调用业务层
		//面向接口编程：
		//接口   对象 = new 实现了接口的类的对象
		UserDao dao=new UserDaoImpl();
		//4转发视图
		boolean ret=dao.isLogin(username, userpass);
		//服务器内创建session
		//1.创建session
		HttpSession session=request.getSession();
		if(ret){
			//转发视图
			//2.session保存对象
			session.setAttribute("user", username);
			request.getRequestDispatcher("books.jsp").forward(request, response);
		}else{
			response.sendRedirect("login.jsp");
		}
	
	}

}
