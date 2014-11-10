package legacy;

import java.util.ArrayList;
import java.util.List;

import legacy.ItemTransaction.Type;

public class CacheRegister {

	private List<ItemTransaction> salesData = null;

	private FiscalDevice fiscalDevice;

	public CacheRegister() {
		this(new FiscalDevice());
	}

	public CacheRegister(FiscalDevice fiscalDevice) {
		this.salesData = new ArrayList<ItemTransaction>();
		this.fiscalDevice = fiscalDevice;
	}

	public boolean sellItem(Item item) {
		fiscalDevice.registerSaleSum(item.getPrice());
		return salesData.add(new ItemTransaction(Type.SALE, item));
	}

	public boolean returnItem(Item item) {
		fiscalDevice.registerReturnSum(item.getPrice());
		if (!salesData.contains(new ItemTransaction(Type.SALE, item))) {
			return false;
		}
		return salesData.add(new ItemTransaction(Type.RETURN, item));
	}

	public int successfulSales() {
		return count(Type.SALE) - count(Type.RETURN);
	}

	public int totalSales() {
		return count(Type.SALE);
	}

	public int returnedItems() {
		return count(Type.RETURN);
	}

	private int count(ItemTransaction.Type type) {
		int total = 0;
		for (ItemTransaction itemTransaction : salesData) {
			if (itemTransaction.getType() == type) {
				++total;
			}
		}
		return total;
	}
}
