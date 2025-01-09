import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockedStatic;

import io.github.cdimascio.dotenv.Dotenv;

public class APIRequestTest {
    private MockedStatic<Dotenv> dotenvMock;

    @Before
    public void setUp() {
        // Mock Dotenv.load() to provide a mock API key
        dotenvMock = mockStatic(Dotenv.class);
        Dotenv mockDotenv = mock(Dotenv.class);
        when(Dotenv.load()).thenReturn(mockDotenv);
        when(mockDotenv.get("COINCAP_API_KEY")).thenReturn("mock-api-key");
    }

    @Test
    public void singletonInstanceTest() {
        APIRequest instance1 = APIRequest.getInstance();
        APIRequest instance2 = APIRequest.getInstance();
        assertEquals(instance1, instance2);
    }

    @Test
    public void getApiKeyTest() {
        APIRequest apiRequest = APIRequest.getInstance();
        assertEquals("mock-api-key", apiRequest.getApiKey(), "API key should match the mocked value");
    }

    @Test
    public void sendGetRequestTest() {
        APIRequest apiRequest = APIRequest.getInstance();
        JSONObject response = apiRequest.sendGetRequest("/assets");
        assertNotNull(response);
        assertSame(JSONObject.class, response.getClass());

        JSONArray datas = response.getJSONArray("data");
        assertEquals(100, datas.length());

        Long timestamp = response.getLong("timestamp");
        assertNotNull(timestamp);

        JSONObject data = datas.getJSONObject(0);

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

        assertNotNull(id);
        assertNotNull(rank);
        assertNotNull(symbol);
        assertNotNull(name);
        assertNotNull(supply);
        assertNotNull(maxSupply);
        assertNotNull(marketCapUsd);
        assertNotNull(volumeUsd24Hr);
        assertNotNull(priceUsd);
        assertNotNull(changePercent24Hr);
        assertNotNull(vwrap24Hr);

        assertThrows(Exception.class, () -> apiRequest.sendGetRequest("invalid_endpoint"));
    }
}
