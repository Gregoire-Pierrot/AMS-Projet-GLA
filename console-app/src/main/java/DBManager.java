import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {
    private static DBManager instance;
    private Connection conn;

    public static DBManager getInstance(){
        if (instance == null){
            instance = new DBManager();
        }
        return instance;
    }

    private DBManager() { initConnection(); }

    private void initConnection(){
        String url = "jdbc:sqlite:datab.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Connection to SQLite has been established.");
                this.conn = conn;
            }
        } catch (SQLException e) {
            System.out.println("Connection to SQLite failed: " + e.getMessage());
        }
    }

    public void addCryptocurrency(Cryptocurrency cryptocurrency){
        if (CryptocurrencyAlreadyExist(cryptocurrency)){
            
        }
    }

    public Boolean CryptocurrencyAlreadyExist(Cryptocurrency cryptocurrency){
        String query = "SELECT 1 FROM cryptocurrency WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, cryptocurrency.getId());

            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            return false;
        }
    }
}
