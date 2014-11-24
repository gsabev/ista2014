package legacy;

public class FiscalDevice {

    public void registerSaleSum(double price) {
        Object device = findHardwareDevice();
        // use device
    }

    public void registerReturnSum(double price) {
        Object device = findHardwareDevice();
        // use device
    }

    private Object findHardwareDevice() {
        throw new RuntimeException("No fiscal device found");
    }
}

