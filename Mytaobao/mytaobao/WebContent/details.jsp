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
       //�ڻỰ��ȡ������
       List<TitlesBean> books=(List<TitlesBean>)session.getAttribute("books");
       //��������
       TitlesBean book=null;
       for(int i=0;i<books.size();i++){
    	   book=books.get(i);
    	   //����ÿһ���飬Ȼ��鿴ÿһ�����isbn�Ƿ��봫�ݹ�����isbn��ͬ
    	   if(book.getIsbn().equals(isbn)){
    		   session.setAttribute("bookTOAdd", book);
    		   //���������isbn�봫�ݹ�����isbn��ͬ��ֹͣ����
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
                <img alt="��ͼ��" src="images/<%=book.getImagefile() %>">
            </td>
            <td align="right">
                                 ͼ���� 
            </td>
            <td align="left">
                 <%=isbn%>
            </td>
        </tr>
        <tr>
             <td align="right">
                                 ͼ���Ȩ 
            </td>
            <td align="left">
                 <%=book.getCopyright()%>
            </td>
        </tr>
        <tr>
             <td align="right">
                                 ͼ��۸� 
            </td>
            <td align="left">
                                       ��<%=book.getPrice()%>
            </td>
        </tr>
         <tr>
             <td align="right">
                                 ͼ��汾 
            </td>
            <td align="left">
                <%=book.getEdittionnum()%>
            </td>
        </tr>
        <tr>
             <td align="right">
                <form action="AddBookToCart">
                    <input type="submit" value="���빺�ﳵ">
                </form> 
            </td>
            <td align="left">
              <a href="books.jsp">
                                               ��������
              </a>
            </td>
        </tr>
    </table>
</body>
</html>