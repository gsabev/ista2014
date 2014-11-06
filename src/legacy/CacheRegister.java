package legacy;

import set.ArraySet;

public class CacheRegister {

    private ArraySet salesData = null;
    private int numberOfSales, numberOfReturns = 0;

    private FiscalDevice fiscalDevice;

    public CacheRegister() {
        this(new FiscalDevice());
    }

    public CacheRegister(FiscalDevice fiscalDevice) {
        this.fiscalDevice = fiscalDevice;
    }

    public boolean sellItem(ItemRegistry registry, String itemName) {
        if (salesData == null) {
            salesData = new ArraySet();
        }
        numberOfSales++;
        fiscalDevice.registerSaleSum(registry.getPrice(itemName));
        return salesData.add(itemName);
    }

    public boolean returnItem(ItemRegistry registry, String itemName) {
        if (salesData == null) {
            salesData = new ArraySet();
        }
        numberOfReturns++;
        fiscalDevice.registerReturnSum(registry.getPrice(itemName));
        return salesData.remove(itemName);
    }

    public int successfulSales() {
        if (salesData == null) {
            salesData = new ArraySet();
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
