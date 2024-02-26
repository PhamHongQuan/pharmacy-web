package controller;

import java.io.IOException;
import java.sql.Date;

import beans.Product;
import dao.DAOFactory;
import dao.IProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Admin_EditProduct
 */
public class Admin_EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Admin_EditProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productId = request.getParameter("productID");
		IProductDAO productDAO = DAOFactory.getInstance().getProductDAO();
		Product product = productDAO.findProductById(productId);
		String img = request.getParameter("imgUrl");
		if (img != "") {
			product.setImg(img);
		}
		String productName = request.getParameter("productName");
		if (productName != "") {
			product.setProductName(productName);
		}
		String detailUses = request.getParameter("detailUses");
		if (detailUses != "") {
			product.setDetailUses(detailUses);
		}
		String importPriceStr = request.getParameter("importPrice");
		if (importPriceStr != "") {
			double importPrice = Double.parseDouble(importPriceStr);
			product.setImportPrice(importPrice);
			
		}
		String dateOfManufactureStr = request.getParameter("dateOfmanufacture");
		if (dateOfManufactureStr != "") {
			Date dateOfManufacture = Date.valueOf(dateOfManufactureStr);
			product.setDateOfmanufacture(dateOfManufacture);
		}
		String expiryStr = request.getParameter("expiry");
		if (expiryStr != "") {
			Date expiry = Date.valueOf(expiryStr);
			product.setExpiry(expiry);
		}
		String quantityStr = request.getParameter("quantity");
		if (quantityStr != "") {
			int quantity = Integer.parseInt(quantityStr);
			product.setQuantityInStock(quantity);
		}
		productDAO.updateProduct(product);
		response.sendRedirect("./product-manage.jsp");
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
