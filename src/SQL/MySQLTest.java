package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLTest {
	 private Connection conn = null;  
	 PreparedStatement statement = null;  
	 
	 public MySQLTest(){
		 String url = "jdbc:mysql://localhost:3306/mysql?characterEncoding=UTF-8";  
	        String username = "root";  
	        String password = "ljlj"; // 加载驱动程序以连接数据库   
	        try {   
	            Class.forName("com.mysql.jdbc.Driver" );   
	            conn = DriverManager.getConnection( url,username, password );  
	            System.out.println("连接成功");
	            }  
	        //捕获加载驱动程序异常  
	         catch ( ClassNotFoundException cnfex ) {  
	             System.err.println(  
	             "装载 JDBC/ODBC 驱动程序失败。" );  
	             cnfex.printStackTrace();   
	         }   
	         //捕获连接数据库异常  
	         catch ( SQLException sqlex ) {  
	             System.err.println( "无法连接数据库" );  
	             sqlex.printStackTrace();   
	         }  
	 }

	public boolean update(String sql){
		try {  
            statement = conn.prepareStatement(sql);  
            statement.executeUpdate();  
            return true;  
        } catch (SQLException e) {  
            System.out.println("插入数据库时出错：");  
            e.printStackTrace();  
        } catch (Exception e) {  
            System.out.println("插入时出错：");  
            e.printStackTrace();  
        }  
        return false;  
	}
	 public ResultSet selectSQL(String sql) {  
	        ResultSet rs = null;  
	        try {  
	            statement = conn.prepareStatement(sql);  
	            rs = statement.executeQuery(sql);  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	        return rs;  
	    }  
public static void main(String[] args) {
	String table="create table tests(username varchar(50),"
			+ "password varchar(50))";
	String insert="insert into tests values('admin','admin')";
	MySQLTest a=new MySQLTest();
	System.out.println("创建Test表："+a.update(table));
	System.out.println("插入数据Test表："+a.update(insert));
	//查询数据库
	ResultSet rs=a.selectSQL("select * from tests");
	try {
		while(rs.next()){
			System.out.println("username:"+rs.getString("username"));
			System.out.println("password:"+rs.getString("password"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
