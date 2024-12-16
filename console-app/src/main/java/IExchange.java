public interface IExchange {

    String getId();
    String getName();
    int getRank();
    double getPercentTotalVolume();
    double getVolumeUsd();
    int getTradingPairs();
    boolean getSocket();
    String getExchangeUrl();
    String getUpdated();
    String toString();
    
}
