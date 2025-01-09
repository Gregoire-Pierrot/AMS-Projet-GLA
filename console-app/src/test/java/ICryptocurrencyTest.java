import static org.junit.Assert.*;

import org.mockito.Mockito;
import org.junit.Before;
import org.junit.Test;

public class ICryptocurrencyTest {
    private ICryptocurrency iCryptocurrency_mocked;

    @Before
    public void setUp() {
        iCryptocurrency_mocked = Mockito.mock(ICryptocurrency.class);
    }

    @Test
    public void getIdTest() {
        String id = "bitcoin";
        Mockito.when(iCryptocurrency_mocked.getId()).thenReturn(id);
        assertEquals(id, iCryptocurrency_mocked.getId());
    }

    @Test
    public void getRankTest() {
        int rank = 1;
        Mockito.when(iCryptocurrency_mocked.getRank()).thenReturn(rank);
        assertEquals(rank, iCryptocurrency_mocked.getRank());
    }

    @Test
    public void getSymbolTest() {
        String symbol = "BTC";
        Mockito.when(iCryptocurrency_mocked.getSymbol()).thenReturn(symbol);
        assertEquals(symbol, iCryptocurrency_mocked.getSymbol());
    }

    @Test
    public void getNameTest() {
        String name = "Bitcoin";
        Mockito.when(iCryptocurrency_mocked.getName()).thenReturn(name);
        assertEquals(name, iCryptocurrency_mocked.getName());
    }

    @Test
    public void getSupplyTest() {
        double supply = 1;
        Mockito.when(iCryptocurrency_mocked.getSupply()).thenReturn(supply);
        assertEquals(supply, iCryptocurrency_mocked.getSupply(), 0.001);
    }

    @Test
    public void getMaxSupplyTest() {
        double maxSupply = 1;
        Mockito.when(iCryptocurrency_mocked.getMaxSupply()).thenReturn(maxSupply);
        assertEquals(maxSupply, iCryptocurrency_mocked.getMaxSupply(), 0.001);
    }

    @Test
    public void getMarketCapUsdTest() {
        double marketCapUsd = 1;
        Mockito.when(iCryptocurrency_mocked.getMarketCapUsd()).thenReturn(marketCapUsd);
        assertEquals(marketCapUsd, iCryptocurrency_mocked.getMarketCapUsd(), 0.001);
    }

    @Test
    public void getVolumeUsd24HrTest() {
        double volumeUsd24Hr = 1;
        Mockito.when(iCryptocurrency_mocked.getVolumeUsd24Hr()).thenReturn(volumeUsd24Hr);
        assertEquals(volumeUsd24Hr, iCryptocurrency_mocked.getVolumeUsd24Hr(), 0.001);
    }

    @Test
    public void getPriceUsdTest() {
        double priceUsd = 1;
        Mockito.when(iCryptocurrency_mocked.getPriceUsd()).thenReturn(priceUsd);
        assertEquals(priceUsd, iCryptocurrency_mocked.getPriceUsd(), 0.001);
    }

    @Test
    public void getChangePercent24HrTest() {
        double changePercent24Hr = 1;
        Mockito.when(iCryptocurrency_mocked.getChangePercent24Hr()).thenReturn(changePercent24Hr);
        assertEquals(changePercent24Hr, iCryptocurrency_mocked.getChangePercent24Hr(), 0.001);
    }

    @Test
    public void getVwap24HrTest() {
        double vwap24Hr = 1;
        Mockito.when(iCryptocurrency_mocked.getVwap24Hr()).thenReturn(vwap24Hr);
        assertEquals(vwap24Hr, iCryptocurrency_mocked.getVwap24Hr(), 0.001);
    }

    @Test
    public void getTimestampTest() {
        String timestamp = "01-01-1970 00:00:00";
        Mockito.when(iCryptocurrency_mocked.getTimestamp()).thenReturn(timestamp);
        assertEquals(timestamp, iCryptocurrency_mocked.getTimestamp());
    }
}
