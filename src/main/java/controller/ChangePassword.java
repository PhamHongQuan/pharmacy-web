package controller;

import java.io.IOException;

import beans.Account;
import dao.CustomerDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.EncodePassword;

/**
 * Servlet implementation class changePassword
 */
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePassword() {
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
		String currentPass = request.getParameter("currentPassword");
		String newPass = request.getParameter("newPassword");
		String reNewPass = request.getParameter("reNewPassword");
		if (newPass.equalsIgnoreCase(reNewPass)) {
			currentPass = EncodePassword.toSHA1(currentPass);

			HttpSession session = request.getSession();
			Account user = (Account) session.getAttribute("user");

			String passwordCustomer = user.getPassword();
			currentPass = EncodePassword.toSHA1(currentPass);
			passwordCustomer = EncodePassword.toSHA1(passwordCustomer);

			if (currentPass.equalsIgnoreCase(passwordCustomer)) {
				newPass = EncodePassword.toSHA1(newPass);
				user.setPassword(newPass);
				CustomerDAOImpl c = new CustomerDAOImpl();
				c.changePassword(user);
				response.sendRedirect("changePasswordComplete.jsp");
			} else {
				response.sendRedirect("changePasswordFail.jsp");
			}
		}
	}

}
