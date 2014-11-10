package legacy;

import java.util.ArrayList;
import java.util.List;

import legacy.ItemTransaction.Type;

public class CacheRegister {

	private List<ItemTransaction> itemTransactions = null;

	private FiscalDevice fiscalDevice;

	public CacheRegister() {
		this(new FiscalDevice());
	}

	public CacheRegister(FiscalDevice fiscalDevice) {
		this.itemTransactions = new ArrayList<ItemTransaction>();
		this.fiscalDevice = fiscalDevice;
	}

	public boolean sellItem(Item item) {
		fiscalDevice.registerSaleSum(item.getPrice());
		return itemTransactions.add(new ItemTransaction(Type.SALE, item));
	}

	public boolean returnItem(Item item) {
		fiscalDevice.registerReturnSum(item.getPrice());
		if (!itemTransactions.contains(new ItemTransaction(Type.SALE, item))) {
			return false;
		}
		return itemTransactions.add(new ItemTransaction(Type.RETURN, item));
	}

	public boolean scrapItem(Item item) {
		if (sold(item) && !returned(item)) {
			return false;
		}
		return itemTransactions.add(new ItemTransaction(Type.SCRAP, item));
	}

	private boolean sold(Item item) {
		ItemTransaction aSale = new ItemTransaction(Type.SALE, item);
		return itemTransactions.contains(aSale);
	}

	private boolean returned(Item item) {
		ItemTransaction aReturn = new ItemTransaction(Type.RETURN, item);
		return itemTransactions.contains(aReturn);
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

	public int scrappedItems() {
		return count(Type.SCRAP);
	}

	private int count(ItemTransaction.Type type) {
		int total = 0;
		for (ItemTransaction itemTransaction : itemTransactions) {
			if (itemTransaction.getType() == type) {
				++total;
			}
		}
		return total;
	}
}
