<%@page import="edu.nmu.entity.TitlesBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
    <%
       String isbn=request.getParameter("isbn");
       out.println("isbn="+isbn);
       //在会话内取出对象
       List<TitlesBean> books=(List<TitlesBean>)session.getAttribute("books");
       //遍历集合
       TitlesBean book=null;
       for(int i=0;i<books.size();i++){
    	   book=books.get(i);
    	   //遍历每一本书，然后查看每一本书的isbn是否与传递过来的isbn相同
    	   if(book.getIsbn().equals(isbn)){
    		   session.setAttribute("bookTOAdd", book);
    		   //如果遍历的isbn与传递过来的isbn相同，停止查找
    		   break;
    	   }
       }
    %>
    <table  border="1">
        <tr>
             <th colspan="3">
                 <%=book.getTitle() %>
             </th>
        </tr>
        <tr>
            <td rowspan="4" align="center">
                <img alt="好图书" src="images/<%=book.getImagefile() %>">
            </td>
            <td align="right">
                                 图书编号 
            </td>
            <td align="left">
                 <%=isbn%>
            </td>
        </tr>
        <tr>
             <td align="right">
                                 图书版权 
            </td>
            <td align="left">
                 <%=book.getCopyright()%>
            </td>
        </tr>
        <tr>
             <td align="right">
                                 图书价格 
            </td>
            <td align="left">
                                       ￥<%=book.getPrice()%>
            </td>
        </tr>
         <tr>
             <td align="right">
                                 图书版本 
            </td>
            <td align="left">
                <%=book.getEdittionnum()%>
            </td>
        </tr>
        <tr>
             <td align="right">
                <form action="AddBookToCart">
                    <input type="submit" value="放入购物车">
                </form> 
            </td>
            <td align="left">
              <a href="books.jsp">
                                               继续购物
              </a>
            </td>
        </tr>
    </table>
</body>
</html>