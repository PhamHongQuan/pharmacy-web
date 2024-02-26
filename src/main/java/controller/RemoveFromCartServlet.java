package controller;

import java.io.IOException;

import beans.Order;
import beans.OrderDetail;
import beans.Product;
import dao.DAOFactory;
import dao.IOrderDAO;
import dao.IProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class RemoveFromCartServlet
 */
@WebServlet("/customer/remove-product")
public class RemoveFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveFromCartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Lấy thông tin sản phẩm cần xóa từ request
		String productId = request.getParameter("productId");

		IProductDAO productDAO = DAOFactory.getInstance().getProductDAO();
		Product product = productDAO.findProductById(productId);

		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setProduct(product);

		// Lấy giỏ hàng từ session
		HttpSession session = request.getSession();
		Order order = (Order) session.getAttribute("order");

		// Xóa sản phẩm khỏi giỏ hàng
		if (order != null) {
			order.removeItem(orderDetail);

			// Xóa sản phẩm khỏi database
			IOrderDAO orderDAO = DAOFactory.getInstance().getOrderDAO();
			orderDAO.deleteProduct(product);
		}

		// Cập nhật session với giỏ hàng mới
		session.setAttribute("order", order);

		// Chuyển hướng lại đến trang giỏ hàng
//        request.getRequestDispatcher("Cart.jsp").forward(request, response);
		response.sendRedirect("./cartCustomer.jsp");
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
