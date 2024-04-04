
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
 * Servlet implementation class XemDS
 */
@WebServlet("/XemDSKhach")
public class XemDSKhach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XemDSKhach() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8"); 
		
		req.setCharacterEncoding("UTF-8"); req.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
        PrintWriter out = res.getWriter();  
        res.setContentType("text/html; charset='UTF-8'");
        out.println("<html><meta charset='UTF-8'><body>");  
        
        try 
        {  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlks", "root", "");  
            Statement stmt = con.createStatement();  
            String sql="select * from khach";
            
            ResultSet rs = stmt.executeQuery(sql);  
            out.println("<table border=1 width=500px>");
            out.println("<tr><td>MaKhach</td><td>TenKhach</td><td>CCCD</td><td>DienThoai</td><td> <a href='TimKhach.html'> Tìm Kiếm  </a></td></tr>");
            
            while (rs.next()) 
            {  
            	String MaKhach = rs.getString("MaKhach");
            	String TenKhach = rs.getString("TenKhach");  
            	String CCCD = rs.getString("CCCD");  
            	String DienThoai = rs.getString("DienThoai"); 
            	 
            	
            	out.println("<tr><td>" + MaKhach + "</td> <td>" + TenKhach +"</td><td>" +CCCD + "</td> <td>" + DienThoai + "</td> <td><a href='SuaKhach.html'> Sửa </a></td><td><a href='#'> Thêm </a></td><td><a href='#'> Xóa </a></td> </tr>");
            }  
            out.println("</table>");
            out.println("</html></body>");  
            con.close();  
         }  
            catch (Exception e) 
           {  
            out.println("error");  
        }  
    }  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		
		
	}

}