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
@WebServlet("/XemDSThuePhong")
public class XemDSThuePhong extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XemDSThuePhong() {
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
            String sql="select * from thuephong";
            
            ResultSet rs = stmt.executeQuery(sql);  
            out.println("<table border=1 width=500px>");
            out.println("<tr><td>STT</td><td>SoPhong</td><td>MaKhach</td><td>NgayNhanPhong</td><td>NgayTraPhong</td><td> <a href='TimPhong.html'> Tìm Kiếm  </a></td></tr>");
            while (rs.next()) 
            {  
            	int STT = rs.getInt("STT");
            	String SoPhong = rs.getString("SoPhong");  
            	String MaKhach = rs.getString("MaKhach");  
            	Date NgayNhanPhong = rs.getDate("NgayNhanPhong");
            	Date NgayTraPhong = rs.getDate("NgayTraPhong");
            	out.println("<tr><td>" + STT + "</td> <td>" + SoPhong +"</td><td>" +MaKhach + "</td> <td>" + NgayNhanPhong + "</td><td>" + NgayTraPhong + "</td> <td><a href='SuaThuePhong.html'> Sửa </a></td><td><a href='#'> Thêm </a></td><td><a href='#'> Xóa </a></td></tr>");
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