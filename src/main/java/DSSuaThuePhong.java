

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
@WebServlet("/DSSuaThuePhong")
public class DSSuaThuePhong extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DSSuaThuePhong() {
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
	        int STT = Integer.parseInt(request.getParameter("STT"));
        String SoPhong = request.getParameter("SoPhong");
        String MaKhach = request.getParameter("MaKhach");
        Date NgayNhanPhong = Date.valueOf(request.getParameter("NgayNhanPhong"));
        Date NgayTraPhong = Date.valueOf(request.getParameter("NgayTraPhong"));
           try {
        	Class.forName("com.mysql.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlks", "root", ""); 
            Statement stmt = con.createStatement();
            String sql ="UPDATE ThuePhong SET SoPhong = ?, MaKhach = ?, NgayNhanPhong = ?, NgayTraPhong = ? WHERE STT = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, SoPhong);
            statement.setString(2, MaKhach);
            statement.setDate(3, NgayNhanPhong);
            statement.setDate(4, NgayTraPhong);
            statement.setInt(5, STT);
            statement.executeUpdate();
            response.sendRedirect("DSThuePhong.html");
stmt.close();
            statement.close();
            con.close();
             
        } catch (Exception e) {
          System.out.println("Error");
        }
        }
        
	}

 