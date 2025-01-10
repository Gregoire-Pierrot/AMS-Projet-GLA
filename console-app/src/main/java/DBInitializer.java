import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Java class singleton to initialize the database.
 * 
 * @author Grégoire Pierrot.
 */
public class DBInitializer {
    /** Singleton **/
    private static DBInitializer instance;
    public static final String url = "jdbc:sqlite:database/datas.db";
    
    /** Constructor **/
    private DBInitializer(){
        initialize();
    }

    /**
     * Get the DBInitializer instance.
     * 
     * @return instance of DBInitializer.
     */
    public static DBInitializer getInstance(){
        if (instance == null){
            instance = new DBInitializer();
        }
        return instance;
    }

    /**
     * Initialize the database.
     * 
     * This method create the database if it does not exist and create the tables.
     */
    private void initialize(){
        createBD();
    }

    /**
     * Establishes a connection to the SQLite database and creates the necessary tables.
     * If the connection is successful, it calls createTables to set up the database schema.
     * Logs a message indicating whether the connection was successful or failed.
     */
    void createBD(){
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

    /**
     * Creates all necessary tables in the database.
     * 
     * This method sets up the database schema by creating the tables
     * required for storing time, cryptocurrency, cryptocurrency data,
     * and exchanges. Additional tables such as markets and candles
     * can be created by uncommenting the respective lines.
     *
     * @param conn The connection to the SQLite database.
     */
    private void createTables(Connection conn){
        createTableTime(conn);
        createTableCryptocurrency(conn);
        createTableCryptocurrencyData(conn);
        createTableExchanges(conn);
        //createTableMarkets(conn);
        //createTableCandles(conn);
    }

    /**
     * Creates the time table.
     * 
     * This method creates the table with the following schema:
     * id INTEGER PRIMARY KEY AUTOINCREMENT
     * timestamp TEXT NOT NULL UNIQUE
     * 
     * It also creates an index on the timestamp column.
     * 
     * @param conn The connection to the SQLite database.
     */
    private void createTableTime(Connection conn){
        String createTableSQL = "CREATE TABLE IF NOT EXISTS time ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "timestamp TEXT NOT NULL UNIQUE )";
        
        String createIndexSQL = "CREATE INDEX IF NOT EXISTS idx_time_timestamp ON time(timestamp)";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            stmt.execute(createIndexSQL);
            System.out.println("Table time loaded successfully.");
            
        } catch (SQLException e) {
            System.out.println("Error loading table time: " + e.getMessage());
            e.printStackTrace();
        }    
    }

    /**
     * Creates the cryptocurrency table.
     * 
     * This method creates the table with the following schema:
     * id TEXT PRIMARY KEY
     * symbol TEXT NOT NULL UNIQUE
     * name TEXT NOT NULL UNIQUE
     * rank INTEGER NOT NULL
     * 
     * It also creates an index on the symbol and name columns.
     * 
     * @param conn The connection to the SQLite database.
     */
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
            System.out.println("Table cryptocurrency loaded successfully.");
            
        } catch (SQLException e) {
            System.out.println("Error loading table cryptocurrency: " + e.getMessage());
            e.printStackTrace();
        }        
    }

    /**
     * Creates the cryptocurrencydata table.
     * 
     * This method creates the table with the following schema:
     * id INTEGER PRIMARY KEY AUTOINCREMENT
     * cryptocurrency_id TEXT NOT NULL
     * supply DOUBLE
     * maxSupply DOUBLE
     * marketCapUsd DOUBLE
     * volumeUsd24Hr DOUBLE
     * priceUsd DOUBLE
     * changePercent24Hr DOUBLE
     * vwap24Hr DOUBLE
     * time_id INTEGER NOT NULL
     * 
     * The table includes foreign keys referencing the cryptocurrency (id) 
     * and time (id) tables. It also creates indexes on cryptocurrency_id 
     * and time_id columns.
     * 
     * @param conn The connection to the SQLite database.
     */
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
            System.out.println("Table cryptocurrencydata loaded successfully.");

        } catch (SQLException e) {
            System.out.println("Error loading table cryptocurrencydata: " + e.getMessage());
            e.printStackTrace();
        }        
    }

    /**
     * Creates the exchanges table.
     * 
     * Create a table to store exchange data. The table includes the following columns:
     * id TEXT PRIMARY KEY
     * name TEXT NOT NULL
     * rank INTEGER NOT NULL
     * percentTotalVolume DOUBLE
     * volumeUsd DOUBLE
     * tradingPairs INTEGER
     * socket BOOLEAN
     * exchangeUrl TEXT NOT NULL
     * updated TIMESTAMP NOT NULL.
     * 
     * It also creates an index on the name column.
     * 
     * @param conn The connection to the SQLite database.
     */
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
            System.out.println("Table exchanges load successfully.");
            
        } catch (SQLException e) {
            System.out.println("Error loading table exchanges: " + e.getMessage());
            e.printStackTrace();
        }   
    }
}
