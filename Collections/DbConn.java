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
            //String query =  "SELECT * FROM \"Students\"";
            // String insertquery =  "INSERT INTO  \"Students\" (\"Name\", \"Note\") VALUES ('Duygu',92)";


            //statement = connection.createStatement();
            //ResultSet resultSet = statement.executeQuery(query);
            //System.out.println(statement.executeUpdate(insertquery));

            /*resultSet.next();
            resultSet.next();
            resultSet.first(); // 2 ileriden sonra basa donmek istersek hata verir, bunun icin createStatement icine ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY kodlari eklenir.

            resultSet.absolute(2); //2.satirin verisi gelir.*/

           /* while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String name = resultSet.getString("Name");
                int note = resultSet.getInt("Note");

                System.out.println("Id: " + id + ", Name: " + name + ", Note: " + note);
            }*/


            //PreparedStatement
            /*
            * Insert Islemi
            * */
           /* String insertqueryPreparedStatement =  "INSERT INTO  \"Students\" (\"Id\",\"Name\", \"Note\") VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertqueryPreparedStatement);
            preparedStatement.setInt(1,1);
            preparedStatement.setString(2,"AliItaly");
            preparedStatement.setInt(3,92);
            preparedStatement.executeUpdate();
            preparedStatement.close();*/


            //Update Islemi
            //String stSql = "UPDATE \"Students\" SET \"Name\" = 'Sabit Ünsür' WHERE \"Id\" = 1";
            //statement.executeUpdate(stSql);
           /* String preparedSql = "UPDATE \"Students\" SET \"Name\" = ? WHERE \"Id\" = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(preparedSql);
            preparedStatement.setInt(1,1);
            preparedStatement.setString(2,"Sabit Ünsür");
            preparedStatement.executeUpdate();*/

            //DELETE ISLEMI
            /*
            String stSql = "DELETE FROM  \"Students\"  WHERE \"Id\" = 1";
            String preparedSql = "DELETE  FROM \"Students\" WHERE \"Id\" = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(preparedSql);
            preparedStatement.setInt(1,1);
            preparedStatement.executeUpdate();

            connection.close();
            preparedStatement.close();
            statement.close();
            */


            //TRANSACTIONS
            /*
            * Transactionlar, dbde islem yaparken geri alma imkanını saglayan yapılardır.
            * Ornek,2 veri eklenmek isteniyor. İlk veri eklendi, ikinci veri eklenirken hata alındı. Dolayısıyla ilk veriyi de eklemememiz lazım.
            * */

            connection.setAutoCommit(false);
            //İslemleri otomatik islemez, hafızaya alır commit() metodu cagrılınca yapar. Boylece bir veri eklendikten sonra ikincisi eklenirken hata alınırsa, ilk verinin de eklenmemesini sağlarız.

            String insertqueryPreparedStatement =  "INSERT INTO  \"Students\" (\"Id\",\"Name\", \"Note\") VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertqueryPreparedStatement);
            preparedStatement.setInt(1,1);
            preparedStatement.setString(2,"TestUser");
            preparedStatement.setInt(3,98);
            preparedStatement.executeUpdate();

            preparedStatement.setInt(1,2);
            preparedStatement.setString(2,"TestUser2");
            preparedStatement.setInt(3,91);
            preparedStatement.executeUpdate();

            connection.commit();
            preparedStatement.close();


        } catch (SQLException e) {
            if(connection != null){
                try
                {
                    connection.rollback(); // veri tabanına bir kayıt eklemek komutu işletmiş olsa bile hata alındığından “rollback” fonksiyonu çağırıyoruz.
                    // Böylece, o ana kadar yapılmış olan değişikliklerin geri alınmasını sağlıyoruz.
                }
                catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            throw new RuntimeException(e);
        }
    }

}
