import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Scanner;

import org.json.JSONObject;

/**
 * Main class to run the console app.
 */
public class Main {
    /** Variables **/
    private static volatile boolean running = true;
    private static volatile DBManager dbManager;

        /**
         * Main method to run the console app.
         * <p>
         * This method launch three threads:
         * <ul>
         * <li>Input thread to catch the user's input and stop the program if "stop" is typed.</li>
         * <li>Cryptocurrencies thread to get the data of all the cryptocurrencies and add it to the database.</li>
         * <li>Exchange thread to get the data of all the exchanges and add it to the database.</li>
         * </ul>
         * <p>
         * The program print the data added to the database.
         * @param args the command line arguments
         * @throws SQLException if the query fail.
         * @throws InterruptedException if the thread is interrupted.
         */
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
                
                    int min_time = 20000; 
                    if (duration < min_time) {
                        Thread.sleep(min_time - duration);
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
                
                    int min_time = 60000;
                    if (duration < min_time) {
                        Thread.sleep(min_time - duration);
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

        Thread.sleep(1000);

        System.out.println("Started !");
        System.out.println("Use \"stop\" to stop the program.");
    }
}