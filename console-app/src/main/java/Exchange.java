public class Exchange implements IExchange {
    private final String id;
    private final String name;
    private final int rank;
    private final double percentTotalVolume;
    private final double volumeUsd;
    private final int tradingPairs;
    private final boolean socket;
    private final String exchangeUrl;
    private final String updated;

    public Exchange(String id, String name, int rank, double percentTotalVolume, double volumeUsd, int tradingPairs, boolean socket, String exchangeUrl, String updated){
        this.id = id;
        this.name = name;
        this.rank = rank;
        this.percentTotalVolume = percentTotalVolume;
        this.volumeUsd = volumeUsd;
        this.tradingPairs = tradingPairs;
        this.socket = socket;
        this.exchangeUrl = exchangeUrl;
        this.updated = updated;
    }

    @Override
    public String getId(){ return id; }
    
    @Override
    public String getName() { return name; }

    @Override
    public int getRank() { return rank; }

    @Override
    public double getPercentTotalVolume() { return percentTotalVolume; }

    @Override
    public double getVolumeUsd() { return volumeUsd; }

    @Override
    public int getTradingPairs() { return tradingPairs; }

    @Override
    public boolean getSocket() { return socket; }

    @Override
    public String getExchangeUrl() { return exchangeUrl; }

    @Override
    public String getUpdated() { return updated; }

    @Override
    public String toString() {
        return "Id : " + id + "\nName : " + name + "\nRank : " + rank + "\nPercentTotalVolume : " + percentTotalVolume + "\nVolumeUsd : " + volumeUsd + "\nTraidingPairs : " + tradingPairs + "\nSocket : " + socket + "\nExchangeUrl : " + exchangeUrl + "\nUpdated : " + updated;
    }

}
