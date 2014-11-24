package test;

import legacy.CacheRegister;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CacheRegisterTest {

	public CacheRegister register;

	@Before
	public void setUp() {
		register = new CacheRegister();
	}

	@Test
	public void testSuccesfulSales() {
		// TODO: Test sellItem method
		
		Assert.assertEquals(1, register.successfulSales());
	}

}
