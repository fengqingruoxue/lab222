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
	
    /* ��ȡ���ݿ����ӵĺ���*/  
    public static Connection getConnection() {  
        Connection con = null;  //���������������ݿ��Connection����  
        try {  
            Class.forName("com.mysql.jdbc.Driver");// ����Mysql��������  
              
            con = DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/bookdb", "root", "0000");// ������������  
              
        } catch (Exception e) {  
            System.out.println("���ݿ�����ʧ��" + e.getMessage());  
        }  
        return con; //���������������ݿ�����  
    }  
	
    public static String insert() {  
        
        conn = getConnection(); // ����Ҫ��ȡ���ӣ������ӵ����ݿ�  
  
        try {  
            String sql = "INSERT INTO book(ISBN, Title, AuthorID,publisher, PublishDate,Price)"  
                    + " VALUES ('ISBN','Title','AuthorID','publisher','PublishDate','Price')";  // �������ݵ�sql���  
              
            st = (Statement) conn.createStatement();    // ��������ִ�о�̬sql����Statement����  
              
            int count = st.executeUpdate(sql);  // ִ�в��������sql��䣬�����ز������ݵĸ���  
              
           // System.out.println("��staff���в��� " + count + " ������"); //�����������Ĵ�����  
              
            conn.close();   //�ر����ݿ�����  
              
        } catch (SQLException e) {  
            System.out.println("��������ʧ��" + e.getMessage()); 
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
