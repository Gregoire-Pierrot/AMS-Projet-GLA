import static org.junit.Assert.*;

import org.mockito.Mockito;
import org.junit.Before;
import org.junit.Test;

public class IExchangeTest {
    private IExchange iExchange_mocked;

    @Before
    public void setUp() {
        iExchange_mocked = Mockito.mock(IExchange.class);
    }

    @Test
    public void getIdTest() {
        String id = "binance";
        Mockito.when(iExchange_mocked.getId()).thenReturn(id);
        assertEquals(id, iExchange_mocked.getId());
    }

    @Test
    public void getNameTest() {
        String name = "Binance";
        Mockito.when(iExchange_mocked.getName()).thenReturn(name);
        assertEquals(name, iExchange_mocked.getName());
    }

    @Test
    public void getRankTest() {
        int rank = 1;
        Mockito.when(iExchange_mocked.getRank()).thenReturn(rank);
        assertEquals(rank, iExchange_mocked.getRank());
    }

    @Test
    public void getPercentTotalVolumeTest() {
        double percentTotalVolume = 1;
        Mockito.when(iExchange_mocked.getPercentTotalVolume()).thenReturn(percentTotalVolume);
        assertEquals(percentTotalVolume, iExchange_mocked.getPercentTotalVolume(), 0.001);
    }

    @Test
    public void getVolumeUsdTest() {
        double volumeUsd = 1;
        Mockito.when(iExchange_mocked.getVolumeUsd()).thenReturn(volumeUsd);
        assertEquals(volumeUsd, iExchange_mocked.getVolumeUsd(), 0.001);
    }

    @Test
    public void getTradingPairsTest() {
        int tradingPairs = 1;
        Mockito.when(iExchange_mocked.getTradingPairs()).thenReturn(tradingPairs);
        assertEquals(tradingPairs, iExchange_mocked.getTradingPairs());
    }

    @Test
    public void getSocketTest() {
        boolean socket = false;
        Mockito.when(iExchange_mocked.getSocket()).thenReturn(socket);
        assertEquals(socket, iExchange_mocked.getSocket());
    }
}
