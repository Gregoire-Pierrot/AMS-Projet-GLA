import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Scanner;

import org.json.JSONObject;

public class Main {
    private static volatile boolean running = true;
    private static volatile DBManager dbManager;

    public static void main(String[] args) throws SQLException, InterruptedException {
        DBInitializer.getInstance();
        dbManager = DBManager.getInstance();

        Thread inputThread = new Thread(() -> {
            System.out.println("Starting input thread...");
            Scanner scanner = new Scanner(System.in);
            while (running) {
                if (scanner.nextLine().equals("stop")){
                    System.out.println("Stopping...");
                    running = false;
                }
            }
            scanner.close();
        });

        Thread cryptocurrenciesThread = new Thread(() -> {
            System.out.println("Starting cryptocurrencies thread...");
            while (running){
                try {  
                    Instant start = Instant.now();
                    JSONObject response = APIRequest.getInstance().sendGetRequest("/assets");

                    if (response != null) {
                        List<Cryptocurrency> cryptocurrencies = JSONManager.getInstance().createCryptocurrencies(response);
                        for (Cryptocurrency cryptocurrency : cryptocurrencies){
                            dbManager.addCryptocurrencyData(cryptocurrency);
                        }
                        System.out.println("New cryptocurrencies added.");
                    }
                
                    Instant end = Instant.now();
                    long duration = Duration.between(start, end).toMillis();
                
                    if (duration < 1000) {
                        Thread.sleep(1000 - duration);
                    }
                } catch (SQLException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread exchangeThread = new Thread(() -> {
            System.out.println("Starting exchange thread...");
            while (running){
                try {  
                    Instant start = Instant.now();
                    JSONObject response = APIRequest.getInstance().sendGetRequest("/exchanges");

                    if (response != null) {
                        List<Exchange> exchanges = JSONManager.getInstance().createExchanges(response);
                        for (Exchange exchange : exchanges){
                            dbManager.addExchange(exchange);
                        }
                        System.out.println("New exchanges added.");
                    }
                
                    Instant end = Instant.now();
                    long duration = Duration.between(start, end).toMillis();
                
                    if (duration < 10000) {
                        Thread.sleep(10000 - duration);
                    }
                } catch (SQLException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println("Starting ...\n---------------------");

        inputThread.start();
        cryptocurrenciesThread.start();
        exchangeThread.start();

        System.out.println("Started !");
        System.out.println("Use \"stop\" to stop the program.");
    }
}