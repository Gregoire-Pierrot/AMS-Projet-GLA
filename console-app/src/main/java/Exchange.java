/**
 * Java class of an exchange.
 * 
 * @author Grégoire Pierrot.
 */
public class Exchange implements IExchange {
    /** The unique identifier of the exchange. */
    private final String id;
    /** Name of the exchange. */
    private final String name;
    /** Rank of the exchange. */
    private final int rank;
    /** Percent of the exchanges total volume. */
    private final double percentTotalVolume;
    /** Total volume of the exchanges in USD. */
    private final double volumeUsd;
    /** Number of trading pairs. */
    private final int tradingPairs;
    /** boolean indicating if the exchange have a socket. */
    private final boolean socket;
    /** URL of the exchange. */
    private final String exchangeUrl;
    /** Timestamp of the update. */
    private final String updated;

    /** 
     * Exchange constructor.
     * 
     * @param id unique identifier of the exchange.
     * @param name name of the exchange.
     * @param rank rank of the exchange.
     * @param percentTotalVolume percent of the exchanges total volume.
     * @param volumeUsd total volume of the exchanges in USD.
     * @param tradingPairs number of trading pairs.
     * @param socket boolean indicating if the exchange have a socket.
     * @param exchangeUrl URL of the exchange.
     * @param updated timestamp of the update.
     */
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

    /**
     * Retrieves the unique identifier of the exchange.
     *
     * @return the id of the exchange.
     */
    @Override
    public String getId(){ return id; }
    
    /**
     * Retrieves the name of the exchange.
     *
     * @return the name of the exchange.
     */
    @Override
    public String getName() { return name; }

    /**
     * Retrieves the rank of the exchange.
     * 
     * @return the rank of the exchange.
     */
    @Override
    public int getRank() { return rank; }

    /**
     * Retrieves the percent of the exchanges total volume.
     * 
     * @return the percent of the exchanges total volume.
     */
    @Override
    public double getPercentTotalVolume() { return percentTotalVolume; }

    /**
     * Retrieves the total volume of the exchange in USD.
     * 
     * @return the total volume of the exchange in USD.
     */
    @Override
    public double getVolumeUsd() { return volumeUsd; }

    /**
     * Retrieves the number of trading pairs.
     * 
     * @return the number of trading pairs.
     */
    @Override
    public int getTradingPairs() { return tradingPairs; }

    /**
     * Retrieves the boolean indicating if the exchange have a socket.
     * 
     * @return the boolean indicating if the exchange have a socket.
     */
    @Override
    public boolean getSocket() { return socket; }

    /**
     * Retrieves the URL of the exchange.
     * 
     * @return the URL of the exchange.
     */
    @Override
    public String getExchangeUrl() { return exchangeUrl; }

    /**
     * Retrieves the timestamp of the last update.
     *
     * @return the timestamp of the last update.
     */
    @Override
    public String getUpdated() { return updated; }

    /**
     * Returns a string representation of the object.
     * 
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "Id : " + id
            + "\nName : " + name
            + "\nRank : " + rank
            + "\nPercentTotalVolume : " + percentTotalVolume
            + "\nVolumeUsd : " + volumeUsd
            + "\nTraidingPairs : " + tradingPairs
            + "\nSocket : " + socket
            + "\nExchangeUrl : " + exchangeUrl
            + "\nUpdated : " + updated;
    }

}
