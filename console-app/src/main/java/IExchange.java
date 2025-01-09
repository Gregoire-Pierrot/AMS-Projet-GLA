/**
 * Java interface of an exchange.
 * 
 * @author Grégoire Pierrot.
 */
public interface IExchange {
    /**
     * Retrieves the unique identifier of the exchange.
     *
     * @return the id of the exchange.
     */
    String getId();
    
    /**
     * Retrieves the name of the exchange.
     *
     * @return the name of the exchange.
     */
    String getName();
    
    /**
     * Retrieves the rank of the exchange.
     * 
     * @return the rank of the exchange.
     */
    int getRank();
    
    /**
     * Retrieves the percent of the exchanges total volume.
     * 
     * @return the percent of the exchanges total volume.
     */
    double getPercentTotalVolume();
    
    /**
     * Retrieves the total volume of the exchange in USD.
     * 
     * @return the total volume of the exchange in USD.
     */
    double getVolumeUsd();
    
    /**
     * Retrieves the number of trading pairs.
     * 
     * @return the number of trading pairs.
     */
    int getTradingPairs();
    
    /**
     * Retrieves the boolean indicating if the exchange have a socket.
     * 
     * @return the boolean indicating if the exchange have a socket.
     */
    boolean getSocket();
    
    /**
     * Retrieves the URL of the exchange.
     * 
     * @return the URL of the exchange.
     */
    String getExchangeUrl();
    
    /**
     * Retrieves the timestamp of the last update.
     *
     * @return the timestamp of the last update.
     */
    String getUpdated();
    
    /**
     * Returns a string representation of the object.
     * 
     * @return a string representation of the object.
     */
    String toString();
}
