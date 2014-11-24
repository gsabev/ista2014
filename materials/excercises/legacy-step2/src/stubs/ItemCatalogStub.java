package stubs;

import java.util.HashMap;
import java.util.Map;

import legacy.ItemCatalog;

public class ItemCatalogStub extends ItemCatalog {

	@Override
	public Map loadItems() {
		// fake content
    	Map externalCatalog = new HashMap();
    	externalCatalog.put("pen", 2.50);
    	externalCatalog.put("pencil", 1.25);
    	externalCatalog.put("rubber", 2.49);
    	return externalCatalog;
	}
}
