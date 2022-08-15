package model.data.db;

import vault.global.vars.GlobalVarsValues;
import java.sql.Connection;
import java.sql.DriverManager;

//-Djava.library.path="C:\Users\fabio_rodriguez\OneDrive - TransCanada Corporation\Documents\IT\JODBC\;${env_var:PATH}"
public class Db_Connect {

    /**
     * Function that returns a connection with the default host and the required Database
     * @param db DatabaseName
     * @return Connection
     */
    public static Connection startConnection_WAuth(String db) {
        Connection con = null;
        try {
            Class.forName(GlobalVarsValues.sqlSerClass);
            System.out.println("Driver Loaded");
            String jdbcUrl = "jdbc:sqlserver://" + GlobalVarsValues.getDefaultHost() + ":" + GlobalVarsValues.getJdbcPort() + ";databaseName=" + db + ";integratedSecurity=true";
            con = DriverManager.getConnection(jdbcUrl);
            //Statement stmt = con.createStatement();
            //stmt.executeQuery("SET NOCOUNT ON");
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
        return con;
    }
    
}
