import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.json.JSONObject;

public class Main {

    public static void main(String[] args) throws SQLException, InterruptedException {
        DBInitializer.getInstance();
        DBManager dbManager = DBManager.getInstance();
        Instant startProg = Instant.now();
        double totalLostTime = 0;
        for (int i = 0; i < 20; i++){
            Instant start = Instant.now();
            JSONObject response = APIRequest.getInstance().sendGetRequest("/assets");
            Instant endRequest = Instant.now();
            totalLostTime += Duration.between(start, endRequest).toMillis();

            if (response != null) {
                //System.out.println("#----------------------------------------#\nCryptomonnaies enregistrées :");
                //System.out.println("------------------");
                List<Cryptocurrency> cryptocurrencies = JSONManager.getInstance().createCryptocurrencies(response);
                //for (Cryptocurrency cryptocurrency : cryptocurrencies){
                //    System.out.println(cryptocurrency.toString());
                //    System.out.println("------------------");
                //}
                //System.out.println("#----------------------------------------#");

                //System.out.println("Inserting Cryptocurrencies into database ...");
                for (Cryptocurrency cryptocurrency : cryptocurrencies){
                    DBManager.getInstance().addCryptocurrencyData(cryptocurrency);
                }
                //System.out.println("Done !");
            }

            Instant end = Instant.now();
            long duration = Duration.between(start, end).toMillis();

            if (duration < 1000) {
                System.out.println("Needed");
                Thread.sleep(1000 - duration);
            }
        }

        Instant endProg = Instant.now();
        long duration = Duration.between(startProg, endProg).toMillis();
        System.out.println("Program duration : " + duration + " ms");
        System.out.println("Average request duration : " + (totalLostTime / 20) + " ms");

        /*for (int i = 0; i < 20; i++){
            JSONObject response = APIRequest.getInstance().sendGetRequest("/exchanges");
    
            if (response != null) {
                System.out.println("#----------------------------------------#\nPlateformes d'échange enregistrées :");
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

        System.out.println(DBManager.getInstance().getExchanges().size());*/

        List<Cryptocurrency> cryptocurrencies = dbManager.getCryptocurrencies("Bitcoin");

        double count = 0;
        for (int i = cryptocurrencies.size() - 20; i < cryptocurrencies.size() - 1; i++){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

            String timestamp1 = cryptocurrencies.get(i).getTimestamp();
            String timestamp2 = cryptocurrencies.get(i + 1).getTimestamp();

            LocalDateTime dateTime1 = LocalDateTime.parse(timestamp1, formatter);
            LocalDateTime dateTime2 = LocalDateTime.parse(timestamp2, formatter);

            Duration duration2 = Duration.between(dateTime1, dateTime2);

            count += duration2.getSeconds();
        }

        System.out.println(count);
        count = count / 19;
        System.out.println("Average time between two updates : " + count + " seconds.");

        //for (Cryptocurrency cryptocurrency : cryptocurrencies){
        //    System.out.println(cryptocurrency.toString());
        //}
    }
}