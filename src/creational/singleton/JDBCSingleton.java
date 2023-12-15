package creational.singleton;

import java.io.IOException;
import java.sql.*;

public class JDBCSingleton {

    private static JDBCSingleton jdbcObj;

    private JDBCSingleton(){}

    public static JDBCSingleton getJdbcObj(){
        if (jdbcObj == null){
            jdbcObj = new JDBCSingleton();
        }
        return jdbcObj;
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/myDb", "postgres", "2345");
        return con;
    }

    public void viewResult(String name){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            con = this.getConnection();
            ps = con.prepareStatement("SELECT * FROM user WHERE name = ?");
            ps.setString(1,name);
            rs = ps.executeQuery();
            while (rs.next()){
                System.out.println("Name: "+name+", password: "+rs.getString("password"));
            }
            if (con != null) con.close();
            if (ps != null) ps.close();
            if (rs != null) rs.close();
        } catch (SQLException se){
            se.printStackTrace();
        } catch (ClassNotFoundException ie){
            ie.printStackTrace();
        }
    }
}
