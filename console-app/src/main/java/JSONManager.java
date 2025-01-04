import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Java class to manage JSON data.
 * 
 * @author Grégoire Pierrot.
 */
public class JSONManager {
    /** Singleton **/
    private static JSONManager instance;

    /** Constructor */
    private JSONManager() {}

    /**
     * Get the JSONManager instance.
     * 
     * @return instance of JSONManager.
     */
    public static JSONManager getInstance(){
        if (instance == null){
            instance = new JSONManager();
        }
        return instance;
    }

    /**
     * Creates a list of Cryptocurrency objects from a JSONObject.
     * 
     * The object should have a "timestamp" field and a "data" field which is
     * an array of objects with the following fields:
     *     id, rank, symbol, name, supply, maxSupply, marketCapUsd,
     *     volumeUsd24Hr, priceUsd, changePercent24Hr, vwrap24Hr
     * 
     * @param response The JSONObject to parse.
     * @return A list of Cryptocurrency objects.
     */
    public List<Cryptocurrency> createCryptocurrencies(JSONObject response){
        List<Cryptocurrency> cryptocurrencies = new ArrayList<Cryptocurrency>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String timestamp = sdf.format(new Timestamp(Long.parseLong(response.get("timestamp").toString())));

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

    /**
     * Creates a list of Exchange objects from a JSONObject.
     * 
     * The object should have a "data" field which is an array of objects with
     * the following fields:
     *     exchangeId, name, rank, percentTotalVolume, volumeUsd, tradingPairs,
     *     socket, exchangeUrl, updated
     * 
     * @param response The JSONObject to parse.
     * @return A list of Exchange objects.
     */
    public List<Exchange> createExchanges(JSONObject response){
        List<Exchange> exchanges = new ArrayList<Exchange>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

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
            String updated = sdf.format(new Timestamp(Long.parseLong(data.get("updated").toString())));

            Exchange exchange = new Exchange(id, name, rank, percentTotalVolume, volumeUsd, tradingPairs, socket, exchangeUrl, updated);
            exchanges.add(exchange);
        }

        return exchanges;
    }
    
}
