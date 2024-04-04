

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DSTimKhach
 */
@WebServlet("/DSTimTrangBi")
public class DSTimThuePhong extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DSTimThuePhong() {
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
	            String searchSql = "SELECT * FROM thuephong WHERE SoPhong LIKE ?";
	            PreparedStatement searchStatement = con.prepareStatement(searchSql);
	            searchStatement.setString(1, "%" + searchQuery + "%");

	            ResultSet resultSet = searchStatement.executeQuery();

	            out.println("<h2>Tìm Số Phòng:</h2>");

	            while (resultSet.next()) {
	            	  int STT = Integer.parseInt(request.getParameter("STT"));
	                String SoPhong = resultSet.getString("SoPhong");
	                String MaThietBi = resultSet.getString("MaThietBi");
	                Date NgayBatDauTrangBi= resultSet.getDate("NgayBatDauTrangBi");
	                Date NgayKetThucTrangBi= resultSet.getDate("NgayKetThucTrangBi");
	                out.println("<p>STT: " + STT + "</p>");
	                out.println("<p>SoPhong: " + SoPhong + "</p>");
	                out.println("<p>MaThietBi: " + MaThietBi + "</p>");
	                out.println("<p>NgayBatDauTrangBi: " + NgayBatDauTrangBi + "</p>");
	                out.println("<p>NgayKetThucTrangBi: " + NgayKetThucTrangBi + "</p>");

	            }

	            out.println("</body></html>");
	        } catch (Exception e) {
	            e.printStackTrace();
	            out.println("An error occurred while performing the search.");
	        }
	    }
	}
