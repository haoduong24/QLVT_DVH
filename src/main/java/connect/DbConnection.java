package connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    public Connection getConnection() throws Exception {
    	String url = "jdbc:sqlserver:}//"+serverName+":"+portNumber + "//" + instance + ";databaseName="+ dbName;
    	if(instance == null || instance.trim().isEmpty())
    		url = "jdbc:sqlserver://"+serverName+";"+portNumber +";databaseName="+dbName;
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	return DriverManager.getConnection(url, userID, password);
    }
    private final String serverName = "localhost";
    private final String dbName = "QLVT_DVH";
    private final String portNumber = "1433";
    private final String instance = "";
    private final String userID = "";
    private final String password = "";
    	public static void main(String[] args) {
    		try {
        		System.out.println(new DbConnection().getConnection());
        	} catch (Exception e) {
        		
        	}
    	}
}
