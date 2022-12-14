package tests;
import org.junit.Assert;
import org.junit.Test;
import utilities.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class C01 {

    //ogrenciler tablosunda Merve Gul isimli ogrencinin oldugunu test edın


    @Test
    public void test01() throws SQLException {
        String hostname="localhost";
        String dbismi="Databasetesting";
        String username="postgres";
        String password="Chem.2006";

        //1.Adim: connection olustur
        DBUtils.connectionOlustur(hostname,dbismi,username,password);

        //2. adim: statement olustur
        Statement st= (Statement) DBUtils.statementOlustur();

        //3. Adim: Query olustur
        String query = "SELECT isim FROM ogrenciler";

        //4. adim: Query'yi calistir

        ResultSet rs=st.executeQuery(query);
        List<String> isimler = new ArrayList<>();

        while (rs.next()){
            isimler.add(rs.getString(1));
        }
        Assert.assertTrue(isimler.contains("Merve Gul"));

        //5.adim: kapat
        DBUtils.connectionStatementKapat();
    }


}
