package org.myprj.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.myprj.beans.User;
import org.myprj.utils.DBUtils;
import org.myprj.utils.MyUtils;



@WebServlet(urlPatterns = { "/doLogin" })
public class DoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DoLoginServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 String mail = request.getParameter("mail");
	        String password = request.getParameter("password");

	        
	        User user = null;
	        boolean hasError = false;
	        String errorString = null;
	 
	        if (mail == null || password == null
	                 || mail.length() == 0 || password.length() == 0) {
	            hasError = true;
	            errorString = "Required username and password!";
	        } else {
	            Connection conn = MyUtils.getStoredConnection(request);
	            try {
	              
	                user = DBUtils.findUser(conn, mail, password);
	                 
	                if (user == null) {
	                    hasError = true;
	                    errorString = "User Name or password invalid";
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	                hasError = true;
	                errorString = e.getMessage();
	            }
	        }
	        
	        // If error, forward to /WEB-INF/views/login.jsp
	        if (hasError) {
	            user = new User();
	            user.setMail(mail);
	            user.setPassword(password);
	             
	        
	            // Store information in request attribute, before forward.
	            request.setAttribute("errorString", errorString);
	            request.setAttribute("user", user);
	 
	       
	            // Forward to /WEB-INF/views/login.jsp
	            RequestDispatcher dispatcher //
	            = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
	 
	            dispatcher.forward(request, response);
	        }
	     
	        // If no error
	        // Store user information in Session
	        // And redirect to userInfo page.
	        else {
	            HttpSession session = request.getSession();
	            MyUtils.storeLoginedUser(session, user);
	             
	            
	                MyUtils.storeUserCookie(response,user);
	           
	            response.sendRedirect(request.getContextPath() + "/mainPage");


	        }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
