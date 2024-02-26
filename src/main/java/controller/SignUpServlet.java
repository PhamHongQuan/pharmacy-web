package controller;

import java.io.IOException;

import beans.Account;
import dao.DAOFactory;
import dao.ICustomerDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.EncodePassword;

/**
 * Servlet implementation class SignUpServlet
 */
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpServlet() {
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
		String fname = request.getParameter("firstName");
		String lname = request.getParameter("lastName");
		String sex = request.getParameter("sex");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String telephone = request.getParameter("telephone");
		String password = request.getParameter("password");
		String rePassword = request.getParameter("rePassword");
		String accept = request.getParameter("check");
		String role = "customer";
		password = EncodePassword.toSHA1(password);
		ICustomerDAO dao = DAOFactory.getInstance().getCustomerDAO();
		Account account = new Account(null, lname, fname, sex, email, address, telephone, password, role);
		account = dao.checkCustomerExist(email);

		if (account == null) {
			account = new Account(null, lname, fname, sex, email, address, telephone, password, role);
//			account.setPassword(EncodePassword.toSHA1(account.getPassword()));
			dao.insert(account);
			response.sendRedirect("signUp-success.jsp");
		} else {
			response.sendRedirect("signUp-fail.jsp");
		}
	}

}
