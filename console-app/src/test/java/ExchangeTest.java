import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class ExchangeTest {
    private Exchange exchange;

    @Before
    public void setUp() {
        exchange = new Exchange(
            "binance",
            "Binance",
            1,
            25.0,
            500000000.0,
            1234,
            true,
            "https://www.binance.com",
            "2025-01-06T12:00:00Z"
        );
    }

    @Test
    public void exchangeNotNullTest() {
        assertNotNull(exchange);
    }

    @Test
    public void getIdTest() {
        assertEquals("binance", exchange.getId());
    }

    @Test
    public void getNameTest() {
        assertEquals("Binance", exchange.getName());
    }

    @Test
    public void getRankTest() {
        assertEquals(1, exchange.getRank());
    }

    @Test
    public void getPercentTotalVolumeTest() {
        assertEquals(25.0, exchange.getPercentTotalVolume(), 0.0001);
    }

    @Test
    public void getVolumeUsdTest() {
        assertEquals(500000000.0, exchange.getVolumeUsd(), 0.0001);
    }

    @Test
    public void getTradingPairsTest() {
        assertEquals(1234, exchange.getTradingPairs());
    }

    @Test
    public void getSocketTest() {
        assertEquals(true, exchange.getSocket());
    }

    @Test
    public void getExchangeUrlTest() {
        assertEquals("https://www.binance.com", exchange.getExchangeUrl());
    }

    @Test
    public void getUpdatedTest() {
        assertEquals("2025-01-06T12:00:00Z", exchange.getUpdated());
    }

    @Test
    public void toStringTest() {
        String expected = "Id : " + exchange.getId() +
                          "\nName : " + exchange.getName() +
                          "\nRank : " + exchange.getRank() +
                          "\nPercentTotalVolume : " + exchange.getPercentTotalVolume() +
                          "\nVolumeUsd : " + exchange.getVolumeUsd() +
                          "\nTraidingPairs : " + exchange.getTradingPairs() +
                          "\nSocket : " + exchange.getSocket() +
                          "\nExchangeUrl : " + exchange.getExchangeUrl() +
                          "\nUpdated : " + exchange.getUpdated();

        assertEquals(expected, exchange.toString());
    }
}
