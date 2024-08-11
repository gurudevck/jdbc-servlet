package jdbc01;

import java.sql.*;

public class JdbcTest03 {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            //load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //establish connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root1234");

            //disabling auto commit mode of connection
            conn.setAutoCommit(false);

            //set up sql command
            String query = "insert into Student (student_id, student_name, student_score, dept_id) values (?,?,?,?)";

            //create prepared statement
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1,6);
            preparedStatement.setString(2,"pp");
            preparedStatement.setDouble(3,70);
            preparedStatement.setInt(4,20);

            int result = preparedStatement.executeUpdate();

            conn.commit();

            if(result==1)
                System.out.println("success");

            //close
            preparedStatement.close();
            conn.close();
        }
        catch (ClassNotFoundException e){
            System.out.println("driver illa");
        }
        catch (SQLException e){
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1){
                System.out.println("error");
            }
            System.out.println("problem in connection");
        }
    }
}
