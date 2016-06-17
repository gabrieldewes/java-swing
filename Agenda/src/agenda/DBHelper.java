package agenda;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dewes
 */
public class DBHelper {
    
    private static final String IP = "localhost";
    private static final String USER = "root";
    private static final String PASS = "";
    private static final String DB = "Aula18_AP3_Agenda";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static Connection conn;

    public DBHelper() {
 
    }
    
    public static Connection getConn() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection("jdbc:mysql://"+ IP +"/"+ DB +"", USER, PASS);
            System.out.println("Conexão aberta. ");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        return conn;
    }
   
    public void createDb() throws IOException, SQLException {
        conn = getConn();
        Statement stmt = conn.createStatement();
        try {
            String line;
            BufferedReader input = openSQLfile( "src/agenda/ddl.sql" );
            while ((line = input.readLine()) != null) {
                stmt.executeUpdate(line);
                System.out.println(line);
            }
            input.close();
        }
        catch (IOException | SQLException err) {
            System.out.println( err.getMessage() );
        }

    }

    public static BufferedReader openSQLfile(String SQL_FILE) throws FileNotFoundException {
        return new BufferedReader( new FileReader(SQL_FILE) );
    }
}
