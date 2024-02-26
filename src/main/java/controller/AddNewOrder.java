package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import beans.Account;
import beans.Order;
import beans.OrderDetail;
import dao.DAOFactory;
import dao.ICustomerDAO;
import dao.IOrderDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddNewOrder
 */
public class AddNewOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String orderID= UUID.randomUUID().toString();
		String ordererEmail = request.getParameter("ordererEmail");
		String addressShipping = request.getParameter("adr");
		OrderDetail o=  (OrderDetail) request.getAttribute("item");
		List<OrderDetail> orderDetails= new ArrayList<OrderDetail>() ;
		orderDetails.add(o);
	
		ICustomerDAO dao = DAOFactory.getInstance().getCustomerDAO();
		if(ordererEmail.equals(dao.checkCustomerExist(ordererEmail))){
			Account acc= dao.findCustomerByEmail(ordererEmail);
			Order order =  new Order(orderID, acc, addressShipping, orderDetails);
			IOrderDAO oDao= DAOFactory.getInstance().getOrderDAO();
			oDao.saveOrder(order);
			request.getRequestDispatcher("order-succeed.jsp").forward(request, response);
		}
		
		else {
			request.getRequestDispatcher("order.jsp").forward(request, response);
		}
		
		
	}

}
