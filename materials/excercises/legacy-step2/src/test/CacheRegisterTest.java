package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import legacy.CacheRegister;
import legacy.ItemCatalog;

import org.junit.Before;
import org.junit.Test;

import stubs.FiscalDeviceStub;
import stubs.ItemCatalogStub;

public class CacheRegisterTest {

	public CacheRegister register;
	public ItemCatalog catalog;

	@Before
	public void setUp() {
		register = new CacheRegister(new FiscalDeviceStub());
		catalog = new ItemCatalogStub();
	}

	@Test
	public void testSuccesfulSales() {
		boolean successfulSale = register.sellItem(catalog, "pen");
		assertTrue(successfulSale);
		assertEquals(1, register.successfulSales());
	}

	@Test
	public void testMultipleSuccessfulSales() {
		boolean sale1 = register.sellItem(catalog, "pen");
		boolean sale2 = register.sellItem(catalog, "pencil");
		boolean sale3 = register.sellItem(catalog, "rubber");
		assertTrue(sale1 && sale2 && sale3);
		assertEquals(3, register.successfulSales());
	}

	@Test
	public void testSellSeveralOfOneType() {
		boolean sale1 = register.sellItem(catalog, "pen");
		boolean sale2 = register.sellItem(catalog, "pen");
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
		register.sellItem(catalog, "defective pen");
		boolean successfulReturn = register.returnItem(catalog,
				"defective pen");
		assertTrue(successfulReturn);
		assertEquals(1, register.returnedItems());
	}

	@Test
	public void testReturnNoSales() {
		boolean successfulReturn = register.returnItem(catalog, "pen");
		assertEquals(false, successfulReturn);
		// TODO : fix bug CR-345 (logged). Unsuccessful returns should
		// not be counted

		// assertEquals(0, register.returnedItems());
		assertEquals(1, register.returnedItems());
	}

	@Test
	public void testUnsuccessfulReturn() {
		register.sellItem(catalog, "pen");
		boolean success = register.returnItem(catalog, "bird");
		assertEquals(false, success);
		// TOTO : Bug CR-345 (see above)
		// assertEquals(0, register.returnedItems());
		assertEquals(1, register.returnedItems());
	}

	@Test
	public void testTotalSales() {
		register.sellItem(catalog, "pen");
		register.sellItem(catalog, "pencil");
		register.returnItem(catalog, "pen");
		assertEquals(2, register.totalSales());
	}
}
