public class Cryptocurrency implements ICryptocurrency{
    private final String id;
    private final int rank;
    private final String symbol;
    private final String name;
    private final double supply;
    private final double maxSupply;
    private final double marketCapUsd;
    private final double volumeUsd24Hr;
    private final double priceUsd;
    private final double changerPercent24Hr;
    private final double vwap24Hr;
    private final String timestamp;

    public Cryptocurrency(String id, int rank, String symbol, String name, double supply, double maxSupply, double marketCapUsd, double volumeUsd24Hr, double priceUsd, double changePercent24Hr, double vwap24Hr, String timestamp){
        this.id = id;
        this.rank = rank;
        this.symbol = symbol;
        this.name = name;
        this.supply = supply;
        this.maxSupply = maxSupply;
        this.marketCapUsd = marketCapUsd;
        this.volumeUsd24Hr = volumeUsd24Hr;
        this.priceUsd = priceUsd;
        this.changerPercent24Hr = changePercent24Hr;
        this.vwap24Hr = vwap24Hr;
        this.timestamp = timestamp;
    }

    @Override
    public String getId() { return id; }

    @Override
    public int getRank() { return rank; }

    @Override
    public String getSymbol() { return symbol; }

    @Override
    public String getName() { return name; }

    @Override
    public double getSupply() { return supply; }

    @Override
    public double getMaxSupply() { return maxSupply; }

    @Override
    public double getMarketCapUsd() { return marketCapUsd; }

    @Override
    public double getVolumeUsd24Hr() { return volumeUsd24Hr; }

    @Override
    public double getPriceUsd() { return priceUsd; }

    @Override
    public double getChangePercent24Hr() { return changerPercent24Hr; }

    @Override
    public double getVwap24Hr() { return vwap24Hr; }

    @Override
    public String getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return "Id : " + id + "\nRank : " + rank + "\nSymbol : " + symbol + "\nName : " + name + "\nSupply : " + supply + "\nMaxSupply : " + maxSupply + "\nMarketCapUsd : " + marketCapUsd + "\nVolumeUsd24Hr : " + volumeUsd24Hr + "\nPriceUsd : " + priceUsd + "\nChangePercent24Hr : " + changerPercent24Hr + "\nVwap24Hr : " + vwap24Hr + "\nTimestamp : " + timestamp;
    }
    
}
