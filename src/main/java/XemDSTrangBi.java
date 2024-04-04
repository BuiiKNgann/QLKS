
  import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class XemDS
 */
@WebServlet("/XemDSTrangBi")
public class XemDSTrangBi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XemDSTrangBi() {
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
            String sql="select * from trangbi";
            
            ResultSet rs = stmt.executeQuery(sql);  
            out.println("<table border=1 width=500px>");
            out.println("<tr><td>SoPhong</td><td>MaThietBi</td><td>NgayBatDauTrangBi</td><td>NgayKetThucTrangBi</td><td> <a href='TimTrangBi.html'> Tìm Kiếm  </a></td></tr>");
            while (rs.next()) 
            {  
            	String SoPhong = rs.getString("SoPhong");
            	String MaThietBi = rs.getString("MaThietBi");  
            	 Date NgayBatDauTrangBi= rs.getDate("NgayBatDauTrangBi");
            	 Date NgayKetThucTrangBi= rs.getDate("NgayKetThucTrangBi");
            	out.println("<tr><td>" + SoPhong + "</td> <td>" + MaThietBi +"</td><td>" + NgayBatDauTrangBi+ "</td> <td>" + NgayKetThucTrangBi + "</td>  <td><a href='SuaTrangBi.html'> Sửa </a></td><td><a href='#'> Thêm </a></td><td><a href='#'> Xóa </a></td></tr>");
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