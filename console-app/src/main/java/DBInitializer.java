import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBInitializer {
    private static DBInitializer instance;
    
    private DBInitializer(){
        initialize();
    }

    public static DBInitializer getInstance(){
        if (instance == null){
            instance = new DBInitializer();
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
        createTableCryptocurrency(conn);
        createTableCryptocurrencyData(conn);
        createTableExchanges(conn);
        //createTableMarkets(conn);
        //createTableCandles(conn);
    }

    private void createTableTime(Connection conn){
        String createTableSQL = "CREATE TABLE IF NOT EXISTS time ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "timestamp TEXT NOT NULL UNIQUE )";
        
        String createIndexSQL = "CREATE INDEX IF NOT EXISTS idx_time_timestamp ON time(timestamp)";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            stmt.execute(createIndexSQL);
            System.out.println("Table created successfully.");
            
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
            e.printStackTrace();
        }    
    }

    private void createTableCryptocurrency(Connection conn){
        String createTableSQL = "CREATE TABLE IF NOT EXISTS cryptocurrency ("
                + "id TEXT PRIMARY KEY, "
                + "symbol TEXT NOT NULL UNIQUE, "
                + "name TEXT NOT NULL UNIQUE, "
                + "rank INTEGER NOT NULL )";
        
        String createIndexSymbolSQL = "CREATE INDEX IF NOT EXISTS idx_cryptocurrency_symbol ON cryptocurrency(symbol)";
        String createIndexNameSQL = "CREATE INDEX IF NOT EXISTS idx_cryptocurrency_name ON cryptocurrency(name)";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            stmt.execute(createIndexSymbolSQL);
            stmt.execute(createIndexNameSQL);
            System.out.println("Table created successfully.");
            
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
            e.printStackTrace();
        }        
    }

    private void createTableCryptocurrencyData(Connection conn){
        String createTableSQL = "CREATE TABLE IF NOT EXISTS cryptocurrencydata ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "cryptocurrency_id TEXT NOT NULL, "
                + "supply DOUBLE, "
                + "maxSupply DOUBLE, "
                + "marketCapUsd DOUBLE, "
                + "volumeUsd24Hr DOUBLE, "
                + "priceUsd DOUBLE, "
                + "changePercent24Hr DOUBLE, "
                + "vwap24Hr DOUBLE, "
                + "time_id INTEGER NOT NULL, "
                + "FOREIGN KEY (cryptocurrency_id) REFERENCES cryptocurrency (id), "
                + "FOREIGN KEY (time_id) REFERENCES time (id))";
        
        String createIndexCryptoIDSQL = "CREATE INDEX IF NOT EXISTS idx_crypto_id ON cryptocurrencydata(cryptocurrency_id)";
        String createIndexTimeIDSQL = "CREATE INDEX IF NOT EXISTS idx_time_id ON cryptocurrencydata(time_id)";
                
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            stmt.execute(createIndexCryptoIDSQL);
            stmt.execute(createIndexTimeIDSQL);
            System.out.println("Table created successfully.");

        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
            e.printStackTrace();
        }        
    }

    private void createTableExchanges(Connection conn){
        String createTableSQL = "CREATE TABLE IF NOT EXISTS exchanges ("
                + "id TEXT PRIMARY KEY, "
                + "name TEXT NOT NULL, "
                + "rank INTEGER NOT NULL, "
                + "percentTotalVolume DOUBLE, "
                + "volumeUsd DOUBLE, "
                + "tradingPairs INTEGER, "
                + "socket BOOLEAN, "
                + "exchangeUrl TEXT NOT NULL, "
                + "updated TIMESTAMP NOT NULL )";
        
        String createIndexSQL = "CREATE INDEX IF NOT EXISTS idx_exchanges_name ON exchanges(name)";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            stmt.execute(createIndexSQL);
            System.out.println("Table created successfully.");
            
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
            e.printStackTrace();
        }   
    }

    /*
    private void createTableMarkets(Connection conn){
        
    }
    */

    /*
    private void createTableCandles(Connection conn){
        
    }
    */

}
