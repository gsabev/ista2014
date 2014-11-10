package legacy;

import java.util.ArrayList;
import java.util.List;

public class CacheRegister {

	private List<Item> salesData = null;
	private int numberOfSales, numberOfReturns = 0;

	private FiscalDevice fiscalDevice;

	public CacheRegister() {
		this(new FiscalDevice());
	}

	public CacheRegister(FiscalDevice fiscalDevice) {
		this.salesData = new ArrayList<Item>();
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
