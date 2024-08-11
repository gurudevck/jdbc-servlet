package jdbc01;

import java.sql.*;

public class JdbcTest02 {
    public static void main(String[] args) {
        try {
            //load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //establish connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root1234");

            //create statement
            Statement statement = conn.createStatement();

            //set up sql command
            String query = "select * from Student";

            //execute query
            ResultSet resultSet = statement.executeQuery(query);

            //process result
            while(resultSet.next()){
                int studentId = resultSet.getInt("student_id");
                String studentName = resultSet.getString(2);
                double studentScore = resultSet.getDouble(3);
                int deptId = resultSet.getInt(4);

                System.out.println(studentId+" "+studentName+" "+studentScore+" "+deptId);
            }

            //close connection
            statement.close();
            conn.close();
        }
        catch (ClassNotFoundException e){
            System.out.println("driver illa");
        }
        catch (SQLException e){
            System.out.println("problem in connection");
        }
    }
}
