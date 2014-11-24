package legacy;

import java.util.HashMap;
import java.util.Map;

public class ItemCatalog {

	private static final double MISSING_PRICE = Double.NaN;
	
    private static Map CATALOG;
    
    public ItemCatalog() {
    	CATALOG = loadItems();
    }
    
    // load items from external system (DB or web server)
    private Map loadItems() {
    	try {
    		// loading takes time
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
    	
    	return new HashMap();
    }

    // lookup in catalog and return its price
    public double getPrice(Object item) {
    	Double price = (Double) CATALOG.get(item);
        return (price == null) ? MISSING_PRICE : price;
    }
}
