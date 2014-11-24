package legacy;

public class ItemRegistry {

    private static final int MAX_ITEM_PRICE = 100;
    
    public ItemRegistry() {
    	loadItems();
    }
    
    private void loadItems() {
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
    }

    // lookup in registry and return its price
    public double getPrice(Object item) {
        return Math.random() * MAX_ITEM_PRICE;
    }
}
