package controller;

import java.io.IOException;

import beans.Account;
import dao.DAOFactory;
import dao.ICustomerDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.EncodePassword;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String passwordAdmin = request.getParameter("password");
		password = EncodePassword.toSHA1(password);

		ICustomerDAO dao = DAOFactory.getInstance().getCustomerDAO();
		Account user = dao.selectByEmailAndPassword(email, password);
		Account admin = dao.selectByEmailAndPassword(email, passwordAdmin);

		if (user != null) {
			if (user.getAccountRole().equalsIgnoreCase("customer")) {
				HttpSession session = request.getSession(true);
				session.setAttribute("user", user);
				session.setAttribute("role", user.getAccountRole());
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/loginError.jsp");
				rd.forward(request, response);
			}
		} else if (admin != null) {
			if (admin.getAccountRole().equalsIgnoreCase("admin")) {
				HttpSession session = request.getSession(true);
				session.setAttribute("user", admin);
				session.setAttribute("role", admin.getAccountRole());
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/loginError.jsp");
				rd.forward(request, response);
			}
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/loginError.jsp");
			rd.forward(request, response);
		}
	}

}
