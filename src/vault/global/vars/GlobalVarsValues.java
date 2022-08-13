package vault.global.vars;

public class GlobalVarsValues {
    public static final String DEFAULT_HOST = "localhost";
    public static final String DEFAULT_DB = "TGNH_TVDR_Permits";
    public static final String DEFAULT_TABLE = "BD_PERMITS";
    public static final int JDBC_PORT = 1433;
    public static final String DEFAULT_SERVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static final String DEFAULT_FOLDER_SITE = "C:\\Users\\Public\\tempfiles";
    public static final String sqlSerClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public static String getDefaultHost() {
        return DEFAULT_HOST;
    }

    public static String getDefaultDb() {
        return DEFAULT_DB;
    }

    public static String getDefaultTable() {
        return DEFAULT_TABLE;
    }

    public static int getJdbcPort() {
        return JDBC_PORT;
    }

    public static String getDefaultFolderSite() {
        return DEFAULT_FOLDER_SITE;
    }
}
