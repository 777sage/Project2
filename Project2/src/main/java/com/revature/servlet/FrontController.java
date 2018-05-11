package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get");
		System.out.println(request.getRequestURI());
		PrintWriter pw = response.getWriter();
		response.setContentType("application/json");
		ObjectMapper map = new ObjectMapper();
		map.writeValue(pw, RequestHelper.oprocess(request));
		pw.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post");
		System.out.println(request.getRequestURI());
		PrintWriter pw = response.getWriter();
		response.setContentType("application/json");
		ObjectMapper map = new ObjectMapper();
		map.writeValue(pw, RequestHelper.oprocess(request));
		pw.flush();
	}

}
