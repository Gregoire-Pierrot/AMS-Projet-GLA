import java.sql.SQLException;
import java.util.List;

import org.json.JSONObject;

public class Main {

    public static void main(String[] args) throws SQLException, InterruptedException {
        DBInitializer db = DBInitializer.getInstance();

        /*for (int i = 0; i < 20; i++){
            JSONObject response = APIRequest.getInstance().sendGetRequest("/assets");

            if (response != null) {
                System.out.println("#----------------------------------------#\nCryptomonnaies enregistrées :");
                System.out.println("------------------");
                List<Cryptocurrency> cryptocurrencies = JSONManager.getInstance().createCryptocurrencies(response);
                for (Cryptocurrency cryptocurrency : cryptocurrencies){
                    System.out.println(cryptocurrency.toString());
                    System.out.println("------------------");
                }
                System.out.println("#----------------------------------------#");

                System.out.println("Inserting Cryptocurrencies into database ...");
                for (Cryptocurrency cryptocurrency : cryptocurrencies){
                    DBManager.getInstance().addCryptocurrencyData(cryptocurrency);
                }
                System.out.println("Done !");
                Thread.sleep(1000);
            }
        }

        List<Cryptocurrency> cryptocurrencies = DBManager.getInstance().getCryptocurrencies("Kusama");
        System.out.println(cryptocurrencies.size());*/

        //System.out.println();

        for (int i = 0; i < 20; i++){
            JSONObject response = APIRequest.getInstance().sendGetRequest("/exchanges");
    
            if (response != null) {
                System.out.println("#----------------------------------------#\nPlateformes d'échange enregistré :");
                System.out.println("------------------");
                List<Exchange> exchanges = JSONManager.getInstance().createExchanges(response);
                for (Exchange exchange : exchanges){
                    System.out.println(exchange.toString());
                System.out.println("------------------");
                }
                System.out.println("#----------------------------------------#");

                System.out.println("Inserting Exchanges into database ...");
                for (Exchange exchange : exchanges){
                    DBManager.getInstance().addExchange(exchange);
                }
                System.out.println("Done !");
            }
            Thread.sleep(1000);
        }

        System.out.println(DBManager.getInstance().getExchanges().size());
    }
}