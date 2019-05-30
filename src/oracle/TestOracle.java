package oracle;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;  
public class TestOracle {
	 static Connection con = null;// 创建一个数据库连接
	    static PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
	    static ResultSet result ;
	    public static void main(String[] args) {
			
		System.out.println();
	    try
	    {
	        Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
	        System.out.println("开始尝试连接数据库！");

	        //String url = "jdbc:oracle:thin:@localhost:5500:ORCL";// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
	        //String url = "jdbc:oracle:thin:@10.37.129.3:5500:ORCL";// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
	        String url = "jdbc:oracle:thin:@192.168.31.217:1521:ORCL";// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
	        String user = "system";// 用户名,系统默认的账户名
	        String password = "Oracle12";// 你安装时选设置的密码
	        con = DriverManager.getConnection(url, user, password);// 获取连接
	        System.out.println("连接成功！");
	        ResultSet rs = null;  
	        try {  
	            pre = con.prepareStatement("select * from m_user");  
	            rs = pre.executeQuery("select * from m_user");  
	            while(rs.next()){
	            	System.out.println(rs.getString("usernames"));
	            }
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	    }
	    catch (Exception e)
	    {
	        e.printStackTrace();
	    }}
}
