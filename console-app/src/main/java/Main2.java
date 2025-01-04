import java.sql.SQLException;
import java.util.List;

public class Main2 {
    public static void main(String[] args) throws SQLException {
        DBInitializer.getInstance();
        DBManager dbManager = DBManager.getInstance();

        List<Cryptocurrency> cryptocurrencies = dbManager.getCryptocurrencies("Bitcoin");

        for (Cryptocurrency cryptocurrency : cryptocurrencies) {
            System.out.println(cryptocurrency);
        }
    }
}
