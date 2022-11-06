<%@page import="edu.nmu.entity.TitlesBean"%>
<%@page import="java.util.List"%>
<%@page import="edu.nmu.dao.impl.TitlesDaoImpl"%>
<%@page import="edu.nmu.dao.TitlesDao"%>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
    <h2>以下是所有商品信息</h2>
    <%  String name =(String)session.getAttribute("user");
         out.println("欢迎"+name);
        //jsp:java写的server Pages
        //调用接口 
        //接口   对象 =new 实现了接口的类的对象
        TitlesDao dao=new TitlesDaoImpl();
        //查询数据库得到所有商品对象列表
        List<TitlesBean> books=dao.getAll();
        //采用会话技术，把商品列表保存在会话中
        //jsp页面内直接使用session(jsp内置对象)
        session.setAttribute("books", books);
        out.println("共查询到了"+books.size()+"本书");
        
    %>
    <table width="980" border="0" bgcolor="pink">
         <%
            for(int i=0;i<books.size();i++){
            	TitlesBean book =books.get(i);
            	if(i%5==0){
          %>  	
            <tr>
                     <%}
            	%>
            	<td>
                <table >
                   <tr>
                      <td align="center">
                       <a href="details.jsp?isbn=<%=book.getIsbn() %>">
                       <img alt="好图书" src="images/<%=book.getImagefile() %>" width="150" height="200">
                       </a>
                     </td>
                   </tr>
                   <tr>
                      <td align="center">
                       <a href="details.jsp?isbn=<%=book.getIsbn() %>">
                      <%=getStr(book.getTitle()) %>
                      </a>
                      </td>
                   </tr>
                   <tr>
                      <td align="center">
                      <font  color="red">
                      <%=book.getPrice() %>
                      </font>
                      </td>
                   </tr>
                </table>
            </td>	
            	<%
            	if(i%5==4){
            %>	
            </tr>	
            <%	}
            }
         %>
    </table>
</body>
</html>
<%!
    public String getStr(String str){
	String ret=str;
	if(str.length()>15){
		ret=str.substring(0, 15);
	}
	return ret;
}
%>