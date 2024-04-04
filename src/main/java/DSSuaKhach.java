

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
@WebServlet("/DSSuaKhach")
public class DSSuaKhach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DSSuaKhach() {
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
		String MaKhach = request.getParameter("MaKhach");
        String TenKhach = request.getParameter("TenKhach");
        String CCCD = request.getParameter("CCCD");
        String DienThoai = request.getParameter("DienThoai");
        try {
        	Class.forName("com.mysql.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlks", "root", ""); 
            Statement stmt = con.createStatement();
            String sql = "UPDATE khach SET TenKhach = ?, CCCD = ?, DienThoai = ? WHERE MaKhach = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, TenKhach);
            statement.setString(2, CCCD);
            statement.setString(3, DienThoai);
            statement.setString(4, MaKhach);
            statement.executeUpdate();
            response.sendRedirect("DSKhach.html");
stmt.close();
            statement.close();
            con.close();
             
        } catch (Exception e) {
          System.out.println("Error");
        }
        }
        
	}

 
