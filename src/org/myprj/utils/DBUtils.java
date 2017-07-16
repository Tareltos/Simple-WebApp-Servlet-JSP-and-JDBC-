package org.myprj.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.myprj.beans.Product;
import org.myprj.beans.User;


public class DBUtils {

	  public static User findUser(Connection conn, String mail, String password) throws SQLException {
		  String sql = "Select \"user_name\", \"firstName\", \"lastName\", \"password\" from public.\"USERS\" where \"user_name\" =  ?  and \"password\" = ?";

	      PreparedStatement pstm = conn.prepareStatement(sql);
	      pstm.setString(1, mail);
	      pstm.setString(2, password);
	      ResultSet rs = pstm.executeQuery();
	 
	      if (rs.next()) {
	          User user = new User();
	          user.setMail(mail);
	          user.setPassword(password);
	          user.setUserfName(rs.getString("firstName"));
	          user.setUserLName(rs.getString("lastName"));
	       
	         
	          return user;
	      }
	      return null;
	  }
	 
	  public static User findUser(Connection conn, String mail) throws SQLException {
	 
		  String sql = "Select \"user_name\", \"firstName\", \"lastName\", \"password\" from public.\"USERS\" where \"user_name\" =  ?  ";
		
	      
	      PreparedStatement pstm = conn.prepareStatement(sql);
	  
	      pstm.setString(1, mail);
	 
	      ResultSet rs = pstm.executeQuery();
	 
	      if (rs.next()) {
	          String password = rs.getString("Password");
	          User user = new User();
	          user.setMail(mail);
	          user.setPassword(password);
	          user.setUserfName(rs.getString("firstName"));
	          user.setUserLName(rs.getString("lastName"));
	          return user;
	      }
	      return null;
	  }

	public static void insertUser(Connection conn, User newUser) throws SQLException {
		String sql = "Insert into public.\"USERS\" (\"user_name\", \"firstName\",\"lastName\",\"password\") values (?,?,?,?)";
		 
	      PreparedStatement pstm = conn.prepareStatement(sql);
	 
	      pstm.setString(1, newUser.getMail());
	      pstm.setString(2, newUser.getUserfName());
	      pstm.setString(3, newUser.getUserLName());
	      pstm.setString(4, newUser.getPassword());
	 
	      pstm.executeUpdate();
	      //MySender s = new MySender("tareltos@gmail.com", "tareltos777");
	      //s.send("Регистрация для PriceAnalysis", "Вы успешно прошли регистрацию!" + "\n" + "\n"+ "Ваш пароль : "+ newUser.getPassword() + "\n"+"Для входа в кабинет пройдите по ссылке: " + "\n", "tareltos@gmail.com", newUser.getMail());
		
	  
		
	}

	public static List<Product> queryProduct(Connection conn) throws SQLException {
		List<Product> list = new ArrayList<Product>();
		String sql = "Select * from public.\"spareParts\"";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		while(rs.next())
		{
			String code = rs.getString("CODE");
			String part_name = rs.getString("part_name");
			String group = rs.getString("group");
			String brand = rs.getString("brand");
			double discount = rs.getDouble("discount");
			double opt_price = rs.getDouble("opt_price");
			double rzn_price = rs.getDouble("rzn_price");
			
			list.add(new Product(code, part_name, group, brand, discount, opt_price, rzn_price));
					
		}
		
		return list;
	}
	
	 
	
}