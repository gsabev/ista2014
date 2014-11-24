package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import legacy.CacheRegister;
import legacy.Item;

import org.junit.Before;
import org.junit.Test;

import stubs.FiscalDeviceStub;

public class CacheRegisterTest {

	public CacheRegister register;

	@Before
	public void setUp() {
		register = new CacheRegister(new FiscalDeviceStub());
	}

	@Test
	public void testSuccesfulSales() {
		boolean successfulSale = register.sellItem(new Item("pen", 2.99));
		assertTrue(successfulSale);
		assertEquals(1, register.successfulSales());
	}

	@Test
	public void testMultipleSuccessfulSales() {
		boolean sale1 = register.sellItem(new Item("pen", 2.99));
		boolean sale2 = register.sellItem(new Item("pencil", 1.55));
		boolean sale3 = register.sellItem(new Item("rubber", 0.75));
		assertTrue(sale1 && sale2 && sale3);
		assertEquals(3, register.successfulSales());
	}

	@Test
	public void testSellSeveralOfOneType() {
		Item pen = new Item("pen", 2.99);
		boolean sale1 = register.sellItem(pen);
		boolean sale2 = register.sellItem(pen);

		assertTrue(sale1 && sale2);
		assertEquals(2, register.successfulSales());
	}

	@Test
	public void testReturnItem() {
		Item defectivePen = new Item("defective pen", 5.00);
		register.sellItem(defectivePen);
		boolean successfulReturn = register.returnItem(defectivePen);
		assertTrue(successfulReturn);
		assertEquals(1, register.returnedItems());
	}

	@Test
	public void testReturnNoSales() {
		boolean successfulReturn = register.returnItem(new Item("pen", 2.99));
		assertEquals(false, successfulReturn);
		assertEquals(0, register.returnedItems());
	}

	@Test
	public void testUnsuccessfulReturn() {
		register.sellItem(new Item("pen", 2.99));
		boolean success = register.returnItem(new Item("bird", 21.99));
		assertEquals(false, success);
		assertEquals(0, register.returnedItems());
	}

	@Test
	public void testTotalSales() {
		register.sellItem(new Item("pen", 2.99));
		Item pencil = new Item("pencil", 1.55);
		register.sellItem(pencil);
		register.returnItem(pencil);
		assertEquals(2, register.totalSales());
	}

	@Test
	public void testSctrapNewItem() {
		boolean success = register.scrapItem(new Item("pen", 2.99));
		assertTrue(success);
		assertEquals(1, register.scrappedItems());
	}

	@Test
	public void testSctrapReturnedItem() {
		Item pen = new Item("pen", 2.99);
		register.sellItem(pen);
		register.returnItem(pen);
		boolean success = register.scrapItem(pen);
		assertTrue(success);
		assertEquals(1, register.scrappedItems());
	}

	@Test
	public void testSctrapSoldItem() {
		Item pen = new Item("pen", 2.99);
		register.sellItem(pen);
		boolean success = register.scrapItem(pen);
		assertEquals(false, success);
		assertEquals(0, register.scrappedItems());
	}
}
