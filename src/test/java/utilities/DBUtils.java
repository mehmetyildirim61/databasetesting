package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {

    //connection
    //statement
    //connection ve statement kapatma

    private static Connection connection;
    private static Statement statement;

    //1. Adim: Driver'a kaydol
    public static Connection connectionOlustur(String hostName, String dbName, String userName, String password){
//com.mysql.jdbc.Driver
//oracle.jdbc.driver.OracleDriver
//org.postgresql.Driver
//com.microsoft.sqlserver.jdbc.SQLServerDrive
//org.sqlite.JDBC  BUNLAR DIGER SQL SERVERLARININ DA BAGLANTI URL'SI
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
//2. Adim: Connection olustur
        String url = "jdbc:postgresql://"+hostName+":5432/"+dbName;
        try {
            connection= DriverManager.getConnection(url, userName,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static Statement statementOlustur(){
        try {
            statement=connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return statement;
    }

    public static void connectionStatementKapat(){
        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
