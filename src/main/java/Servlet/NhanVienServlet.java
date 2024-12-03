package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import Dao.NhanVienDao;
import Entity.NhanVien;

/**
 * Servlet implementation class NhanVienServlet
 */
@WebServlet("/NhanVienServlet")
public class NhanVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NhanVienDao ud = new NhanVienDao();
		List<NhanVien> nvList = ud.getAll();
		request.setAttribute("nvList", nvList);
		request.getRequestDispatcher("view/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		switch (action) {
	        case "create":
	            createNV(request, response);
	            break;
	        case "delete":
	        	deleteNV(request, response);
	            break;
	        default:
	            break;
	    }
	}
	
	private void createNV(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String maNV = request.getParameter("ma");
        String tenNV = request.getParameter("ten");
        String diaChi = request.getParameter("diachi");
        boolean gioiTinh = request.getParameter("gioitinh").equals("male");

        NhanVien nv = new NhanVien(maNV, tenNV, diaChi, gioiTinh);
        NhanVienDao nvDAO = new NhanVienDao();
        nvDAO.createNV(nv);
        
        response.sendRedirect("NhanVienServlet");
    }
	
	private void deleteNV(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String maNV = request.getParameter("maNV");
		NhanVienDao nvDAO = new NhanVienDao();
		nvDAO.deleteNV(maNV);
		
		response.sendRedirect("NhanVienServlet");
	}

}
