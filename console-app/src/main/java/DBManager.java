import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Java class singeton to manage the database
 */
public class DBManager {
    /** Singleton **/
    private static DBManager instance;
    /** Connection to the database **/
    private Connection conn;

    /**
     * Get the DBManager instance.
     * 
     * @return instance of DBManager.
     * @throws SQLException if the query fail.
     */
    public static DBManager getInstance() throws SQLException{
        if (instance == null){
            instance = new DBManager();
        }
        return instance;
    }

    /**
     * Contructor. Initialize the conection.
     * 
     * @throws SQLException if the connection fail.
     */
    private DBManager() throws SQLException { initConnection(); }

    private void initConnection() throws SQLException {
        String url = DBInitializer.url;

        this.conn = DriverManager.getConnection(url);
        if (conn != null) {
            System.out.println("Connection to SQLite has been established.");
        } else {
            System.out.println("Failed to connect to SQLite.");
        }
    }

    /**
     * Return boolean if a cryptocurrency with this id alwready exist.
     * @param id of the cryptocurrency.
     * @return boolean if cryptocurrency alwready exist.
     * @throws SQLException if the query fail.
     */
    public Boolean cryptocurrencyAlreadyExist(String id) throws SQLException {
        String queryCryptocurrency = "SELECT 1 FROM cryptocurrency WHERE id = ?";

        PreparedStatement pstmt = conn.prepareStatement(queryCryptocurrency);
        pstmt.setString(1, id);

        ResultSet rs = pstmt.executeQuery();
        return rs.next();
    }


    /**
     * Return boolean if a time have been already added in the database.
     * @param timestamp refering to the time.
     * @return boolean if time alwready exist.
     * @throws SQLException if the query fail.
     */
    public Boolean timeAlreadyExist(String timestamp) throws SQLException{
        String queryTimeTimestamp = "SELECT 1 FROM time WHERE timestamp = ?";

        PreparedStatement pstmt = conn.prepareStatement(queryTimeTimestamp);
        pstmt.setString(1, timestamp);
        ResultSet rs = pstmt.executeQuery();
        return rs.next();
    }

    /**
     * Return the ID of a time for the timestamp.
     * @param timestamp of the time.
     * @return id of the time with this timestamp.
     * @throws SQLException if the query fail.
     */
    public int getTimeId(String timestamp) throws SQLException {
        String queryTimeId = "SELECT id FROM time WHERE timestamp = ?";

        PreparedStatement pstmt = conn.prepareStatement(queryTimeId);
        pstmt.setString(1, timestamp);
        ResultSet rs = pstmt.executeQuery();
        return rs.getInt("id");
    }

    /**
     * Add a new time to the database.
     * @param timestamp of the new time.
     * @throws SQLException if the query fail.
     */
    public void addTime(String timestamp) throws SQLException{
        String insertTime = "INSERT INTO time (timestamp) VALUES (?)";

        PreparedStatement pstmt = conn.prepareStatement(insertTime);
        pstmt.setString(1, timestamp);
        pstmt.execute();
    //    System.out.println("New time added.");
    }

    /**
     * Add a new Cryptocurrency tot the database.
     * @param id of the new Cryptocurrency.
     * @param symbol of the new Cryptocurrency.
     * @param name of the new Cryptocurrency.
     * @param rank of the new Cryptocurrency.
     * @throws SQLException if the query fail.
     */
    public void addCryptocurrency(String id, String symbol, String name, int rank) throws SQLException{
        String insertCryptocurrency = "INSERT INTO cryptocurrency (id, symbol, name, rank) VALUES (?, ?, ?, ?)";

        PreparedStatement pstmt = conn.prepareStatement(insertCryptocurrency);
        pstmt.setString(1, id);
        pstmt.setString(2, symbol);
        pstmt.setString(3, name);
        pstmt.setInt(4, rank);
        pstmt.execute();
    //    System.out.println("New cryptocurrency added.");
    }
    

