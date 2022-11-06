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
   <h3>购物车清单如下：</h3>
 <%
     Map cart=(Map)session.getAttribute("cart");
     //有了思想再写代码
     //总计：
     double total=0;
     if(cart==null||cart.size()==0){
    	 out.println("购物车为空，您还没有购物，请返回");
     }else{
    	Set cartItems=cart.keySet();//健的集合
    	Object[] isbn=cartItems.toArray();  //转化为数组
    	//转化的目的做循环操作
    	CartItemBean cartItem;
    	TitlesBean book =null;
    	int quantity=0;
    	double price,subtotal;  //单价与小计
    %>
    	<table width="590" border="1">
    	   <tr>
    	      <th>图书名称</th>
    	      <th>数量</th>
    	      <th>价格</th>
    	      <th>小计</th>
    	   </tr>
    	  <%
    	    int i=0;
    	    while(i<isbn.length){
    	    	cartItem=(CartItemBean)cart.get(isbn[i]);
    	    	book=cartItem.getBook(); //图书对象
    	    	quantity=cartItem.getQuantity();//数量
    	    	price =book.getPrice();//单价
    	    	subtotal=price*quantity; //小计
    	    	total += subtotal; //总计
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
    	          <b>总计:</b>
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
            继续购物
        </a>
   </p>
</body>
</html>