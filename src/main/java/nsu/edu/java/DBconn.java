package nsu.edu.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconn {
    String url = "jdbc:mysql://121.36.61.186:3306/exam";

    private Connection conn = null;
    public Connection getConn(){
        try {
            //加载程序驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //连接数据库
            conn = DriverManager.getConnection(url);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
