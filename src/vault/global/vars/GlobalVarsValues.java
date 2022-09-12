package vault.global.vars;

public class GlobalVarsValues {
    public static final String DEFAULT_HOST = "localhost";
    public static final String DEFAULT_DB = "TGNH_TVDR_Permits";
    public static final String DEFAULT_TABLE = "BD_PERMITS";
    public static final String DEFAULT_BD_NAME = "TGNH_TVDR_Reports";
    public static final int JDBC_PORT = 1433;
    public static final String SERVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static final String DEFAULT_FOLDER_SITE = "C:\\Users\\Public\\tempfiles";
    public static final String sqlSerClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static final String REGEX_DATE_OK = "([0-9]{4})-([0-9]{2})-([0-9]{2})";
    public static String DEFAULT_TABLE_COMS = "com_library";
    public static String DEFAULT_TABLE_REPORT = "end_validity_report";
    public static String DEFAULT_PATH_COMS = "C:\\Users\\fabio_rodriguez\\OneDrive - TransCanada Corporation\\Documents\\TGNH\\TVDR_Project\\Bitacoras\\29Apr22\\";
    public static String REGEX_META_COM = "(([A-Z]{3,4})-([A-Z]{3,4})-[a-zA-Z]*-([0-9]*)-([0-9]*[^_-a-zA-Z.\\/ ]))";

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
