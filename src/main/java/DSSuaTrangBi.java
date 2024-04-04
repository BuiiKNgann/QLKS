

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DSUpDateKhach
 */
@WebServlet("/DSSuaTrangBi")
public class DSSuaTrangBi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DSSuaTrangBi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8"); 
		request.setCharacterEncoding("UTF-8"); request.setCharacterEncoding("UTF-8");
		 PrintWriter out = response.getWriter();  
	        response.setContentType("text/html; charset='UTF-8'");
	        out.println("<html><meta charset='UTF-8'><body>");  
		
		
		// TODO Auto-generated method stub
	       
        String SoPhong = request.getParameter("SoPhong");
        String MaThietBi = request.getParameter("MaThietBi");
        Date NgayBatDauTrangBi = Date.valueOf(request.getParameter("NgayBatDauTrangBi"));
        Date NgayKetThucTrangBi = Date.valueOf(request.getParameter("NgayKetThucTrangBi"));
           try {
        	Class.forName("com.mysql.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlks", "root", ""); 
            Statement stmt = con.createStatement();
            String sql ="UPDATE TrangBi SET  MaThietBi = ?, NgayBatDauTrangBi = ?, NgayKetThucTrangBi = ? WHERE SoPhong= ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, MaThietBi);
             
            statement.setDate(2, NgayBatDauTrangBi);
            statement.setDate(3, NgayKetThucTrangBi);
            statement.setString(4, SoPhong);
            statement.executeUpdate();
            response.sendRedirect("DSTrangBi.html");
stmt.close();
            statement.close();
            con.close();
             
        } catch (Exception e) {
          System.out.println("Error");
        }
        }
        
	}

 