package jdbc01;

import com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping;

import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTest01 {
    public static void main(String[] args) {
        try {
            //load driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");

            //establish connection
            DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root1234");
            System.out.println("successful collection");
        }
        catch (ClassNotFoundException e){
            System.out.println("driver illa");
        }
        catch (SQLException e){
            System.out.println("problem in connection");
        }
    }
}
