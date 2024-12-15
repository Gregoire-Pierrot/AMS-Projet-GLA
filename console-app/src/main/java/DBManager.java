public class DBManager {
    private static DBManager instance;

    public static DBManager getInstance(){
        if (instance == null){
            instance = new DBManager();
        }
        return instance;
    }

    private DBManager() {}

    private void addTimeStamp(String timestamp){

    }

    private void addCryptocurrency(String id, String symbol, String name){
        
    }

    private void addCryptocurrencyData(String id, int rank, double supply, double maxSupply, double marketCapUsd, double volumeUsd24Hr, double priceUsd, double changePercent24Hr, double vwap24Hr, int timestamp){

    }

    private void addExchanges(String id, String name, int rank, double percentTotalVolume, double volumeUsd, int tradingPairs, boolean socket, String exchangeUrl, int updated){

    }
}
