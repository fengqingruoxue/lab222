package choose;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
public class chooseNew {
	private int ISBN;
	private String Title;
	private int AuthorID;
	private String publisher;
	private String PublishDate;
	private int Price;
	static Connection conn;  
	  
    static Statement st;  
	
    /* 获取数据库连接的函数*/  
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
	
    public static String insert() {  
        
        conn = getConnection(); // 首先要获取连接，即连接到数据库  
  
        try {  
            String sql = "INSERT INTO book(ISBN, Title, AuthorID,publisher, PublishDate,Price)"  
                    + " VALUES ('ISBN','Title','AuthorID','publisher','PublishDate','Price')";  // 插入数据的sql语句  
              
            st = (Statement) conn.createStatement();    // 创建用于执行静态sql语句的Statement对象  
              
            int count = st.executeUpdate(sql);  // 执行插入操作的sql语句，并返回插入数据的个数  
              
           // System.out.println("向staff表中插入 " + count + " 条数据"); //输出插入操作的处理结果  
              
            conn.close();   //关闭数据库连接  
              
        } catch (SQLException e) {  
            System.out.println("插入数据失败" + e.getMessage()); 
            return "error";
        }  
        return "success";
    }  
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public int getAuthorID() {
		return AuthorID;
	}
	public void setAuthorID(int authorID) {
		AuthorID = authorID;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublishDate() {
		return PublishDate;
	}
	public void setPublishDate(String publishDate) {
		PublishDate = publishDate;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	
	public String execute()
	{
		System.out.println(Price);
		return "success";
	}
	
}
