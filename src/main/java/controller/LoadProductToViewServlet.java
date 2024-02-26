package controller;

import java.io.IOException;
import java.util.List;

import beans.Product;
import dao.DAOFactory;
import dao.IProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoadProductToViewServlet
 */
public class LoadProductToViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoadProductToViewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		ProductDAOImpl dao = new ProductDAOImpl();
		IProductDAO dao = DAOFactory.getInstance().getProductDAO();
		List<Product> list = dao.selectAllProduct();
		getServletContext().setAttribute("listP", list);
//		request.getRequestDispatcher("/index.jsp").forward(request, response);
		response.sendRedirect("./index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
