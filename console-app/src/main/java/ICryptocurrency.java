/**
 * Java interface of a cryptocurrency.
 * 
 * @author Grégoire Pierrot.
 */
public interface ICryptocurrency {
    /**
     * Get the Cryptcurrency id.
     * 
     * @return the Cryptocurrency id.
     */
    String getId();
    
    /**
     * Get the Cryptcurrency rank.
     * 
     * @return the Cryptocurrency rank.
     */
    int getRank();

    /**
     * Get the Cryptcurrency symbol.
     * 
     * @return the Cryptocurrency symbol.
     */
    String getSymbol();

    /**
     * Get the Cryptcurrency name.
     * 
     * @return the Cryptocurrency name.
     */
    String getName();

    /**
     * Get the Cryptcurrency supply.
     * 
     * @return the Cryptocurrency supply.
     */
    double getSupply();

    /**
     * Get the Cryptcurrency maxSupply.
     * 
     * @return the Cryptocurrency maxSupply.
     */
    double getMaxSupply();

    /**
     * Get the Cryptcurrency marketCapUsd.
     * 
     * @return the Cryptocurrency marketCapUsd.
     */
    double getMarketCapUsd();

    /**
     * Get the Cryptcurrency volume24Hr.
     * 
     * @return the Cryptocurrency volume24Hr.
     */
    double getVolumeUsd24Hr();

    /**
     * Get the Cryptcurrency priceUsd.
     * 
     * @return the Cryptocurrency priceUsd.
     */
    double getPriceUsd();

    /**
     * Get the Cryptcurrency changerPercent24Hr.
     * 
     * @return the Cryptocurrency changerPercent24Hr.
     */
    double getChangePercent24Hr();

    /**
     * Get the Cryptcurrency vwap24Hr.
     * 
     * @return the Cryptocurrency vwap24Hr.
     */
    double getVwap24Hr();

    /**
     * Get the Cryptcurrency timestamp.
     * 
     * @return the Cryptocurrency timestmp.
     */
    String getTimestamp();

    /**
     * Returns a string representation of the object.
     * 
     * @return a string representation of the object.
     */
    String toString();
}
