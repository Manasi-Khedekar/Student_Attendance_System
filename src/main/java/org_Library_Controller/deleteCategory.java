package org_Library_Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org_Library_Service.CategoryService;
import org_Library_Service.CategoryServiceImpl;

@WebServlet("/deleteCategory")
public class deleteCategory extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  response.setContentType("text/html");
	  PrintWriter out=response.getWriter();
	  int categoryid=Integer.parseInt(request.getParameter("categoryid"));
	  CategoryService categoryservice=new CategoryServiceImpl();
	 boolean b=categoryservice.isDeleteCategoryById(categoryid);
	 if(b) {
		 RequestDispatcher r= request.getRequestDispatcher("viewCategory.jsp");
		 r.forward(request, response);
	 }
	 else {
		 out.println("<h1>Sorry! category not deleted.</h1>");
	 }
	  
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
