import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class InitializeBD {
    private static InitializeBD instance;
    
    private InitializeBD(){
        initialize();
    }

    public static InitializeBD getInstance(){
        if (instance == null){
            instance = new InitializeBD();
        }
        return instance;
    }

    private void initialize(){
        createBD();
    }

    private void createBD(){
        String url = "jdbc:sqlite:datab.db";

        // Créer une connexion à la base de données
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Connection to SQLite has been established.");
                createTables(conn);
            }
        } catch (SQLException e) {
            System.out.println("Connection to SQLite failed: " + e.getMessage());
        }
    }

    private void createTables(Connection conn){
        createTableTime(conn);
        createTableCryptocurency(conn);
        createTableExchanges(conn);
        createTableMarkets(conn);
        createTableCandles(conn);
    }

    //TODO
    private void createTableTime(Connection conn){

    }

    private void createTableCryptocurency(Connection conn){
        String createTableSQL = "CREATE TABLE IF NOT EXISTS cryptocurency ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "rank TEXT NOT NULL, "
                + "symbol TEXT NOT NULL, "
                + "name TEXT NOT NULL, "
                + "supply DOUBLE NOT NULL;)";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Table created successfully.");
            
            /*// Insérer des données dans la table
            String insertDataSQL = "INSERT INTO users (name, age) VALUES ('John Doe', 30), ('Jane Doe', 25);";
            stmt.executeUpdate(insertDataSQL);
            System.out.println("Data inserted successfully.");*/
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }        
    }

    //TODO
    private void createTableExchanges(Connection conn){
        
    }

    //TODO
    private void createTableMarkets(Connection conn){
        
    }

    //TODO
    private void createTableCandles(Connection conn){
        
    }

}
