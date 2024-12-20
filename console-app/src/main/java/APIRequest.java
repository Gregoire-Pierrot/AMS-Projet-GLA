import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import io.github.cdimascio.dotenv.Dotenv;

public class APIRequest {
    private static APIRequest instance;
    private final String API_URL = "https://api.coincap.io/v2";
    private final String API_KEY;

    public static APIRequest getInstance(){
        if (instance == null){
            instance = new APIRequest();
        }
        return instance;
    }

    private APIRequest() {
        Dotenv dotenv = Dotenv.load();
        this.API_KEY = dotenv.get("COINCAP_API_KEY");
        if (this.API_KEY == null || this.API_KEY.isEmpty()) {
            throw new IllegalStateException("API Key is missing in .env file.");
        }
    }

    public JSONObject sendGetRequest(String endpoint) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            String urlString = API_URL + endpoint;
            URL url = new URL(urlString);

            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + API_KEY);

            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : " + responseCode);
            }

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder responseBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
            }

            return new JSONObject(responseBuilder.toString());

        } catch (Exception e) {
            System.err.println("Erreur lors de la requête HTTP : " + e.getMessage());
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (connection != null) {
                    connection.disconnect();
                }
            } catch (Exception e) {
                System.err.println("Erreur lors de la fermeture des ressources : " + e.getMessage());
            }
        }
    }
    
}
