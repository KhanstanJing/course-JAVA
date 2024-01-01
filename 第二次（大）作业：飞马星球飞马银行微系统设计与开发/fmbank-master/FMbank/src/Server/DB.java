package Server;

import java.sql.*;

public class DB {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/testgb";

    static final String USER = "root";
    static final String PASS = "2%duLg7dWiND";

    private Connection conn;
    private Statement stmt;

    DB() {
        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Connect to db...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Connect successfully.");
    }

    public synchronized String db_query(String sql, String col, int flag) {
        String res = "Null";
        try {
            ResultSet rs = stmt.executeQuery(sql);
            if(flag == 1) while(rs.next()) res = rs.getInt(col)+"";
            else while(rs.next()) res = rs.getString(col);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } 
        return res;
    }

    public synchronized void db_exe(String sql) {
        try {
            stmt.execute(sql);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
