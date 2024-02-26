package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import beans.Account;
import beans.Order;
import beans.OrderDetail;
import beans.Product;
import dao.DAOFactory;
import dao.ICustomerDAO;
import dao.IOrderDAO;
import dao.ProductDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class AddToCartServlet
 */

public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToCartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int quantity = 1;
		String productId = request.getParameter("productID");
		String customerId = request.getParameter("customerID");
		ICustomerDAO customerDAO = DAOFactory.getInstance().getCustomerDAO();
		Account account = customerDAO.findCustomerByID(customerId);
		if (productId != null) {
			ProductDAOImpl productDAO = new ProductDAOImpl();
			Product product = productDAO.findProductById(productId);
			if (product != null) {
				HttpSession session = request.getSession();
				// add new product to cart
				if (session.getAttribute("order") == null) {
					Order order = new Order();
					List<OrderDetail> listItems = new ArrayList<OrderDetail>();
					OrderDetail item = new OrderDetail();
					item.setProduct(product);
					item.setQuantity(quantity);
					item.setSalePrice(product.getPriceSale());
					order.setCustomer(account);
					listItems.add(item);
					order.setOrderDetails(listItems);

					// save db
					IOrderDAO orderDAO = DAOFactory.getInstance().getOrderDAO();
					orderDAO.saveOrder(order);

					session.setAttribute("order", order);
				} else {
					Order order = (Order) session.getAttribute("order");
					List<OrderDetail> listItems = order.getOrderDetails();
					boolean check = false;
					for (OrderDetail o : listItems) {
						if (o.getProduct().getProductID().equals(product.getProductID())) {
							o.setQuantity(o.getQuantity() + quantity);
							check = true;
						}
					}
					// product not exists in cart
					if (check == false) {
						OrderDetail item = new OrderDetail();
						item.setQuantity(quantity);
						item.setProduct(product);
						item.setSalePrice(product.getPriceSale());
						listItems.add(item);
					}
					order.setCustomer(account);

					// save db
					IOrderDAO orderDAO = DAOFactory.getInstance().getOrderDAO();
					orderDAO.saveOrder(order);

					session.setAttribute("order", order);
				}
			}
			request.getRequestDispatcher("/product.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/product.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
