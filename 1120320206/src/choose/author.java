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
	        conn = getConnection(); //ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�  
	        try {  
	            String sql = "select * from book,book where Title ='"+author_Name+"'";     // ��ѯ���ݵ�sql���  
	            st = (Statement) conn.createStatement();    //��������ִ�о�̬sql����Statement����st���ֲ�����  
	        	//String sql1 = "SELECT author.* FROM author,book where Name = '"+author+"' or (Title = '"+book+"' and author.AuthorID = book.AuthorID)";
		        PreparedStatement ps1 = conn.prepareStatement(sql); 
	            ResultSet rs = st.executeQuery(sql);    //ִ��sql��ѯ��䣬���ز�ѯ���ݵĽ����  
	            while (rs.next()) { // �ж��Ƿ�����һ������                  
	                // �����ֶ�����ȡ��Ӧ��ֵ
	            	mylist[0] = rs.getString("ISBN");    
	            	mylist[1] = rs.getString("Title");  
	            	mylist[2] = rs.getString("AuthorID");  
	            	mylist[3] = rs.getString("publisher");  
	            	mylist[4] = rs.getString("PublishDate");  
	            	mylist[5] = rs.getString("Price"); 
	            	booklist.add(mylist.clone());
	                //����鵽�ļ�¼�ĸ����ֶε�ֵ  
	                System.out.println(mylist[0] + " " + mylist[1] + " " + mylist[2] + " " + mylist[3]  
	                        + " " + mylist[4] + " " + mylist[5]);             
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
