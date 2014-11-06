package test;

import legacy.CacheRegister;
import legacy.ItemRegistry;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import stubs.FiscalDeviceStub;

public class CacheRegisterTest {

	public CacheRegister register;
	public ItemRegistry registry;

	@Before
	public void setUp() {
		register = new CacheRegister(new FiscalDeviceStub());
		registry = new ItemRegistry();
	}

	@Test
	public void testSuccesfulSales() {
		register.sellItem(registry, "pen");
		Assert.assertEquals(1, register.successfulSales());
	}

}
