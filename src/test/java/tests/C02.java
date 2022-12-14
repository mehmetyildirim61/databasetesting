package tests;
import org.junit.Assert;
import org.junit.Test;
import utilities.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class C02 {

    //Yazili not ortalamasının 90dan kucuk oldugunu test edın


    @Test
    public void test01() throws SQLException {
        String hostname="localhost";
        String dbismi="Databasetesting";
        String username="postgres";
        String password="Chem.2006";


        DBUtils.connectionOlustur(hostname,dbismi,username,password);

        Statement st= (Statement) DBUtils.statementOlustur();

        String query = "SELECT avg(yazili_notu) from ogrenciler";
        ResultSet rs = st.executeQuery(query);
        rs.next();  //Iterator gibi davranir rs, bu nedenle next() kullanip ilk datayi oyle alabiliriz

        double ort = rs.getDouble(1);
        System.out.println("ort = " + ort);

        Assert.assertTrue(ort<90);

        DBUtils.connectionStatementKapat();
    }

}
