<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org_Library_Service_User.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Request For Book Search</title>
<style>
 table
 {
  margin-top:30px;
 }
</style>
</head>
<body>
   <table>
            <tr>
              <th>Sr.No</th>
              <th>Book Name</th>
              <th>Book Language</th>
              <th>Book Author</th>
              <th>Available Copies</th>
              <th>Category Name</th>
              <th>Issue Book</th>
            </tr>
            <%
            int st_id=Integer.parseInt(session.getAttribute("user_id").toString());
            String str=request.getParameter("n");
            BookServiceUser bookService=new BookServiceUserImpl();
            List<Object[]> list1=bookService.searchByBookAttribute(str);
            if(list1!=null)
            {
              int count=0;
              for(Object obj[]:list1)
               {
            %>
            <tr>
              <td><%=++count%></td>
              <td><%=obj[1]%></td>
              <td><%=obj[2]%></td>
              <td><%=obj[3]%></td>
              <td><%=obj[4]%></td>
              <td><%=obj[6]%></td>
              <td><a href="requestForBook?b_id=<%=(int)obj[0]%>&st_id=<%=st_id%>"><button type="submit" class="btn btn-primary mb-2" style="padding:5px;background-color:green;border:none;">Issue Book</button></a></td>
            </tr>
            <%
            }
            }
            else
            {           	
       %>
          <tr>
              <td>Not Available</td>
              <td>Not Available</td>
              <td>Not Available</td>
              <td>Not Available</td>
              <td>Not Available</td>
              <td>Not Available</td>
              <td>Not Available</td>
            </tr>
       <%
        } 
       %>
          </table>
</body>
</html>

