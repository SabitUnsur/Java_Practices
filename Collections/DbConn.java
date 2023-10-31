package Collections;

import java.sql.*;

import static java.sql.DriverManager.*;

public class DbConn {

    public static  final  String db_url = "jdbc:postgresql://localhost:5432/JavaLecture";
    public static  final  String db_user = "postgres";
    public static  final  String db_password = "123";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = getConnection(db_url,db_user,db_password);
            String query =  "SELECT * FROM \"Students\"";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String name = resultSet.getString("Name");
                int note = resultSet.getInt("Note");

                System.out.println("Id: " + id + ", Name: " + name + ", Note: " + note);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
