package choose;
//import com.opensymphony.xwork2.ActionSupport;
import java.sql.*;
//import java.util.*;
public class book{
	 // ������̬ȫ�ֱ���  
    static Connection conn;   
    static Statement st;
	private static String book_Name;
	public String getBook_Name() {
		return book_Name;
	}
	public void setBook_Name(String book_Name) {
		this.book_Name = book_Name;
	}

	 /* ��ѯ���ݿ�*/  
    public static String query(){  
        conn = getConnection(); //ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�  
        try { 
            String sql = "select * from book,book where Title='"+book_Name+"'";     // ��ѯ���ݵ�sql���  
            st = (Statement) conn.createStatement();    //��������ִ�о�̬sql����Statement����st���ֲ�����  
            ResultSet rs = st.executeQuery(sql);    //ִ��sql��ѯ��䣬���ز�ѯ���ݵĽ����  
            while (rs.next()) { // �ж��Ƿ�����һ������                  
                // �����ֶ�����ȡ��Ӧ��ֵ
            	int ISBN = rs.getInt("ISBN");    
            	String Title = rs.getString("Title");  
            	int AuthorID = rs.getInt("AuthorID");  
            	String publisher = rs.getString("publisher");  
            	String PublishDate = rs.getString("PublishDate");  
            	int Price = rs.getInt("Price"); 
                //����鵽�ļ�¼�ĸ����ֶε�ֵ  
                System.out.println(ISBN + " " + Title + " " + AuthorID + " " + publisher  
                        + " " + PublishDate + " " + Price);             
            }  
            conn.close();   //�ر����ݿ�����  
              
        } catch (SQLException e) {  
            System.out.println("��ѯ����ʧ��");  
        }  
        return "success";
    }  
    
    
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
    public String execute()
	{
		
		return "success";
	}
}
