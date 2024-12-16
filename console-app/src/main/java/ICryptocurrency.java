public interface ICryptocurrency {

    String getId();
    int getRank();
    String getSymbol();
    String getName();
    double getSupply();
    double getMaxSupply();
    double getMarketCapUsd();
    double getVolumeUsd24Hr();
    double getPriceUsd();
    double getChangePercent24Hr();
    double getVwrap24Hr();
    String getTimestamp();
    String toString();

}
