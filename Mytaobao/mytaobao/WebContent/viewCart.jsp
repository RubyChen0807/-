<%@page import="java.text.DecimalFormat"%>
<%@page import="edu.nmu.entity.CartItemBean"%>
<%@page import="edu.nmu.entity.TitlesBean"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
   <h3>���ﳵ�嵥���£�</h3>
 <%
     Map cart=(Map)session.getAttribute("cart");
     //����˼����д����
     //�ܼƣ�
     double total=0;
     if(cart==null||cart.size()==0){
    	 out.println("���ﳵΪ�գ�����û�й���뷵��");
     }else{
    	Set cartItems=cart.keySet();//���ļ���
    	Object[] isbn=cartItems.toArray();  //ת��Ϊ����
    	//ת����Ŀ����ѭ������
    	CartItemBean cartItem;
    	TitlesBean book =null;
    	int quantity=0;
    	double price,subtotal;  //������С��
    %>
    	<table width="590" border="1">
    	   <tr>
    	      <th>ͼ������</th>
    	      <th>����</th>
    	      <th>�۸�</th>
    	      <th>С��</th>
    	   </tr>
    	  <%
    	    int i=0;
    	    while(i<isbn.length){
    	    	cartItem=(CartItemBean)cart.get(isbn[i]);
    	    	book=cartItem.getBook(); //ͼ�����
    	    	quantity=cartItem.getQuantity();//����
    	    	price =book.getPrice();//����
    	    	subtotal=price*quantity; //С��
    	    	total += subtotal; //�ܼ�
    	    	i++;
    	    	%>
    	   <tr>
    	       <td><%=book.getTitle() %></td>
    	       <td><%=quantity%></td>
    	       <td><%=new DecimalFormat("0.00").format(price)%></td>
    	       <td><%=new DecimalFormat("0.00").format(subtotal)%></td>
    	   </tr>
    	<%    } 
    	  %>
    	  <tr>
    	       <td>
    	          <b>�ܼ�:</b>
    	          <%=new DecimalFormat("0.00").format(total)%>
    	       </td>
    	  </tr>
    	</table>
    <% }
 %>
  <%
    session.setAttribute("total", total);
  %>
   <p>
        <a href="books.jsp">
            ��������
        </a>
   </p>
</body>
</html>