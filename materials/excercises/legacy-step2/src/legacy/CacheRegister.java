package legacy;

import java.util.HashSet;
import java.util.Set;

public class CacheRegister {

	private Set salesData = null;
	private int numberOfSales, numberOfReturns = 0;

	private FiscalDevice fiscalDevice;

	public CacheRegister() {
		this(new FiscalDevice());
	}

	public CacheRegister(FiscalDevice fiscalDevice) {
		this.fiscalDevice = fiscalDevice;
	}

	public boolean sellItem(ItemCatalog registry, String itemName) {
		if (salesData == null) {
			salesData = new HashSet();
		}
		numberOfSales++;
		fiscalDevice.registerSaleSum(registry.getPrice(itemName));
		return salesData.add(itemName);
	}

	public boolean returnItem(ItemCatalog registry, String itemName) {
		if (salesData == null) {
			salesData = new HashSet();
		}
		numberOfReturns++;
		fiscalDevice.registerReturnSum(registry.getPrice(itemName));
		return salesData.remove(itemName);
	}

	public int successfulSales() {
		if (salesData == null) {
			salesData = new HashSet();
		}
		return salesData.size();
	}

	public int totalSales() {
		return numberOfSales;
	}

	public int returnedItems() {
		return numberOfReturns;
	}
}
