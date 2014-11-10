package legacy;

import java.util.HashSet;
import java.util.Set;

public class CacheRegister {

	private Set<Item> salesData = null;
	private int numberOfSales, numberOfReturns = 0;

	private FiscalDevice fiscalDevice;

	public CacheRegister() {
		this(new FiscalDevice());
	}

	public CacheRegister(FiscalDevice fiscalDevice) {
		this.salesData = new HashSet<Item>();
		this.fiscalDevice = fiscalDevice;
	}

	public boolean sellItem(Item item) {
		numberOfSales++;
		fiscalDevice.registerSaleSum(item.getPrice());
		return salesData.add(item);
	}

	public boolean returnItem(Item item) {
		numberOfReturns++;
		fiscalDevice.registerReturnSum(item.getPrice());
		return salesData.remove(item);
	}

	public int successfulSales() {
		return salesData.size();
	}

	public int totalSales() {
		return numberOfSales;
	}

	public int returnedItems() {
		return numberOfReturns;
	}
}
