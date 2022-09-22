package controller.utils;

import vault.global.vars.GlobalVarsValues;

import javax.swing.*;
import java.sql.*;

public class DB_Utility {
    public static Connection startConnection_WAuth(String db) {
        Connection con = null;
        try {
            Class.forName(GlobalVarsValues.SERVER_CLASS);
            System.out.println("Driver Loaded");
            String jdbcUrl = "jdbc:sqlserver://" + GlobalVarsValues.DEFAULT_HOST + ":" + GlobalVarsValues.JDBC_PORT + ";databaseName=" + db + ";integratedSecurity=true";
            con = DriverManager.getConnection(jdbcUrl);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
        return con;
    }

    public static boolean executeTableVerification(String dbName, String tableName) {
        boolean tableExist = false;
        try {
            Class.forName(GlobalVarsValues.SERVER_CLASS);
            String jdbcUrl = "jdbc:sqlserver://" + GlobalVarsValues.DEFAULT_HOST + ":" + GlobalVarsValues.JDBC_PORT + ";databaseName=" + dbName + ";integratedSecurity=true";
            Connection con = DriverManager.getConnection(jdbcUrl);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT OBJECT_ID FROM sys.objects WHERE name = '" + tableName + "';");
            if (rs != null) {
                tableExist = true;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            JOptionPane.showMessageDialog(null, "Exception: " + e, "Error - SQL Exception", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return tableExist;
    }

    public static void executeInsertWithKeys(Connection con, String query) {
        try {
            Statement stmt = con.createStatement();
            int count = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            //System.out.println("Generated Keys: "+count);
            ResultSet rs = stmt.getGeneratedKeys();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            if (rs.next()) {
                do {
                    for (int i = 1; i <= columnCount; i++) {
                        String key = rs.getString(i);
                        //System.out.println("KEY " + i + " = " + key);
                    }
                } while (rs.next());
            } else {
                System.out.println("NO KEYS WERE GENERATED.");
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Query Fails. Verify.", "Error in Query", JOptionPane.ERROR_MESSAGE);

            System.out.println("-------------------ERROR---------------------");
            System.out.println("Error in Query: " + e);
            System.out.println("Fail Query: " + query);
            //Statement stmt = null;
            try {
                String errorQry = e.toString();

                Connection cn = startConnection_WAuth(GlobalVarsValues.DEFAULT_BD_NAME);
                Statement st = cn.createStatement();

                String qrt = "INSERT INTO [dbo].["+GlobalVarsValues.DEFAULT_ERROR_LOG+"](errordesc,inputdesc) VALUES (´" + errorQry + "´,´" + query + "´)";

                qrt = qrt.replace("'", "");
                qrt = qrt.replace("´", "'");

                System.out.println("Error Query: " + qrt);

                st.executeUpdate(qrt, Statement.RETURN_GENERATED_KEYS);
                st.close();
                cn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println("-------------------ERROR---------------------");
        }
    }

    public static void execQueryInsert(Connection con, String qry) throws SQLException {
        try {
            Statement stmt = con.createStatement();
            stmt.execute(qry);
            stmt.closeOnCompletion();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Query Fails. Verify.", "Error in Query", JOptionPane.ERROR_MESSAGE);
            System.out.println("Query Fail: " + e);
            System.out.println("Query: " + qry);
            e.printStackTrace();
        }
    }

}
