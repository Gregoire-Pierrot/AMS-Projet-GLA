import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class CryptocurrencyTest {
    private Cryptocurrency cryptocurrency;

    @Before
    public void setUp() {
        cryptocurrency = new Cryptocurrency(
            "bitcoin",
            1,
            "BTC",
            "Bitcoin",
            19000000,
            21000000,
            600000000000.0,
            25000000000.0,
            30000.0,
            2.5,
            29500.0,
            "2025-01-06T11:30:00Z"
        );
    }

    @Test
    public void cryptocurrencyNotNullTest() {
        assertNotNull(cryptocurrency);
    }

    @Test
    public void getIdTest() {
        assertEquals("bitcoin", cryptocurrency.getId());
    }

    @Test
    public void getRankTest() {
        assertEquals(1, cryptocurrency.getRank());
    }

    @Test
    public void getSymbolTest() {
        assertEquals("BTC", cryptocurrency.getSymbol());
    }

    @Test
    public void getNameTest() {
        assertEquals("Bitcoin", cryptocurrency.getName());
    }

    @Test
    public void getSupplyTest() {
        assertEquals(19000000, cryptocurrency.getSupply(), 0.0001);
    }

    @Test
    public void getMaxSupplyTest() {
        assertEquals(21000000, cryptocurrency.getMaxSupply(), 0.0001);
    }

    @Test
    public void getMarketCapUsdTest() {
        assertEquals(600000000000.0, cryptocurrency.getMarketCapUsd(), 0.0001);
    }

    @Test
    public void getVolumeUsd24HrTest() {
        assertEquals(25000000000.0, cryptocurrency.getVolumeUsd24Hr(), 0.0001);
    }

    @Test
    public void getPriceUsdTest() {
        assertEquals(30000.0, cryptocurrency.getPriceUsd(), 0.0001);
    }

    @Test
    public void getChangePercent24HrTest() {
        assertEquals(2.5, cryptocurrency.getChangePercent24Hr(), 0.0001);
    }

    @Test
    public void getVwap24HrTest() {
        assertEquals(29500.0, cryptocurrency.getVwap24Hr(), 0.0001);
    }

    @Test
    public void getTimestampTest() {
        assertEquals("2025-01-06T11:30:00Z", cryptocurrency.getTimestamp());
    }

    @Test
    public void toStringTest() {
        String expected = "Id : " + cryptocurrency.getId() +
                          "\nRank : " + cryptocurrency.getRank() +
                          "\nSymbol : " + cryptocurrency.getSymbol() +
                          "\nName : " + cryptocurrency.getName() +
                          "\nSupply : " + cryptocurrency.getSupply() +
                          "\nMaxSupply : " + cryptocurrency.getMaxSupply() +
                          "\nMarketCapUsd : " + cryptocurrency.getMarketCapUsd() +
                          "\nVolumeUsd24Hr : " + cryptocurrency.getVolumeUsd24Hr() +
                          "\nPriceUsd : " + cryptocurrency.getPriceUsd() +
                          "\nChangePercent24Hr : " + cryptocurrency.getChangePercent24Hr() +
                          "\nVwap24Hr : " + cryptocurrency.getVwap24Hr() +
                          "\nTimestamp : " + cryptocurrency.getTimestamp();

        assertEquals(expected, cryptocurrency.toString());
    }
}
