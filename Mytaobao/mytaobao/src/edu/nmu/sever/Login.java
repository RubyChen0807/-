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
		//1���Ĵ���
		request.setCharacterEncoding("gbk");
		
		//2���ҳ�洫��
		String username=request.getParameter("uname");
		String userpass=request.getParameter("upass");
		//3����ҵ���
		//����ӿڱ�̣�
		//�ӿ�   ���� = new ʵ���˽ӿڵ���Ķ���
		UserDao dao=new UserDaoImpl();
		//4ת����ͼ
		boolean ret=dao.isLogin(username, userpass);
		//�������ڴ���session
		//1.����session
		HttpSession session=request.getSession();
		if(ret){
			//ת����ͼ
			//2.session�������
			session.setAttribute("user", username);
			request.getRequestDispatcher("books.jsp").forward(request, response);
		}else{
			response.sendRedirect("login.jsp");
		}
	
	}

}
