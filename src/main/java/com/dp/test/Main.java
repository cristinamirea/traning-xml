package com.dp.test;

import com.dp.test.generated.generated.Invoice;

import javax.xml.bind.JAXBException;
import javax.xml.transform.Result;
import java.io.IOException;
import java.sql.*;

public class Main {

    // JDBC driver name and database URL
//    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    static final String DB_URL = "jdbc:mysql://localhost:3306/exe";

    //  Database credentials
//    static final String USER = "root";
//    static final String PASS = "";


    public static void main(String[] args) throws JAXBException, IOException {

          CsvWriter.write(XmlReader.reader());
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/exe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

            Statement stmt = con.createStatement();

//            String sql = "INSERT INTO invoice(id,nr, issue, total) values (1,1,2018,120)";
//            int inst = stmt.executeUpdate(sql);

            XmlReader xmlReader = new XmlReader();
            Invoice inv = xmlReader.reader();

            int val1 = inv.getNr();
            int val2= inv.getIssue();
            int val3= inv.getTotal();

//          String sql = "INSERT INTO invoice(id,nr, issue, total) values ( 2,'"+val1+"','"+val2+"',"+val3+"')";
//            int inst = stmt.executeUpdate(sql);
            PreparedStatement prepareSQL = con.prepareStatement("INSERT INTO invoice(id,nr, issue, total) values ( ?,?,?,?)");
//
            prepareSQL.setInt(1,2);
            prepareSQL.setInt(2,val1);
            prepareSQL.setInt(3,val2);
            prepareSQL.setInt(4,val3);
            prepareSQL.execute();

            ResultSet rs = stmt.executeQuery("select * from invoice");
            while (rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3)+ "  " + rs.getString(4));


            System.out.println("s a inserat");

            con.close();


        } catch (Exception e) {
            System.out.println(e);
        }
    }


}



