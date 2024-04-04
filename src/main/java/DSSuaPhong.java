

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
@WebServlet("/DSSuaPhong")
public class DSSuaPhong extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DSSuaPhong() {
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
        String GiaTien = request.getParameter("GiaTien");
        String ConSuDung = request.getParameter("ConSuDung");
           try {
        	Class.forName("com.mysql.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlks", "root", ""); 
            Statement stmt = con.createStatement();
            String sql = "UPDATE phong SET GiaTien = ?, ConSuDung = ? WHERE SoPhong = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, GiaTien);
            statement.setString(2, ConSuDung);
            statement.setString(3, SoPhong);
             
            statement.executeUpdate();
            response.sendRedirect("DSPhong.html");
stmt.close();
            statement.close();
            con.close();
             
        } catch (Exception e) {
          System.out.println("Error");
        }
        }
        
	}

 