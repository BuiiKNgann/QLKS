
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
 
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Nhan1
 */
@WebServlet("/Nhan")
public class Nhan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Nhan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
		res.setContentType("text/html");
		PrintWriter pwriter=res.getWriter();
		String Username = req.getParameter("Username");
		String Password = req.getParameter("Password");
		 
		 
		try {
			  Class.forName("com.mysql.jdbc.Driver");  
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlks", "root", "");
	            Statement stm= con.createStatement();
	            ResultSet rs = stm.executeQuery("select * from login where Username='"+Username+"' and Password='"+Password+"'");
	            if(rs.next()) {
	            	res.sendRedirect("home.html");
	            	//System.out.println("đã đăng nhập");
	            } else {
	            	 
					 
	             	pwriter.print("Sai Username hoặc Password");
	            }
	            con.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		pwriter.close();
	}

}