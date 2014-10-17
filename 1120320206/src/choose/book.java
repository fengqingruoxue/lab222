package choose;
//import com.opensymphony.xwork2.ActionSupport;
import java.sql.*;
//import java.util.*;
public class book{
	 // 创建静态全局变量  
    static Connection conn;   
    static Statement st;
	private static String book_Name;
	public String getBook_Name() {
		return book_Name;
	}
	public void setBook_Name(String book_Name) {
		this.book_Name = book_Name;
	}

	 /* 查询数据库*/  
    public static String query(){  
        conn = getConnection(); //同样先要获取连接，即连接到数据库  
        try { 
            String sql = "select * from book,book where Title='"+book_Name+"'";     // 查询数据的sql语句  
            st = (Statement) conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量  
            ResultSet rs = st.executeQuery(sql);    //执行sql查询语句，返回查询数据的结果集  
            while (rs.next()) { // 判断是否还有下一个数据                  
                // 根据字段名获取相应的值
            	int ISBN = rs.getInt("ISBN");    
            	String Title = rs.getString("Title");  
            	int AuthorID = rs.getInt("AuthorID");  
            	String publisher = rs.getString("publisher");  
            	String PublishDate = rs.getString("PublishDate");  
            	int Price = rs.getInt("Price"); 
                //输出查到的记录的各个字段的值  
                System.out.println(ISBN + " " + Title + " " + AuthorID + " " + publisher  
                        + " " + PublishDate + " " + Price);             
            }  
            conn.close();   //关闭数据库连接  
              
        } catch (SQLException e) {  
            System.out.println("查询数据失败");  
        }  
        return "success";
    }  
    
    
    public static Connection getConnection() {  
        Connection con = null;  //创建用于连接数据库的Connection对象  
        try {  
            Class.forName("com.mysql.jdbc.Driver");// 加载Mysql数据驱动  
              
            con = DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/bookdb", "root", "0000");// 创建数据连接  
              
        } catch (Exception e) {  
            System.out.println("数据库连接失败" + e.getMessage());  
        }  
        return con; //返回所建立的数据库连接  
    }  
    public String execute()
	{
		
		return "success";
	}
}
