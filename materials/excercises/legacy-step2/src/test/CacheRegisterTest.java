package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import legacy.CacheRegister;
import legacy.ItemRegistry;

import org.junit.Before;
import org.junit.Test;

import stubs.FiscalDeviceStub;
import stubs.ItemRegistryStub;

public class CacheRegisterTest {

	public CacheRegister register;
	public ItemRegistry registry;

	@Before
	public void setUp() {
		register = new CacheRegister(new FiscalDeviceStub());
		registry = new ItemRegistryStub();
	}

	@Test
	public void testSuccesfulSales() {
		boolean successfulSale = register.sellItem(registry, "pen");
		assertTrue(successfulSale);
		assertEquals(1, register.successfulSales());
	}

	@Test
	public void testMultipleSuccessfulSales() {
		boolean sale1 = register.sellItem(registry, "pen");
		boolean sale2 = register.sellItem(registry, "pencil");
		boolean sale3 = register.sellItem(registry, "rubber");
		assertTrue(sale1 && sale2 && sale3);
		assertEquals(3, register.successfulSales());
	}

	@Test
	public void testSellSeveralOfOneType() {
		boolean sale1 = register.sellItem(registry, "pen");
		boolean sale2 = register.sellItem(registry, "pen");
		// TODO : Fix bug CR-325 (logged)
		// It should be possible to sell two pens

		// assertTrue(sale1 && sale2);
		// assertEquals(2, register.successfulSales());
		assertEquals(true, sale1);
		assertEquals(false, sale2);
		assertEquals(1, register.successfulSales());
	}

	@Test
	public void testReturnItem() {
		register.sellItem(registry, "defective pen");
		boolean successfulReturn = register.returnItem(registry,
				"defective pen");
		assertTrue(successfulReturn);
		assertEquals(1, register.returnedItems());
	}

	@Test
	public void testReturnNoSales() {
		boolean successfulReturn = register.returnItem(registry, "pen");
		assertEquals(false, successfulReturn);
		// TODO : fix bug CR-345 (logged). Unsuccessful returns should
		// not be counted

		// assertEquals(0, register.returnedItems());
		assertEquals(1, register.returnedItems());
	}

	@Test
	public void testUnsuccessfulReturn() {
		register.sellItem(registry, "pen");
		boolean success = register.returnItem(registry, "bird");
		assertEquals(false, success);
		// TOTO : Bug CR-345 (see above)
		// assertEquals(0, register.returnedItems());
		assertEquals(1, register.returnedItems());
	}

	@Test
	public void testTotalSales() {
		register.sellItem(registry, "pen");
		register.sellItem(registry, "pencil");
		register.returnItem(registry, "pen");
		assertEquals(2, register.totalSales());
	}
}
