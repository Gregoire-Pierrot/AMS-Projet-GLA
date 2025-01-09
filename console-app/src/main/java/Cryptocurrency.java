/**
 * Java class of a cryptocurrency.
 * 
 * @author Grégoire Pierrot.
 */
public class Cryptocurrency implements ICryptocurrency {
    /** The unique identifier for the cryptocurrency. **/
    private final String id;
    /** The rank of the cryptocurrency. **/
    private final int rank;
    /** The symbol of the cryptocurrency. **/
    private final String symbol;
    /** The name of the cryptocurrency. **/
    private final String name;
    /** The total supply of the cryptocurrency. **/
    private final double supply;
    /** The maximum supply of the cryptocurrency. **/
    private final double maxSupply;
    /** The market capitalization of the cryptocurrency in US dollars. **/
    private final double marketCapUsd;
    /** The 24 hour volume of the cryptocurrency in US dollars. **/
    private final double volumeUsd24Hr;
    /** The price of the cryptocurrency in US dollars. **/
    private final double priceUsd;
    /** The 24 hour change in percentage. **/
    private final double changerPercent24Hr;
    /** The 24 hour volume weighted average price of the cryptocurrency. **/
    private final double vwap24Hr;
    /** The timestamp at which the data was fetched. **/
    private final String timestamp;

    /**
     * Cryptocurrency constructor.
     * 
     * @param id Unique identifier for the cryptocurrency.
     * @param rank The rank of the cryptocurrency.
     * @param symbol The symbol of the cryptocurrency.
     * @param name The name of the cryptocurrency.
     * @param supply The total supply of the cryptocurrency.
     * @param maxSupply The maximum supply of the cryptocurrency.
     * @param marketCapUsd The market capitalization of the cryptocurrency in US dollars.
     * @param volumeUsd24Hr The 24 hour volume of the cryptocurrency in US dollars.
     * @param priceUsd The price of the cryptocurrency in US dollars.
     * @param changePercent24Hr The 24 hour change in percentage.
     * @param vwap24Hr The 24 hour volume weighted average price of the cryptocurrency.
     * @param timestamp The timestamp of the data.
     */
    public Cryptocurrency(String id,
                    int rank,
                    String symbol,
                    String name,
                    double supply,
                    double maxSupply,
                    double marketCapUsd,
                    double volumeUsd24Hr,
                    double priceUsd,
                    double changePercent24Hr,
                    double vwap24Hr,
                    String timestamp) {
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

    /**
     * Get the Cryptcurrency id.
     * 
     * @return the Cryptocurrency id.
     */
    @Override
    public String getId() { return id; }

    /**
     * Get the Cryptcurrency rank.
     * 
     * @return the Cryptocurrency rank.
     */
    @Override
    public int getRank() { return rank; }

    /**
     * Get the Cryptcurrency symbol.
     * 
     * @return the Cryptocurrency symbol.
     */
    @Override
    public String getSymbol() { return symbol; }

    /**
     * Get the Cryptcurrency name.
     * 
     * @return the Cryptocurrency name.
     */
    @Override
    public String getName() { return name; }

    /**
     * Get the Cryptcurrency supply.
     * 
     * @return the Cryptocurrency supply.
     */
    @Override
    public double getSupply() { return supply; }

    /**
     * Get the Cryptcurrency maxSupply.
     * 
     * @return the Cryptocurrency maxSupply.
     */
    @Override
    public double getMaxSupply() { return maxSupply; }

    /**
     * Get the Cryptcurrency marketCapUsd.
     * 
     * @return the Cryptocurrency marketCapUsd.
     */
    @Override
    public double getMarketCapUsd() { return marketCapUsd; }

    /**
     * Get the Cryptcurrency volume24Hr.
     * 
     * @return the Cryptocurrency volume24Hr.
     */
    @Override
    public double getVolumeUsd24Hr() { return volumeUsd24Hr; }

    /**
     * Get the Cryptcurrency priceUsd.
     * 
     * @return the Cryptocurrency priceUsd.
     */
    @Override
    public double getPriceUsd() { return priceUsd; }

    /**
     * Get the Cryptcurrency changerPercent24Hr.
     * 
     * @return the Cryptocurrency changerPercent24Hr.
     */
    @Override
    public double getChangePercent24Hr() { return changerPercent24Hr; }

    /**
     * Get the Cryptcurrency vwap24Hr.
     * 
     * @return the Cryptocurrency vwap24Hr.
     */
    @Override
    public double getVwap24Hr() { return vwap24Hr; }

    /**
     * Get the Cryptcurrency timestamp.
     * 
     * @return the Cryptocurrency timestmp.
     */
    @Override
    public String getTimestamp() { return timestamp; }

    /**
     * Returns a string representation of the object.
     * 
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "Id : " + id
            + "\nRank : " + rank
            + "\nSymbol : " + symbol
            + "\nName : " + name
            + "\nSupply : " + supply
            + "\nMaxSupply : " + maxSupply
            + "\nMarketCapUsd : " + marketCapUsd
            + "\nVolumeUsd24Hr : " + volumeUsd24Hr
            + "\nPriceUsd : " + priceUsd
            + "\nChangePercent24Hr : " + changerPercent24Hr
            + "\nVwap24Hr : " + vwap24Hr
            + "\nTimestamp : " + timestamp;
    }
    
}
