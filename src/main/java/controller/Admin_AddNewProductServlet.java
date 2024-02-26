package controller;

import java.io.IOException;
import java.sql.Date;

import beans.Manufacture;
import beans.Product;
import dao.DAOFactory;
import dao.IManufatureDAO;
import dao.IProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Admin_AddNewProductServlet
 */
public class Admin_AddNewProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Admin_AddNewProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String img = request.getParameter("imgUrl");
		String productName = request.getParameter("productName");
		String detailUses = request.getParameter("detailUses");
		double importPrice = Double.parseDouble(request.getParameter("importPrice"));
		Date dateOfmanufacture = Date.valueOf(request.getParameter("dateOfmanufacture"));
		Date expiry = Date.valueOf(request.getParameter("expiry"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String manufactureName = request.getParameter("manufactureName");
		String newManufactureName = request.getParameter("newManufactureName");
		String manufactureAddress = "";
		Date dateEstablish = null;
		Manufacture manufacture = null;

		IManufatureDAO manufatureDAO = DAOFactory.getInstance().getManufatureDAO();
		if (manufatureDAO.findByName(manufactureName) != null) {
			manufacture = manufatureDAO.findByName(manufactureName);
		} else {
			manufactureAddress = request.getParameter("manufactureAddress");
			dateEstablish = Date.valueOf(request.getParameter("dateEstablish"));
			manufacture = new Manufacture(newManufactureName, manufactureAddress, dateEstablish);
			manufatureDAO.addNewManufacture(manufacture);
		}
		img = "./img/imgProduct/" + img;
		Product newProduct = new Product(null,productName, manufacture, importPrice, quantity, detailUses, dateOfmanufacture,
				expiry, img);

		IProductDAO productDAO = DAOFactory.getInstance().getProductDAO();
		productDAO.addNewProduct(newProduct);
//		response.sendRedirect("./product-manage.jsp");
		request.getRequestDispatcher("./product-manage.jsp").forward(request, response);
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
