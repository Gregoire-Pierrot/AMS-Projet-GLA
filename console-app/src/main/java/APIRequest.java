import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * Java class singleton to make requests to coicap API.
 * 
 * @author Grégoire Pierrot.
 */
public class APIRequest {
    /** Unique instance of APIRequest. **/
    private static APIRequest instance;
    /** URL of the API **/
    private final String API_URL = "https://api.coincap.io/v2";
    /** API Key **/
    private final String API_KEY;

    /**
     * Get the APIRequest instance.
     * 
     * @return instance of APIRequest.
     */
    public static APIRequest getInstance() {
        if (instance == null) {
            instance = new APIRequest();
        }
        return instance;
    }

    /**
     * APIRequest constructor.
     */
    private APIRequest() {
        this.API_KEY = getApiKey();
        if (this.API_KEY == null || this.API_KEY.isEmpty()) {
            throw new IllegalStateException("API Key is missing in .env file.");
        }
    }

    /**
     * Take the environement variable API_KEY.
     * 
     * @return The environement vairable COINCAP_API_KEY from .env.
     */
    private String getApiKey() {
        return Dotenv.load().get("COINCAP_API_KEY");
    }

    /**
     * Send a requests to the API_URL with the endpoint.
     * 
     * @param endpoint Endpoint url.
     * @return JSObject created whit the request's response.
     */
    public JSONObject sendGetRequest(final String endpoint) {
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
