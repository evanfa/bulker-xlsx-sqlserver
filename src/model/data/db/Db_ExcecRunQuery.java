package model.data.db;

import java.sql.SQLException;

public interface Db_ExcecRunQuery {
    void execInsert(String dbName, String tblName, String queryStr) throws ClassNotFoundException, SQLException;
    void selectValByValue(String dbName, String tblName, String queryStr) throws ClassNotFoundException, SQLException;
    void deleteByValue(String dbName, String tblName, String queryStr) throws ClassNotFoundException, SQLException;
}
