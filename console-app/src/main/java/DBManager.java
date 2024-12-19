import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private static DBManager instance;
    private Connection conn;

    public static DBManager getInstance() throws SQLException{
        if (instance == null){
            instance = new DBManager();
        }
        return instance;
    }

    private DBManager() throws SQLException { initConnection(); }

    private void initConnection() throws SQLException {
        String url = "jdbc:sqlite:datab.db";

        this.conn = DriverManager.getConnection(url);
        if (conn != null) {
            System.out.println("Connection to SQLite has been established.");
        } else {
            System.out.println("Failed to connect to SQLite.");
        }
    }

    public Boolean CryptocurrencyAlreadyExist(String id) throws SQLException {
        String queryCryptocurrency = "SELECT 1 FROM cryptocurrency WHERE id = ?";

        PreparedStatement pstmt = conn.prepareStatement(queryCryptocurrency);
        pstmt.setString(1, id);

        ResultSet rs = pstmt.executeQuery();
        return rs.next();
    }

    public Boolean TimeAlreadyExist(String timestamp) throws SQLException{
        String queryTimeTimestamp = "SELECT 1 FROM time WHERE timestamp = ?";

        PreparedStatement pstmt = conn.prepareStatement(queryTimeTimestamp);
        pstmt.setString(1, timestamp);
        ResultSet rs = pstmt.executeQuery();
        return rs.next();
    }

    public int getTimeId(String timestamp) throws SQLException {
        String queryTimeId = "SELECT id FROM time WHERE timestamp = ?";

        PreparedStatement pstmt = conn.prepareStatement(queryTimeId);
        pstmt.setString(1, timestamp);
        ResultSet rs = pstmt.executeQuery();
        return rs.getInt("id");
    }

    public void addTime(String timestamp) throws SQLException{
        String insertTime = "INSERT INTO time (timestamp) VALUES (?)";

        PreparedStatement pstmt = conn.prepareStatement(insertTime);
        pstmt.setString(1, timestamp);
        pstmt.execute();
        System.out.println("New time added.");
    }

    public void addCryptocurrency(String id, String symbol, String name, int rank) throws SQLException{
        String insertCryptocurrency = "INSERT INTO cryptocurrency (id, symbol, name, rank) VALUES (?, ?, ?, ?)";

        PreparedStatement pstmt = conn.prepareStatement(insertCryptocurrency);
        pstmt.setString(1, id);
        pstmt.setString(2, symbol);
        pstmt.setString(3, name);
        pstmt.setInt(4, rank);
        pstmt.execute();
        System.out.println("New cryptocurrency added.");
    }
    

    public void addCryptocurrencyData(Cryptocurrency cryptocurrency) throws SQLException{
        if (!CryptocurrencyAlreadyExist(cryptocurrency.getId())){
            addCryptocurrency(cryptocurrency.getId(), cryptocurrency.getSymbol(), cryptocurrency.getName(), cryptocurrency.getRank());
        }

        if (!TimeAlreadyExist(cryptocurrency.getTimestamp())){
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
        } catch (SQLException e){
            throw new SQLException("Error inserting cryptocurrencydata: " + e.getMessage());
        }

    }

    public List<Cryptocurrency> getCryptocurrencies(String name) throws SQLException {
        List<Cryptocurrency> cryptocurrencyDataList = new ArrayList<>();

        String query = """
                SELECT 
                    c.id, c.rank, c.symbol, c.name, cd.supply, cd.maxSupply, cd.marketCapUsd, 
                    cd.volumeUsd24Hr, cd.priceUsd, cd.changePercent24Hr, cd.vwap24Hr, t.timestamp
                FROM 
                    cryptocurrency c
                JOIN 
                    cryptocurrencydata cd ON c.id = cd.cryptocurrency_id
                JOIN 
                    time t ON cd.time_id = t.id
                WHERE 
                    c.name = ?
                """;

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, name);
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cryptocurrency crypto = new Cryptocurrency(
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
                    rs.getString("timestamp")
                );
                cryptocurrencyDataList.add(crypto);
            }
        }

        return cryptocurrencyDataList;
    }
    
}
