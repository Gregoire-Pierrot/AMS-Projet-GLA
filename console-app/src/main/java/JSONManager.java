import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONManager {
    private static JSONManager instance;

    private JSONManager() {}

    public static JSONManager getInstance(){
        if (instance == null){
            instance = new JSONManager();
        }
        return instance;
    }

    public List<Cryptocurrency> createCryptocurrencies(JSONObject response){
        List<Cryptocurrency> cryptocurrencies = new ArrayList<Cryptocurrency>();

        String timestamp = response.get("timestamp").toString();

        JSONArray datas = response.getJSONArray("data");

        for (int i = 0; i < datas.length(); i++){
            JSONObject data = datas.getJSONObject(i);

            String id = data.getString("id");
            int rank = data.optInt("rank");
            String symbol = data.getString("symbol");
            String name = data.getString("name");
            double supply = data.optDouble("supply");
            double maxSupply = data.optDouble("maxSupply");
            double marketCapUsd = data.optDouble("marketCapUsd");
            double volumeUsd24Hr = data.optDouble("volumeUsd24Hr");
            double priceUsd = data.optDouble("priceUsd");
            double changePercent24Hr = data.optDouble("changePercent24Hr");
            double vwrap24Hr = data.optDouble("vwrap24Hr");

            Cryptocurrency cryptocurrency = new Cryptocurrency(id, rank, symbol, name, supply, maxSupply, marketCapUsd, volumeUsd24Hr, priceUsd, changePercent24Hr, vwrap24Hr, timestamp);
            cryptocurrencies.add(cryptocurrency);
        }

        return  cryptocurrencies;
    }

    public List<Exchange> createExchanges(JSONObject response){
        List<Exchange> exchanges = new ArrayList<Exchange>();

        JSONArray datas = response.getJSONArray("data");
        for (int i = 0; i < datas.length(); i++){
            JSONObject data = datas.getJSONObject(i);

            String id = data.getString("exchangeId");
            String name = data.getString("name");
            int rank = data.optInt("rank");
            double percentTotalVolume = data.optDouble("percentTotalVolume");
            double volumeUsd = data.optDouble("volumeUsd");
            int tradingPairs = data.optInt("tradingPairs");
            boolean socket = data.optBoolean("socket");
            String exchangeUrl = data.getString("exchangeUrl");
            String updated = data.get("updated").toString();

            Exchange exchange = new Exchange(id, name, rank, percentTotalVolume, volumeUsd, tradingPairs, socket, exchangeUrl, updated);
            exchanges.add(exchange);
        }

        return exchanges;
    }
    
}
