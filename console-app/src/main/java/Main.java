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

        /*List<Thread> threads = new ArrayList<Thread>();

        Thread cryptocurrenciesThread = new Thread(() -> {
            System.out.println("Starting cryptocurrencies thread...");
            try {
                while (running) {
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
                }
                System.out.println("Cryptocurrencies thread stopped.");
            } catch (SQLException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread exchangesThread = new Thread(() -> {
            System.out.println("Starting exchanges thread...");
            try {
                while (running) {
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
                }
                System.out.println("Exchanges thread stopped.");
            } catch (SQLException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread inputThread = new Thread(() -> {
            System.out.println("Starting input thread...");
            Scanner scanner = new Scanner(System.in);
            while (running) {
                if (scanner.nextLine().equals("stop")){
                    System.out.println("Stopping...");
                    running = false;
                }
                else if (scanner.nextLine().startsWith("stop")){
                    String line = scanner.nextLine();
                    String[] arguments = line.split(" ");
                    for (int i = 1; i < arguments.length; i++){
                        switch (arguments[i]){
                            case "-c":
                                cryptocurrenciesThreadRunning = false;
                                break;
                            case "-e":
                                cryptocurrenciesThreadRunning = false;
                                break;
                            default:
                                break;
                        }
                    }
                }
                else if (scanner.nextLine().startsWith("start")){
                    System.out.println("Hello");
                    String line = scanner.nextLine();
                    String[] arguments = line.split(" ");
                    if (arguments.length == 1){ System.out.println("Erreur d'argument, veuillez rentrer au moins un argument."); }
                    for (int i = 1; i < arguments.length; i++){
                        switch (arguments[i]){
                            case "-c":
                                cryptocurrenciesThread.start();
                                break;
                            case "-e":
                                exchangesThread.start();
                                break;
                            default:
                                break;
                        }
                    }
                }
                else { System.out.println("Commande non reconnue."); }
            }
            scanner.close();
        });

        threads.add(inputThread);

        if (args.length == 0){
            threads.add(cryptocurrenciesThread);
            threads.add(exchangesThread);
        }
        else {
            if (!args[0].equals("start")){ System.out.println("Erreur d'argument, veuillez utiliser \"start\" comme premier argument"); System.exit(1); }
            if (args.length > 1){
                for (int i = 1; i < args.length; i++){
                    switch (args[i]) {
                        case "-c":
                            threads.add(cryptocurrenciesThread);
                            break;
                        case "-e":
                            threads.add(exchangesThread);
                            break;                
                        default:
                            System.out.println("Argument non valide : " + args[i] + ", veuillez utiliser \"start\" suivi d'arguments valides");
                            System.exit(1);
                    }
                }
            }
        }

        for (Thread thread : threads){
            thread.start();
        }*/

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
            System.out.println("Starting exchnage thread...");
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