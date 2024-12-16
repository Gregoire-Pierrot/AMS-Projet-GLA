import java.util.List;

import org.json.JSONObject;

public class Main {

    public static void main(String[] args) {
        DBInitializer db = DBInitializer.getInstance();

        JSONObject response = APIRequest.getInstance().sendGetRequest("/assets");
        System.out.println(response.get("timestamp"));

        /*if (response != null) {
            System.out.println("#----------------------------------------#\nCryptomonnaies enregistrées :");
            System.out.println("------------------");
            List<Cryptocurrency> cryptocurrencies = JSONManager.getInstance().createCryptocurrencies(response);
            for (Cryptocurrency cryptocurrency : cryptocurrencies){
                System.out.println(cryptocurrency.toString());
                System.out.println("------------------");
            }
            System.out.println("#----------------------------------------#");
        }*/

        //System.out.println();

        response = APIRequest.getInstance().sendGetRequest("/exchanges");

        /*if (response != null) {
            System.out.println("#----------------------------------------#\nPlateformes d'échange enregistré :");
            System.out.println("------------------");
            List<Exchange> exchanges = JSONManager.getInstance().createExchanges(response);
            for (Exchange exchange : exchanges){
                System.out.println(exchange.toString());
            System.out.println("------------------");
            }
            System.out.println("#----------------------------------------#");
        }*/

        
    }
}