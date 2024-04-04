

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DSTimKhach
 */
@WebServlet("/DSTimPhong")
public class DSTimPhong extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DSTimPhong() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8"); 
		request.setCharacterEncoding("UTF-8"); request.setCharacterEncoding("UTF-8");
		 PrintWriter out = response.getWriter();  
	        response.setContentType("text/html; charset='UTF-8'");
	        out.println("<html><meta charset='UTF-8'><body>"); 
	        String searchQuery = request.getParameter("query");
	        try  {
	        	Class.forName("com.mysql.jdbc.Driver");  
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlks", "root", ""); 
	            String searchSql = "SELECT * FROM phong WHERE SoPhong LIKE ?";
	            PreparedStatement searchStatement = con.prepareStatement(searchSql);
	            searchStatement.setString(1, "%" + searchQuery + "%");

	            ResultSet resultSet = searchStatement.executeQuery();

	            out.println("<html><body>");
	            out.println("<h2>Tìm Số Phòng:</h2>");

	            while (resultSet.next()) {
	                String SoPhong = resultSet.getString("SoPhong");
	                String GiaTien = resultSet.getString("GiaTien");
	                String ConSuDung = resultSet.getString("ConSuDung");
	                

	                out.println("<p>MaKhach: " + SoPhong + "</p>");
	                out.println("<p>TenKhach: " + GiaTien + "</p>");
	                out.println("<p>ConSuDung: " + ConSuDung + "</p>");
	                 
	            }

	            out.println("</body></html>");
	        } catch (Exception e) {
	            e.printStackTrace();
	            out.println("An error occurred while performing the search.");
	        }
	    }
	}