    /**
     * Add the data of a cryptocurrency to the database.
     * @param cryptocurrency datas to add.
     * @throws SQLException if the query fail.
     */
    public void addCryptocurrencyData(Cryptocurrency cryptocurrency) throws SQLException{
        if (!cryptocurrencyAlreadyExist(cryptocurrency.getId())){
            addCryptocurrency(cryptocurrency.getId(), cryptocurrency.getSymbol(), cryptocurrency.getName(), cryptocurrency.getRank());
        }

        if (!timeAlreadyExist(cryptocurrency.getTimestamp())){
            addTime(cryptocurrency.getTimestamp());
        }

        int time_id = getTimeId(cryptocurrency.getTimestamp());
        if (time_id == -1){
            System.out.println("Error getting time_id");
            System.exit(1);
        }
        
        String insertCryptocurrencyData = "INSERT INTO cryptocurrencydata (cryptocurrency_id, supply, maxSupply, marketCapUsd, volumeUsd24Hr, priceUsd, changePercent24Hr, vwap24Hr, time_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(insertCryptocurrencyData)){
            pstmt.setString(1, cryptocurrency.getId());
            pstmt.setDouble(2, cryptocurrency.getSupply());
            pstmt.setDouble(3, cryptocurrency.getMaxSupply());
            pstmt.setDouble(4, cryptocurrency.getMarketCapUsd());
            pstmt.setDouble(5, cryptocurrency.getVolumeUsd24Hr());
            pstmt.setDouble(6, cryptocurrency.getPriceUsd());
            pstmt.setDouble(7, cryptocurrency.getChangePercent24Hr());
            pstmt.setDouble(8, cryptocurrency.getVwap24Hr());
            pstmt.setInt(9, time_id);

            pstmt.executeUpdate();
        //    System.out.println("New cryptocurrencydata added.");
        } catch (SQLException e){
            throw new SQLException("Error inserting cryptocurrencydata: " + e.getMessage());
        }

    }
    
    /**
     * Get the list of cryptocurrencies for this name.
     * @param name query's paramater on cryptocurrencies.
     * @return list of cryptocurrency with the name.
     * @throws SQLException if the query fail.
     */
    public List<Cryptocurrency> getCryptocurrencies(String name) throws SQLException {
        String query = "SELECT "
                + "c.id, "
                + "c.symbol, "
                + "c.name, "
                + "c.rank, "
                + "cd.supply, "
                + "cd.maxSupply, "
                + "cd.marketCapUsd, "
                + "cd.volumeUsd24Hr, "
                + "cd.priceUsd, "
                + "cd.changePercent24Hr, "
                + "cd.vwap24Hr, "
                + "t.timestamp "
                + "FROM cryptocurrency c JOIN cryptocurrencydata cd ON c.id = cd.cryptocurrency_id "
                + "JOIN time t ON cd.time_id = t.id "
                + "WHERE c.name = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, name);
        List<Cryptocurrency> cryptocurrencies = new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                cryptocurrencies.add(new Cryptocurrency(
                    rs.getString("id"),
                    rs.getInt("rank"),
                    rs.getString("symbol"),
                    rs.getString("name"),
                    rs.getDouble("supply"),
                    rs.getDouble("maxSupply"),
                    rs.getDouble("marketCapUsd"),
                    rs.getDouble("volumeUsd24Hr"),
                    rs.getDouble("priceUsd"),
                    rs.getDouble("changePercent24Hr"),
                    rs.getDouble("vwap24Hr"),
                    rs.getString("timestamp")));
            }
        }
        return cryptocurrencies;
    }

    /**
     * Return boolean if a exchange have been already added in the database.
     * @param id if of the exchange.
     * @return boolean if exchange alwready exist.
     * @throws SQLException if the query fail.
     */
    public Boolean exchangeAlreadyExist(String id) throws SQLException {
        String query = "SELECT id FROM exchanges WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, id);
        ResultSet rs = stmt.executeQuery();
        return rs.next();
    }

    /**
     * Update an exchange with new paramaters.
     * @param id new id for this exchange.
     * @param name new name for this exchange.
     * @param rank new rank for this exchange.
     * @param percentTotalVolume new percentTotalVolume for this exchange.
     * @param volumeUsd new volumeUsd for this exchange.
     * @param tradingPairs new tradingPairs for this exchange.
     * @param socket new socket for this exchange.
     * @param exchangeUrl new exchangeUrl for this exchange.
     * @param updated new update for this exchange.
     * @throws SQLException if the query fail.
     */
    public void updateExchange(String id, String name, int rank, double percentTotalVolume, double volumeUsd, double tradingPairs, boolean socket, String exchangeUrl, String updated) throws SQLException {
        String updateExchange = "UPDATE exchanges SET name = ?, rank = ?, percentTotalVolume = ?, volumeUsd = ?, tradingPairs = ?, socket = ?, exchangeUrl = ?, updated = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(updateExchange);
        pstmt.setString(1, name);
        pstmt.setInt(2, rank);
        pstmt.setDouble(3, percentTotalVolume);
        pstmt.setDouble(4, volumeUsd);
        pstmt.setDouble(5, tradingPairs);
        pstmt.setBoolean(6, socket);
        pstmt.setString(7, exchangeUrl);
        pstmt.setString(8, updated);
        pstmt.setString(9, id);
        pstmt.executeUpdate();
    //    System.out.println("Exchange updated.");
    }

    /**
     * Add a new exchnage to the database.
     * @param exchange to add.
     * @throws SQLException if the query fail.
     */
    public void addExchange(Exchange exchange) throws SQLException {
        if (exchangeAlreadyExist(exchange.getId())) {
            updateExchange(exchange.getId(), exchange.getName(), exchange.getRank(), exchange.getPercentTotalVolume(), exchange.getVolumeUsd(), exchange.getTradingPairs(), exchange.getSocket(), exchange.getExchangeUrl(), exchange.getUpdated());
            return;
        }
        String insertExchange = "INSERT INTO exchanges (id, name, rank, percentTotalVolume, volumeUsd, tradingPairs, socket, exchangeUrl, updated) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(insertExchange);
        pstmt.setString(1, exchange.getId());
        pstmt.setString(2, exchange.getName());
        pstmt.setInt(3, exchange.getRank());
        pstmt.setDouble(4, exchange.getPercentTotalVolume());
        pstmt.setDouble(5, exchange.getVolumeUsd());
        pstmt.setDouble(6, exchange.getTradingPairs());
        pstmt.setBoolean(7, exchange.getSocket());
        pstmt.setString(8, exchange.getExchangeUrl());
        pstmt.setString(9, exchange.getUpdated());
        try {
            pstmt.execute();
        //    System.out.println("New exchange added.");
        } catch (Exception e) {
            System.out.println(exchange.getName() + " : " + exchange.getId() + " already exist.");
            e.printStackTrace();
        }
    }

    /**
     * Get all the exchanges of the database.
     * @return a list of exchange.
     * @throws SQLException if the query fail.
     */
    public List<Exchange> getExchanges() throws SQLException {
        String query = "SELECT * FROM exchanges";
        PreparedStatement stmt = conn.prepareStatement(query);
        List<Exchange> exchanges = new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                exchanges.add(new Exchange(
                    rs.getString("id"),
                    rs.getString("name"),
                    rs.getInt("rank"),
                    rs.getDouble("percentTotalVolume"),
                    rs.getDouble("volumeUsd"),
                    rs.getInt("tradingPairs"),
                    rs.getBoolean("socket"),
                    rs.getString("exchangeUrl"),
                    rs.getString("updated")));
            }
        }
        return exchanges;
    }
}
