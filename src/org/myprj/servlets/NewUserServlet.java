package org.myprj.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.myprj.beans.User;
import org.myprj.utils.DBUtils;
import org.myprj.utils.MySender;
import org.myprj.utils.MyUtils;



@WebServlet("/NewUserServlet")
public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public NewUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   Connection conn = MyUtils.getStoredConnection(request);
		   
	       String mail = (String) request.getParameter("mail");
	       String fName = (String) request.getParameter("fName");
	       String lName = (String) request.getParameter("lName");
	      String password;
	      final Random random = new Random();
	      
	      password = String.valueOf(random.nextInt(12));
	     String end = String.valueOf(random.nextInt(20));
	      password = "PA"+password +"Welc" + end;
	       
	       
	       User newUser = new User(mail, fName, lName, password);
	 
	       String errorString = null;
	 
	      
	       // Product ID is the string literal [a-zA-Z_0-9]
	       // with at least 1 character
	   
	 
	       if (mail == null) {
	           errorString = "Product Code invalid!";
	       }
	 
	       if (errorString == null) {
	           try {
	        	   System.out.println("qqqq");
				DBUtils.insertUser(conn, newUser);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       }
	        
	       // Store infomation to request attribute, before forward to views.
	   
	       request.setAttribute("product", newUser);
	 
	       // If error, forward to Edit page.
	       if (errorString != null) {
	           RequestDispatcher dispatcher = request.getServletContext()
	                   .getRequestDispatcher("/WEB-INF/views/singUp.jsp");
	           dispatcher.forward(request, response);
	       }
	 
	       // If everything nice.
	       // Redirect to the product listing page.            
	       else {
	    	   RequestDispatcher dispatcher = request.getServletContext()
	                   .getRequestDispatcher("/WEB-INF/views/login.jsp");
	           dispatcher.forward(request, response);
	       }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
