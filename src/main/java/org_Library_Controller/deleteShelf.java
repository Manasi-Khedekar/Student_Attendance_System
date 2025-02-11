package org_Library_Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org_Library_Service.shelfService;
import org_Library_Service.shelfServiceImpl;


@WebServlet("/deleteShelf")
public class deleteShelf extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   response.setContentType("text/html");
	   PrintWriter out=response.getWriter();
	   int shelfid=Integer.parseInt(request.getParameter("shelfid"));
	   shelfService shelfservice=new shelfServiceImpl();
	   boolean b=shelfservice.isDeleteShelfById(shelfid);
	   if(b){
		   RequestDispatcher r=request.getRequestDispatcher("viewShelf.jsp");
		   r.forward(request, response);
		   
	   }
	   else {
		   
		   out.println("<h1>Sorry! Shelf not deleted...</h1>");
	   }
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
