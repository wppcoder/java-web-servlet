package com.wpp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wpp.Dao.UserDaoImpl;
import com.wpp.model.User;
import com.wpp.util.ConnectionFactory;

public class FindUserServlet extends HttpServlet {

	
	
	/**
	 * Constructor of the object.
	 */
	public FindUserServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection conn = connectionFactory.getConnection();
		String userName = request.getParameter("userName");//解决get请求参数值中文乱码
		userName =  new String(userName.getBytes("ISO8859-1"),"utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		User user = new User();
		try {
			user = userDaoImpl.getUser(conn, userName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.println(user.getDescription());
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
