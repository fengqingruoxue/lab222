package choose;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
import java.util.ArrayList;
import java.util.List;
public class author {
	private static String author_Name;
	 static Connection conn;  
	  
	 static Statement st;
	 private static List<String[]> booklist = new ArrayList<String[]>();
	 public static String query(){  
	    	
	        String[] mylist = new String[6];
	        conn = getConnection(); //同样先要获取连接，即连接到数据库  
	        try {  
	            String sql = "select * from book,book where Title ='"+author_Name+"'";     // 查询数据的sql语句  
	            st = (Statement) conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量  
	        	//String sql1 = "SELECT author.* FROM author,book where Name = '"+author+"' or (Title = '"+book+"' and author.AuthorID = book.AuthorID)";
		        PreparedStatement ps1 = conn.prepareStatement(sql); 
	            ResultSet rs = st.executeQuery(sql);    //执行sql查询语句，返回查询数据的结果集  
	            while (rs.next()) { // 判断是否还有下一个数据                  
	                // 根据字段名获取相应的值
	            	mylist[0] = rs.getString("ISBN");    
	            	mylist[1] = rs.getString("Title");  
	            	mylist[2] = rs.getString("AuthorID");  
	            	mylist[3] = rs.getString("publisher");  
	            	mylist[4] = rs.getString("PublishDate");  
	            	mylist[5] = rs.getString("Price"); 
	            	booklist.add(mylist.clone());
	                //输出查到的记录的各个字段的值  
	                System.out.println(mylist[0] + " " + mylist[1] + " " + mylist[2] + " " + mylist[3]  
	                        + " " + mylist[4] + " " + mylist[5]);             
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
	public String getAuthor_Name() {
		return author_Name;
	}
	public void setAuthor_Name(String author_Name) {
		this.author_Name = author_Name;
	}
	public String execute()
	{
		System.out.println(author_Name);
		return "success";
	}
}
